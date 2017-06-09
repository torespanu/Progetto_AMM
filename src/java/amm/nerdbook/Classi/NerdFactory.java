/**
 *
 * @author Salvatore Spanu 65219
 */
package amm.nerdbook.Classi;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class NerdFactory {
    private String connectionString;
    
    private static NerdFactory singleton;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
            return this.connectionString;
    }
    
    public static NerdFactory getInstance() {
        if (singleton == null) {
            singleton = new NerdFactory();
        }
        return singleton;
    }
    private ArrayList<Nerd> listaNerds = new ArrayList<Nerd>();
    
    private NerdFactory() {
    }
    
    public Nerd getNerdById(int id) {
        try{
            Connection conn = DriverManager.getConnection(connectionString, "nerdbook", "nerdbook");
            String query = "select * from nerds where nerd_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                Nerd current = new Nerd();
                current.setId(res.getInt("nerd_id"));
                current.setUsername(res.getString("username"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                //current.setTipoUtente(res.getBoolean("tipoUtente"));

                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
        
    }
    
    public int getIdByUserAndPassword(String user, String password){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "nerdbook", "nerdbook");
            String query = "select nerd_id from nerds where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                int id = res.getInt("nerd_id");
                stmt.close();
                conn.close();
                return id;
            }
            stmt.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public List getNerdsList() {
        List<Nerd> listaNerds = new ArrayList<Nerd>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "nerdbook", "nerdbook");
            
            String query = 
                      "select * from nerds";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Nerd current = new Nerd();
                current.setId(res.getInt("nerd_id"));
                current.setUsername(res.getString("username"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                
                listaNerds.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaNerds;
    }
    
    public List getNerdsList(String name) {
        List<Nerd> listaNerds = new ArrayList<Nerd>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "nerdbook", "nerdbook");
            
            String query = 
                      "select * from nerds where name like ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, "%" + name + "%");
            
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Nerd current = new Nerd();
                current.setId(res.getInt("nerd_id"));
                current.setUsername(res.getString("username"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                current.setFrasePresentazione(res.getString("frasePresentazione"));
                current.setDataNascita(res.getString("dataNascita"));
                current.setPassword(res.getString("password"));
                current.setEmail(res.getString("email"));
                
                listaNerds.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaNerds;
    }
}

