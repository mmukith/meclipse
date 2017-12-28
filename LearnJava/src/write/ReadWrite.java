package write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWrite {

	
	//public static void main(String[] args) throws IOException {
	    //Blank workbook
	public static void RdWr(String rdFilPath,String wrFilpath, int index) throws IOException{
		
	        FileInputStream file = new FileInputStream(new File(rdFilPath));

	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        //Get first/desired sheet from the workbook
	        //XSSFSheet sheet = workbook.getSheetAt();
	        XSSFSheet sheet = workbook.getSheetAt(index);
	        //Iterate through each rows one by one
	        Iterator<Row> rowIterator = sheet.iterator();
	        
	        while (rowIterator.hasNext())
	        {
	        	
	            Row row = rowIterator.next();
	        
	            //For each row, iterate through all the columns

	            Iterator<Cell> cellIterator = row.cellIterator();

	            while (cellIterator.hasNext()) 
	            {
	                Cell cell = cellIterator.next();
	                //Check the cell type and format accordingly
	                switch (cell.getCellType()) 
	                {
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                       
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        break;
	                }
	            }
	            System.out.println("");
	        }
	        
	        
	    
	    try 
	    {
	        //Write the workbook in file system
	        FileOutputStream out = new FileOutputStream(new File(wrFilpath));
	        workbook.write(out);
	        
	        out.close();
	        System.out.println("demoWr.xlsx written successfully on disk.");
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	


	}
	
	public static void main(String[] args) throws IOException {
		
		String readFile = "input\\demo3.xlsx";
		String WriteFile ="input\\demo4.xlsx";
		RdWr(readFile,WriteFile,1);
		
		
	}
	}
	

