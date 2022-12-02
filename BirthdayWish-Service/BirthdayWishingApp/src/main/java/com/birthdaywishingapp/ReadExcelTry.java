//this code is  just for try basis

package com.birthdaywishingapp;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service
public class ReadExcelTry {

	@Autowired
	SendEmailForBirthdayWishesh sendEmailForBirthdayWishesh;
	
	public void ReadFile() throws Exception {

		System.out.println("In-Process..");
		DataFormatter formattor =new DataFormatter();

		
		//----first logic ----
		FileInputStream fis = new FileInputStream(new File("D:\\datatry.xls"));
		// creating workbook instance that refers to .xls file
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		HSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		System.out.println("The given file is");
		Cell email = null;
		Cell name=null;
		for (Row row : sheet)
		// iteration over row using for each loop
		{
			int count=0;
		//	ArrayList<Employee> list =new ArrayList<Employee>();
			for (Cell cell : row) // iteration over cell using for each loop
			{
                   
				
				switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
				
				
				case Cell.CELL_TYPE_STRING:
					// field that represents string cell type
					// getting the value of the cell as a string
					email=row.getCell(2);
					 name=row.getCell(0);
					if(count>0) {
					//	 email=cell.getStringCellValue();
						 
						 System.out.println(count);
						// System.out.println(email+" "+name);
					}
					System.out.print(cell.getStringCellValue() + "\t\t");
					break;
				
				case Cell.CELL_TYPE_NUMERIC:
					// field that represents numeric cell type
					// getting the value of the cell as a number
				//	System.out.print(cell.getNumericCellValue() + "\t");
					
					//System.out.println(cell.getDateCellValue()+"\t");
					
					
					
					//below code for date vs numeric
					

			            // Using HSSFDateUtil to check if a cell contains a date.
			            if (DateUtil.isCellDateFormatted(cell)) {
			                System.out.println( cell.getDateCellValue());
			            }else {
			            	int i=(int) cell.getNumericCellValue();
			            	System.out.println(i);
			            }
					
					
					
					
					//below code for convert date format
					
					

			//		DateTimeFormatter exlDate = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss Z yyyy");
					java.util.Date cellDate= cell.getDateCellValue();
				//	System.out.println(cellDate);
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
					String formatDate = formatter.format(cellDate);
			//		System.out.println(formatDate);
				
					
					//below code for current date
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					LocalDate localDate = LocalDate.now();
					String localDate1 = dtf.format(localDate);
			//		System.out.println(dtf.format(localDate));
					
					
					 
					
					
					
					if(formatDate.equals(localDate1)) {
						System.out.println("Date match");
						count++;
					//	System.out.println(count);
					}else {
						System.out.println("Date Not Match");
					}
					
					break;
					
					
				
					
				
				} 
			}
			System.out.println();
		String strEmail=formattor.formatCellValue(email);
		String strName =formattor.formatCellValue(name);
	//	System.out.println("Match data of this employee");
	//	System.out.println(strEmail+" "+strName);
		if(count>0) {
			sendEmailForBirthdayWishesh.sendSimpleEmail(strEmail, "Birthday Wish", "Hello, "+strName+" \t\t  \n Happy Birthday To You !!	\n \n Thanks.		");
			
		}
	//	System.out.println(count);
		} 
	}

}
