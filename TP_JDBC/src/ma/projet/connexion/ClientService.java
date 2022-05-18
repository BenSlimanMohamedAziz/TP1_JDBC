package ma.projet.connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IDao<client>{

	public boolean create(client c) {
        try {
            String r = "insert into client (nom, prenom) values ('" + c.getNom() + "', '" + c.getPrenom() + "')";
            Statement statement = connexion.getCon().createStatement();
            if (statement.executeUpdate(r) == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " +e.getMessage());
        }
        return false;
    }
	 @Override
	    public boolean update(client c) {
	        try {
	            String r = "update client set nom ='"+c.getNom()+"', prenom ='"+c.getPrenom()+"' where id = "+c.getId();
	            Statement statement = connexion.getCon().createStatement();
	            if(statement.executeUpdate(r) == 1)
	                return true;
	        } catch (SQLException e) {
	        	   System.out.println("Error executing query: " +e.getMessage());
	        }
	        return false;
	    }
	 @Override
	    public boolean delete(client c) {
	        try {
	        	PreparedStatement pstmt = connexion.getCon().prepareStatement("delete from client where id=?");
	        	pstmt.setInt(1,c.getId());
	            if (pstmt.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	        	   System.out.println("Error executing query: " +e.getMessage());
	        }
	        return false;
	    }
	 
	 @Override
	 public client findById(int id) {
	   try {
          Statement statement = connexion.getCon().createStatement();
          ResultSet result = statement.executeQuery("select * from client where id="+id);
          if (result.next()) {
              return new client(result.getInt("id"), result.getString("nom"), result.getString("prenom"));
          }
      } catch (SQLException e) {
   	   System.out.println("Error executing query: " +e.getMessage());
   }
      return null;
}
	
	  @Override
	    public List<client> findAll() {
	        List<client> clients = new ArrayList<>();
	        try {
	        	PreparedStatement pstmt = connexion.getCon().prepareStatement("select * from client");
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                clients.add(new client(rs.getInt("Id"), rs.getString("nom"), rs.getString("prenom")));
	            }
	 
	        } catch (SQLException e) {
	        	   System.out.println("Error executing query: " +e.getMessage());
	        }
	        return clients;
	    }
}
