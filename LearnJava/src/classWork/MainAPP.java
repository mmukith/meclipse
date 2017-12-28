package classWork;

import practiceJava.utility;

public class MainAPP {
	static String dbnm="";
	
	public static void main(String[] args) 
	{
		//reading database		
		ReadDb rd= new ReadDb();
		String sql="select * from customer ";		   
		System.out.println("SQL: "+sql);
		String dbrec=rd.readdb(sql,dbnm);
		System.out.println("===============================================================");
		
		//displaying min to max number in parameter
		DisplayMaxNumber dn=new DisplayMaxNumber();
	    dn.dis(99,106);
	    System.out.println("======================================");

	    //display option to select
	    System.out.println("Select your option: ");
	    System.out.println("Enter  1 to read file ");
	    System.out.println("Enter 2 to write ");
	    System.out.println("Enter 3 to exit ");
	    DisplayMenu dm=new DisplayMenu();
		dm.getInput();

	}

}
