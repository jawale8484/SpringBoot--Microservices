package com.birthdaywishingapp;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.stereotype.Service;

@Service
public class ReadWordFile {

	public void readWordSheet() {
		try (FileInputStream file = new FileInputStream("D:\\data.doc")) {
			HWPFDocument doc = new HWPFDocument(file);
			WordExtractor exrExtractor = new WordExtractor(doc);
			String[] fileData = exrExtractor.getParagraphText();

			for (String paragrph : fileData) {
				System.out.println(paragrph);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
