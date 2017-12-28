
package fileutil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteToFile {
	
	
	static BufferedWriter bw;
	static FileWriter fw;
	static String msg;

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date = new Date();
	//System.out.println(dateFormat.format(date));

	public void reportSummery(BufferedWriter bw,String QAname) throws IOException  {
		bw.write("Generated report Summery");
		bw.newLine();
		bw.write("QA_Tester: "+QAname);
		bw.newLine();
		bw.write("Date :" +dateFormat.format(date));
		bw.newLine();
		//bw.newLine();
	}
	
	
	public void wrtReport(BufferedWriter bw, String msg) throws IOException  {
		
		
				bw.write(msg);
				bw.newLine();
			

	}


	public void wrtReport(BufferedWriter bw, boolean tf) {
		
		tf =true;
		//bw.write(tf);
	}
	

	/*
	 * finally {
				try {
					bw.close();
					fw.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
			}

	 */

}
