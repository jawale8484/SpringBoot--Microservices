package com.birthdaywishingapp;

import java.io.File;
import java.io.FileInputStream;

import javax.mail.MessagingException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.fasterxml.jackson.databind.JsonNode;

@SpringBootApplication
public class BirthdayWishingAppApplication {

	@Autowired
	SendEmailForBirthdayWishesh sendEmailForBirthdayWishesh;
	
	@Autowired
	ReadExcelSheet readExcelSheet;
	
	@Autowired
	ExcelToJSONConverter excelToJSONConverter;
	
	@Autowired
	static
	ReadWordFile readWordFile;
	
	@Autowired
	ReadExcelTry readExcelTry;
	
	public static void main(String[] args)  {
		SpringApplication.run(BirthdayWishingAppApplication.class, args);

	//	SendEmailForBirthdayWishesh email = new SendEmailForBirthdayWishesh();
		
		
		
		
		
	/*	ReadWordFile rdObj=new ReadWordFile();
		try{
		//	rdObj.readWordSheet();
			readWordFile.readWordSheet();
		}catch(Exception e) {
			System.out.println(e);
		}
		*/
/*
        // Creating a file object with specific file path
		//this below code if for ExcelToJSONConvertor class
        File excel = new File("D:\\data.xls");
        ExcelToJSONConverter converter = new ExcelToJSONConverter();

        JsonNode data = converter.excelToJson(excel);
        System.out.println("Excel file contains the Data:\n" + data);  */
		
	}
	
/*
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		sendEmailForBirthdayWishesh.sendSimpleEmail("vjawale203@gmail.com", "Hi.. This mail send by java Mail API", "Java Mail API");

	}*/

	
	//for ReadExcelFile
	
	@EventListener(ApplicationReadyEvent.class)
	public void readFile() throws Exception {
	//	readExcelSheet.ReadFile();
	//	readWordFile.readWordFile();
	//	readExcelTry.ReadFile();
	}   
	
	
	
   
	
	
	
}
