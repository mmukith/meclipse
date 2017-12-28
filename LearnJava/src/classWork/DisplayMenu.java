package classWork;

import java.util.Scanner;

public class DisplayMenu 
{

	public  static  void  getInput()
	{
		   
		
	       int i =0;
	       while(i!=3)
	       {
	    	   Scanner sc  = new Scanner(System.in);	       
	    	   String  nm = sc.nextLine();	       	       	    	   		   
	          if (nm.equals("1"))
	          {
	        	  System.out.println("reading file  " );
	          }

	          if (nm.equals("2"))
	          {	    	  
	        	  System.out.println("writing file  " );
	          }
	          if (nm.equals("3"))
	    	   {
		           System.out.println("Exited");
	    		   System.exit(1);
	    	   }
	 		
	       }
	}
}
