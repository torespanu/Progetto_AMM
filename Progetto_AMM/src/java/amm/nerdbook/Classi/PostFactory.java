package amm.nerdbook.Classi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


/**
 * @author Salvatore Spanu 65219
 */
public class PostFactory {
    private static PostFactory singleton;
        
    private String connectionString;

    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    
    private PostFactory() {
    }
        
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    private ArrayList<Post> listaPost = new ArrayList<Post>();

public Post getPostById(int id) {        
        NerdFactory nerdFactory = NerdFactory.getInstance();
        
            try {
                Connection conn = DriverManager.getConnection(connectionString, "nerdbook", "nerdbook");

                String query = 
                          "select * from posts "
                        + "join posttype on posts.type = posttype.posttype_id "
                        + "where post_id = ?";

                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);

                ResultSet res = stmt.executeQuery();

                if (res.next()) {
                    Post current = new Post();
                    current.setId(res.getInt("post_id"));
                    current.setContent(res.getString("content"));
                    current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                    Nerd autore = nerdFactory.getNerdById(res.getInt("author"));
                    current.setUser(autore);

                    stmt.close();
                    conn.close();
                    return current;
                }

                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;

        }
        public List getPostList(Nerd nrd) {
            List<Post> listaPost = new ArrayList<Post>();


       try {
                Connection conn = DriverManager.getConnection(connectionString, "nerdbook", "nerdbook");

                String query = 
                          "select * from posts "
                        + "join posttype on posts.type = posttype.posttype_id "
                        + "where author = ?";

                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, nrd.getId());

                ResultSet res = stmt.executeQuery();

                while (res.next()) {

                    Post current = new Post();
                    current.setId(res.getInt("post_id"));
                    current.setContent(res.getString("content"));
                    current.setPostType(this.postTypeFromString(res.getString("posttype_name")));
                    current.setUser(nrd);
                    listaPost.add(current);
                }

                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return listaPost;
        }
        public void addNewPost(Post post){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "gato", "gato");
            
            String query = 
                      "insert into posts (post_id, content, type, author) "
                    + "values (default, ? , ? , ? )";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, post.getContent());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getUser().getId());
            
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        if(type == Post.Type.TEXT)
                return 1;
            else
                return 2;
    }
    
}


