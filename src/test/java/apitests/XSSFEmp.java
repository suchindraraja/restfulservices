package apitests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XSSFEmp 
{

	public static void main(String[] args) throws Exception 
	{
		//create XSSF file in RAM
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sh = wb.createSheet("sheet1");
		// create headings in first row
		Row r = sh.createRow(0);
		r.createCell(0).setCellValue("id");
		r.createCell(1).setCellValue("name");
		r.createCell(2).setCellValue("age");
		r.createCell(3).setCellValue("sal");
		r.createCell(4).setCellValue("profile");
		// register end point of Rest-full web service
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		// define HTTP request
		RequestSpecification req = RestAssured.given();
		// send request to get response
		Response res = req.request(Method.GET,"");
		// parse json response
		JsonPath jp = res.jsonPath();
		// get all employees details and send to .xlsx file
		List<Map<String, String>> ml = jp.getList("data");
		int rownum = 1; // 2nd row(index=1)
		for (int i = 0; i < ml.size(); i++) 
		{
			Row dr = sh.createRow(rownum);
			dr.createCell(0).setCellValue(ml.get(i).get("id"));
			dr.createCell(1).setCellValue(ml.get(i).get("employee_name"));
			dr.createCell(2).setCellValue(ml.get(i).get("employee_age"));
			dr.createCell(3).setCellValue(ml.get(i).get("employee_salary"));
			dr.createCell(4).setCellValue(ml.get(i).get("profile_image"));
			rownum++;
		}
		// apply Auto-fit on 5 used columns
		for (int j = 0; j < 5; j++)
		{
			sh.autoSizeColumn(j);
		}
		// save file into HDD
		File f = new File("sample3.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
