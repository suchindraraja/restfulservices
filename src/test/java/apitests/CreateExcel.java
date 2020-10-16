package apitests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet("IPL2020");
		Row r=sh.createRow(0);
		r.createCell(0).setCellValue("Sunrisers Hyd");
		r.createCell(1).setCellValue("Mumbai Indians");
		r.createCell(2).setCellValue("Chennai superkings");
		r.createCell(3).setCellValue("Royal Banglore");
		for(int i=0;i<4;i++)
		{
			sh.autoSizeColumn(i);
		}
		File f=new File("League teams.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		
		

	}

}
