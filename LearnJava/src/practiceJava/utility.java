package practiceJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class utility { 


	public static String readrec(String Filename)

	{

	// ====================================================================

	// Read the Rec

	// ====================================================================

	BufferedReader br = null;

	FileReader fr = null;

	String sCurrentLine="";

	String retrec="";

	try {

	fr = new FileReader(Filename);

	br = new BufferedReader(fr);

	while ((sCurrentLine = br.readLine()) != null) {

	retrec=retrec + sCurrentLine+";";

	}

	} catch (IOException e) {

	e.printStackTrace();

	} finally {


	try {

	if (br != null)

	br.close();

	if (fr != null)

	fr.close();

	} catch (IOException ex) {

	ex.printStackTrace();

	}

	}

	return retrec;

	}

public static String readdb(String sql,String dbnm)
{
// =======================================================

try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
       		Statement st=null;
		ResultSet rs = null;
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
 	 	Connection cn = DriverManager.getConnection( url, "bud", "bud" );

     
	
            System.out.println("connection worked");
// =============================================================

		st = cn.createStatement();
		rs = st.executeQuery( sql );

                
  		String queryStringuser="";
  		//SimpleDateFormat sdfDestination=null;
  		int count=0;
  		String strcolor = "";
  		while(rs.next())
  		{


String ret=rs.getString(1) +" , "+ rs.getString(2)+" , "+ rs.getString(3)+" , "+ rs.getString(4)+" , "+ rs.getString(5) ;
System.out.println(ret);
		//System.out.println(rs.getString(1) +" , "+ rs.getString(2)+" , "+ rs.getString(3)+" , "+ rs.getString(4)+" , "+ rs.getString(5) );


}
cn.close();
       
}
	catch (Exception e)
	{
			
 		 e.printStackTrace();
    
}

// =========================================================
       return "db values";

}
public  static  void  writereport(String msg)
{


}

public static void verifydata(String Data)
{

}
public  static  void  getInput()
{
       Scanner sc  = new Scanner(System.in);
       System.out.println("Enter  1 to read filr ");
       System.out.println("Enter 2 to write ");
       System.out.println("Enter 3 to exit ");
       String  nm = sc.nextLine();
       
       if (nm.contains("1")){
    	   nm = sc.nextLine();
       System.out.println("reading file  " );
       
       
       }
       
       if (nm.contains("2")){
    	   String  nm1 = sc.nextLine();
           System.out.println("writing file  " );
               
       }
       if (nm.contains("3")){
           System.exit(0);}
        }
        		
      // String val="Gupta";
      // return  val;
}