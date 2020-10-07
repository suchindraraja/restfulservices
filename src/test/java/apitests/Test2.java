package apitests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test2 
{

	public static void main(String[] args) throws Exception 
	{
		//create new file
		File f=new File("sample1.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet("sheet1");
		Row r=sh.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue("my guru is nageshwar rao sir");
		sh.autoSizeColumn(0);
		//save file
		wb.write(fo);
		wb.close();
		fo.close();

	}

}
