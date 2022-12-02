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
public class ReadExcelSheet {

	@Autowired
	SendEmailForBirthdayWishesh sendEmailForBirthdayWishesh;
	
	public void ReadFile() throws Exception {

		System.out.println("In-Process..");
		DataFormatter formattor =new DataFormatter();

		
		//----first logic ----
		FileInputStream fis = new FileInputStream(new File("D:\\data.xls"));
		// creating workbook instance that refers to .xls file
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		HSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		System.out.println("The given file is");
		int count=0;
		Cell email = null;
		Cell name=null;
		for (Row row : sheet)
		// iteration over row using for each loop
		{
		//	ArrayList<Employee> list =new ArrayList<Employee>();
			for (Cell cell : row) // iteration over cell using for each loop
			{
                   
				
				switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
				
				
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
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
					String formatDate = formatter.format(cellDate);
			//		System.out.println(formatDate);
				
					
					//below code for current date
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					LocalDate localDate = LocalDate.now();
					String localDate1 = dtf.format(localDate);
				//	System.out.println(dtf.format(localDate));
					
					
					 
					
					
					
					if(formatDate.equals(localDate1)) {
						System.out.println("Date match");
						count++;
						System.out.println(count);
					}
					
					break;
					
					
				
					
				case Cell.CELL_TYPE_STRING:
					// field that represents string cell type
					// getting the value of the cell as a string
					if(count>0) {
					//	 email=cell.getStringCellValue();
						 email=row.getCell(3);
						 name=row.getCell(1);
						 System.out.println(count);
						// System.out.println(email+" "+name);
					}
					System.out.print(cell.getStringCellValue() + "\t\t");
					break;
				} 
			}
			System.out.println();
		} 
		String strEmail=formattor.formatCellValue(email);
		String strName =formattor.formatCellValue(name);
	//	System.out.println(strEmail+" "+strName);
		if(count>0) {
		//	sendEmailForBirthdayWishesh.sendSimpleEmail(strEmail, "Birthday Wish", "Hello "+strName+" \t \n Happy Birthday To You !!			");
			
		}
	}

}
