package demo;
import java.sql.*;


public class testclass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","oracle");
		System.out.println("connectd to database");
		Statement st=con.createStatement();
		String query="SELECT * FROM Persons";
		ResultSet rs= st.executeQuery(query);
		
		while (rs.next()){
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
		st.close();
		con.close();
		
		}
		catch (Exception e) 
		{
			System.out.println("error");
		}
		
		
		
	}

}
