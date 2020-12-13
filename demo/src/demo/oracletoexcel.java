package demo;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
//oracle data export into excel sheet
public class oracletoexcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","oracle");
		System.out.println("connectd to database");
		Statement st=con.createStatement();
		String query="SELECT * FROM Persons";
		ResultSet rs= st.executeQuery(query);
		
		HSSFWorkbook wb = new HSSFWorkbook();   
		HSSFSheet sheet = wb.createSheet("test");
		HSSFRow rowhead= sheet.createRow((short) 0);
		rowhead.createCell((short) 0).setCellValue("ID");
		rowhead.createCell((short) 1).setCellValue("LASTNAME");
		rowhead.createCell((short) 2).setCellValue("FIRSTNAME");
		rowhead.createCell((short) 3).setCellValue("ADDRESS");
		rowhead.createCell((short) 4).setCellValue("CITY");
        int index=1;
        while (rs.next()){
        	HSSFRow row= sheet.createRow((short) index);
        	row.createCell((short) 0).setCellValue(rs.getString(1));
    		row.createCell((short) 1).setCellValue(rs.getString(2));
    		row.createCell((short) 2).setCellValue(rs.getString(3));
    		row.createCell((short) 3).setCellValue(rs.getString(4));
    		row.createCell((short) 4).setCellValue(rs.getString(5));
    		index++;
        	//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
        File fileOut = new File("C:\\file\\BankStatement8.xls"); 
        FileOutputStream fos=new FileOutputStream(fileOut);
        System.out.println("Excel File has been created successfully.");   
        wb.write(fileOut);  
        wb.close();
		st.close();
		con.close();
		}
		catch (Exception e) 
		{
			System.out.println("error");
		}
		
		
		
	}

}