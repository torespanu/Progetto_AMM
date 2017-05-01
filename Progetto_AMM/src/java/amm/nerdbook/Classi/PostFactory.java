/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Salvatore Spanu 65219
 */
public class PostFactory {
    private static PostFactory singleton;
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    private PostFactory() {
        NerdFactory nerdFactory = NerdFactory.getInstance();

        Post post1 = new Post();
        post1.setContent("Ciao, questo è un primo messaggio lasciato in bacheca");
        post1.setId(0);
        post1.setUser(nerdFactory.getNerdById(0));
        post1.setPostType(Post.Type.TEXT);

        Post post2 = new Post();
        post2.setContent("Ciao, questo è il secondo messaggio lasciato in bacheca");
        post2.setId(1);
        post2.setUser(nerdFactory.getNerdById(0));
        post2.setPostType(Post.Type.TEXT);

        Post post3 = new Post();
        post3.setContent("Ciao, questo è il terzo messaggio lasciato in bacheca");
        post3.setId(2);
        post3.setUser(nerdFactory.getNerdById(0));
        post3.setPostType(Post.Type.TEXT);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(Nerd nrd) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(nrd)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
