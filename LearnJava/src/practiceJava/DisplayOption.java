package practiceJava;



public class DisplayOption {
	

    public static void main(String[] args) {
        System.out.println("Getting arguments");
// =======================================================

// ====================================================
//              arguments
// ===================================================
   System.out.println("Arguments" + args.length );
 System.out.println("===================================");
   for ( int i=0; i < args.length;i++)
{ 
   int j=i + 1;
    System.out.println("Arguments  " + j + ". " +  args[i]);
}
 System.out.println("===================================");


     int firstArg;
	if (args.length > 0) {
    	try {
        	firstArg = Integer.parseInt(args[0]);
        	System.out.println("Argument" + args[0]);
    	} 	catch (NumberFormatException e) {
        	System.err.println("Argument" + args[0] + " must be an integer.");
        	System.exit(1);
    }
// =======================================================
}
    }}