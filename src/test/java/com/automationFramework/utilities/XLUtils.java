package com.automationFramework.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void setExcelFile(String workbook, String sheet) throws IOException {
		fi = new FileInputStream(workbook);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
	}
	
	public static int getRowCount(String workbook, String sheet) throws IOException {
		fi = new FileInputStream(workbook);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rowNum = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowNum;
	}
	
	public static int getCellCount(String workbook, String sheet, int row) throws IOException {
		fi = new FileInputStream(workbook);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int cellNum = ws.getRow(row).getLastCellNum();
		wb.close();
		fi.close();
		return cellNum;
	}
	
	public static String getCellData(String workbook, String sheet, int rowNum, int cellNum) throws IOException{
		fi = new FileInputStream(workbook);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return celldata;
		}catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
}
