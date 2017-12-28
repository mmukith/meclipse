package mainp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

//import dbUtil.OracleUtil;
import dbUtil.ReadDataBase;
import fileutil.ReadFile;
//import fileutil.Writ2file;
//import fileutil.WriteReport;
import fileutil.WriteToFile;
import miscutil.DiffOtherFunc;
import miscutil.Prop;
import pagelib.LoginPage;
import testBase.TestBaseSetup;

public class MainApp {
	static String content4="";
	static String content5 ="";
	static String content2 ="";
	static String content3 ="";
	static String username="";
	static String password="";
	static String[] recf = null;
	static String sql = "";
	static boolean res1=false;
	static boolean res2 =false;
	static String unm;
	static String msg;
	static String msg2;
	static String msg3;
	//static WebDriver driver;
	public static void main(String[] args) throws Exception {
		TestBaseSetup invkbrowser = new TestBaseSetup();
		Prop pr = new Prop();
		DiffOtherFunc df = new DiffOtherFunc();
		LoginPage lp= new LoginPage();
		ReadFile rf = new ReadFile();
		ReadDataBase rdb = new ReadDataBase();
		
		//String FILENAME = System.getProperty("user.dir")+"\\Report\\report.txt";
		//WriteReport wr =new WriteReport(FILENAME);
		
		WriteToFile w2f = new WriteToFile();
		String Filenm = "C:\\mukitheclipse\\ProjectLoginTest\\Report\\Report.txt";
		FileWriter fw = new FileWriter( Filenm);
		BufferedWriter bw = new BufferedWriter (fw);
		 String QAname = "Mark";
		//String msg ="Liton";
		
		
//reading property file and splitting by index
		String allprop=pr.readprop();
		System.out.println("allprop=" + allprop);	     
		String browsr=allprop.split(",")[0];
		String url=allprop.split(",")[1];
		String expTitle=allprop.split(",")[2];
		String Filename=allprop.split(",")[3];
		String expTitleH=allprop.split(",")[4];
		String expTitleError = allprop.split(",")[5];
//reading database properties and splitting by index
		 String allprop1=pr.readdbprop();
		 String dbUrl=allprop1.split(",")[0];
		 String dbUserid=allprop1.split(",")[1];
		 String dbPassword=allprop1.split(",")[2];
//reading input file and splitting all records		 
		String input = rf.readrec(Filename);
		System.out.println("input: ==>"+input);
		String[] inputData=input.split(";");
	
//loop will continue until input file dosen't have records 
		invkbrowser.setDriver(browsr, url);
		Thread.sleep(3000);
		int i=0;	
		int j=0;
		//w2f.reportSummery(bw, QAname);	
	for ( i=0;i<inputData.length;i++){
	String recx = inputData[i];
	System.out.println("TC NO: "+(i+1)+" & input are : "+recx);
	//content3="Test case no: "+i+" & input are : "+recx+"\n";
	//System.out.println(msg);
	msg="TC NO: "+(i+1)+" & INPUT : "+recx;
	//w2f.reportSummery(bw,fw,QAname);
	w2f.wrtReport( bw, msg);
	recf= recx.split(",");
	System.out.println("REC "+recx);
	//unm=recf[j];
	 username=recf[j];
	 System.out.println("username length : "+username.length());
	 String pwd =recf[j+1];
 if(pwd.valueOf("")== null){
	 System.out.println("pwd length ==> "+recf[j+1].length());
	 password = "";
	 }else{
		 password = recf[j+1];
System.out.println("pwd length ==> "+recf[j+1].length());
	 }
	 
	 
	 
	 //System.out.println(recf[j+1].length());
	 /*if((recf[j+1].isEmpty() && recf[j+1].trim().equals(""))== null  ){	
		 password = "kk";
	 }else {
		 password = recf[j+1];
	 }
	*/ 
	 //System.out.println("read username from input file "+username);
	 //System.out.println("read password from input file "+password);

 sql = "Select *from Usertbl1 where usrname = '"+username +"' and pasword = '"+password+"'";
//verifying input data with database 
 boolean tf = rdb.chkUserExistance(dbUrl, dbUserid, dbPassword, username, dbPassword,sql);

//getting actual title
 String Acttitle=invkbrowser.getDriver().getTitle();

 //populated the input data from input file
  lp.enterUserInfo(username, password);
  
//wait force fully
 Thread.sleep(2000);
//clicking on submit button
 lp.clickOnSubmit();

//getting actual home page title  
String ActtitleH=invkbrowser.getDriver().getTitle();
invkbrowser.driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//System.out.println(ActtitleH);
//getting actual Error page title
String ActtitleError=invkbrowser.getDriver().getTitle();     
invkbrowser.driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//Comparing expected title with actual tiatle
res1=df.compareString(ActtitleH, expTitleH);
res2 = df.compareString(ActtitleError, expTitleError);
 if (res1){
    System.out.println("Actual home Title " + ActtitleH + " is equal " + expTitleH);
     content4="Actual home Title " + ActtitleH + " is equal " + expTitleH;	
     w2f.wrtReport( bw, content4);
     msg2 ="<===Test case Passed===>";
     w2f.wrtReport( bw, msg2);

     System.out.println("");
   
} else if (res2){
    System.out.println("Error page Title " + ActtitleError + " is EQUAL " +expTitleError);
   content5="Error page Title " + ActtitleError + " is EQUAL " +expTitleError+"\n";
   w2f.wrtReport( bw, content5);
   msg2 ="<===Test case passed===>";
   w2f.wrtReport( bw, msg2);

System.out.println("");
    
    
}
 
else{
	msg3 ="<===Test case Failed===>";
	w2f.wrtReport( bw, msg3);
}
 
invkbrowser.driver.navigate().back();
invkbrowser.driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
lp.clearUsernameTextBox();


}
invkbrowser.driver.close();
bw.close();
fw.close();
}
}


//=================
		/*program logic:
			read properties file
			get all data url/browser/expected title/inputfile
			invoking url 
			read from input file
			spliting records and geting user id password
			verify with db validity of username and password
			readdb rdb= new readdb();
			boolean result = rdb.getrec(usernm,password);
			if result=true and title=homepage then pass
			if result=false and title=erorpage then pass
			if result=true and title=errorpage then fail
			if result=false and title=homepage then fail
			if inpusernm=dbusernm and inppw=dbpw
			populate screen 
			click on submit
			if the us/p is valid and go to home(verify title) then pass
		 	else fail	*/
//==============
