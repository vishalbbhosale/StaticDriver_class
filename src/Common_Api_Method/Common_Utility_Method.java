package Common_Api_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_Utility_Method {
	
	public static void Evidancecreator(String Filename,String Requestbody,String Responsebody,int statuscode) throws IOException {
		
		File vishal = new File("C:\\Selenium\\evidance\\"+Filename+".txt");
		System.out.println("new blank file;"+vishal.getName());
		
		FileWriter DataWrite=new FileWriter(vishal);
		DataWrite.write("request body is;"+Requestbody+"\n\n");
		DataWrite.write("Response body is;"+Responsebody+"\n\n");
		DataWrite.write("statuscode is;"+statuscode);
		
		DataWrite.close();
		System.out.println("data is writen in the file;"+vishal.getName());
		
		
		
	}
	public static ArrayList<String> ReadDataExcel(String FileName,String TestCaseName) throws IOException{
	ArrayList<String> ArrayData=new ArrayList<String>();
	
	//create fileinput object for locate the file
	FileInputStream Fis= new FileInputStream("C:\\Selenium\\vishal.xlsx");
	
	
	//open excel file by creating XSSFWorkbook
	XSSFWorkbook workbook=new XSSFWorkbook(Fis);
	
	//open Desired sheet
	int countofsheet = workbook.getNumberOfSheets();
	for(int i=0;i<countofsheet;i++) {
		String Sheetname=workbook.getSheetName(i);
		
		//Access the desired sheet
		if(Sheetname.equalsIgnoreCase(Sheetname)) {
			//use XSSF sheet to save the sheet into variable XSSFsheet
			XSSFSheet Sheet=workbook.getSheetAt(i);
			
			// create iterator TO iterate through row and find out in which column the test
			// case name found
			Iterator<Row> Rows = Sheet.iterator();
			Row FirstRow = Rows.next();
			
			// create the iterator to iterate through the cells of first row to find out
			// with cell contnts test case name
			Iterator<Cell> CellsofFirstRow = FirstRow.cellIterator();
			int k = 0;
			int TC_Column = 0;
			while (CellsofFirstRow.hasNext()) {
				Cell CellValue = CellsofFirstRow.next();
				if (CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
					TC_Column = k;
					// System.out.println("expected column for test case name:" + k);
					break;
				}
				k++;
			}
			// verify the row where the desired test case is found and fetch the entire row
			while (Rows.hasNext()) {
				Row Datarow = Rows.next();
				String TCName = Datarow.getCell(TC_Column).getStringCellValue();
				// Datarow.getCell(TC_column).getNumericCellValue()
				if (TCName.equalsIgnoreCase(TestCaseName)) {
					Iterator<Cell> CellValues = Datarow.cellIterator();
					while (CellValues.hasNext()) {
						String Data = "";
						Cell CurrentCell = CellValues.next();
						try {
							String StringData = CurrentCell.getStringCellValue();
							Data = StringData;
						} catch (IllegalStateException e) {
							double doubledata = CurrentCell.getNumericCellValue();
							Data = Double.toString(doubledata);
						}

						ArrayData.add(Data);
					}
					break;
				}
			}

		}
	}
	return ArrayData;

			
			
			
		}
	}



