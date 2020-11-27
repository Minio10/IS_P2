package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EJBResearch
 */
@Stateless
@LocalBean
public class EJBResearch implements EJBResearchRemote, EJBResearchLocal {

    /**
     * Default constructor. 
     */
    public EJBResearch() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    //Obtain all from researchers
    public  void InfoResearchers() {
    	
    	 final String name = "postgres";
    	 final String password = "calmo";
    	 final String tablename = "researcher";
    	 final String url = "jdbc:postgresql://localhost/postgres";
    	 
    	 try
    	 {
	    	 Connection conn = (Connection) DriverManager.getConnection(url,name, password);
	    	 Statement stmt = (Statement) conn.createStatement();
	    	 ResultSet rs;
	    	 rs = stmt.executeQuery("SELECT * FROM " + tablename);
	    	 while (rs.next())
	    	 {
		    	 Long id = rs.getLong("id");
		    	 String rName = rs.getString("name");
		    	 int citations = rs.getInt("citations");
		    	 int publications = rs.getInt("publications");
		    	 int reads = rs.getInt("reads");
		    	 String sql = "SELECT * FROM institution_researcher WHERE";
		    	 sql += "instiresearchers_id = ?";
		    	 PreparedStatement ps = conn.prepareStatement(sql);
		    	 ps.setLong(1, id);
		    	 ResultSet rs1 = ps.executeQuery();
		    	 
		    	 Long instID = rs1.getLong("institution_id");
		    	 sql = "SELECT * FROM institution WHERE";
			     sql += "id = ?";
			     ps = conn.prepareStatement(sql);
			     ps.setLong(1, instID);
			     ResultSet rs2 = ps.executeQuery();
			     String InstName = rs2.getString("name");
		    	 
		    	 
		    	 
		    	 
		    	 System.out.println("CALMO");
		    	 System.out.println(id + ": " + rName + " " + citations + "-"+publications +"-" +reads);
		    	 System.out.println(InstName);
	    	 }
	    	 conn.close();
	    	 }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	     }
    	
    	
    	
    	
    }

}
