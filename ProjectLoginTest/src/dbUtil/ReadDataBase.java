package dbUtil;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fileutil.WriteToFile;
import miscutil.Prop;

public class ReadDataBase {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
		
	public static boolean chkUserExistance (String dbUrl,String dbUserid,
	String dbPassword,String username,String password,String sql) throws SQLException{
	 
		String oracleDriver ="oracle.jdbc.driver.OracleDriver";
		boolean sqlrec = false;
	//sql = "select * from USERTBL1 where usrname='"+username+ "'and pasword='"+password+"' ";
		try {
			Class.forName(oracleDriver);
			conn=DriverManager.getConnection(dbUrl,dbUserid,dbPassword);
	//		System.out.println("connected");
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if( rs.next())
			{
			sqlrec = rs != null;
			sqlrec = true;
			System.out.println("User exist");		
			}
			else{
			System.out.println("User doesn't exist");
			
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return sqlrec;
		}

}
