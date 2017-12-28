package miscutil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class Prop {
	
	public static String readdbprop() throws IOException{
	Properties props = new Properties();
	FileInputStream in = new FileInputStream("C:\\mukitheclipse\\ProjectLoginTest\\Property\\db.properties");
	props.load(in);
	String dburl = props.getProperty("dbUrl");
	String dbuserid = props.getProperty("dbUserid");
	String dbpassword = props.getProperty("dbPassword");
	String dbsql=props.getProperty("sql");
  String retrec=dburl + ","  +dbuserid +","+ dbpassword+","+dbsql;
	  in.close();
	return retrec;
	}

	
	public static  String readprop() throws IOException
   {
  Properties props = new Properties();
  FileInputStream in = new FileInputStream("C:\\mukitheclipse\\ProjectLoginTest\\Property\\property.properties");
  props.load(in);
 // ========================================================
//           Getting the Filename from the properties file 
 // ========================================================
  String url = props.getProperty("url");
     String expTitle = props.getProperty("expTitle");
    String browser = props.getProperty("browser");
    String inpfilenm=props.getProperty("Filename");
    String expTitleH = props.getProperty("expTitleH");
    String expTitleError =props.getProperty("expTitleError");
   //  String expectedH1 =  props.getProperty("expectedH1");
     
 // ========================================================
     //String retrec=url + ","  + expTitle + "," + inpfilenm + "," + expectedH1;
  //System.out.println(retrec);
     String retrec=browser + ","  +url +","+ expTitle+","+inpfilenm+","+ expTitleH+","+expTitleError;
     
    in.close();
         return retrec;
   }
 }
