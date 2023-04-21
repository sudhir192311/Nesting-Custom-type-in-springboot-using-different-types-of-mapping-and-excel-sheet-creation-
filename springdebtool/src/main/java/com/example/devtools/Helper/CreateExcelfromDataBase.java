package com.example.devtools.Helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.devtools.entities.Book;




public class CreateExcelfromDataBase {
	public static void dataFromDatabase(List<Book> list) throws IOException{

		String[] head = { "id", "name", "statusid", "gender","qualification" };
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		int rowNum = 0;
		Row headerRow = sheet.createRow(rowNum++);

		for (int i = 0; i < head.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(head[i]);
			cell.setCellStyle(headerCellStyle);
		}
		for (int i = 0; i < list.size(); i++) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(list.get(i).getId());
			row.createCell(1).setCellValue(list.get(i).getName());
//			row.createCell(2).setCellValue(list.get(i).ge);
//			row.createCell(3).setCellValue(list.get(i).getBody());
		}
		for (int i = 0; i < head.length; i++) {
			sheet.autoSizeColumn(i);
		}
		FileOutputStream fileOutputStream = new FileOutputStream("database.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		workbook.close();
	
		
		
	}
	

}
