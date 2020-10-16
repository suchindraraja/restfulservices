package apitests;

import java.io.File;
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

public class RestEmpDet 
{

	public static void main(String[] args) throws Exception
	{
		//TODO Auto-generated method stub
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet("Sheet1");
		Row r=sh.createRow(0);
		r.createCell(0).setCellValue("Id");
		r.createCell(1).setCellValue("Name");
		r.createCell(2).setCellValue("Age");
		r.createCell(3).setCellValue("Salary");
		r.createCell(4).setCellValue("profile");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification req=RestAssured.given();
		Response res=req.request(Method.GET,"");
		JsonPath jp=res.jsonPath();
		List<Map<String,String>> lm=jp.getList("data");
		int rownum=1;
		for(int i=0;i<lm.size();i++)
		{
			Row r2=sh.createRow(rownum);
			r2.createCell(0).setCellValue(lm.get(i).get("id"));
			r2.createCell(1).setCellValue(lm.get(i).get("employee_name"));
			r2.createCell(2).setCellValue(lm.get(i).get("employee_age"));
			r2.createCell(3).setCellValue(lm.get(i).get("employee_salary"));
			r2.createCell(5).setCellValue(lm.get(i).get("profile_image"));
			rownum++;	
		}
		for(int i=0;i<5;i++)
		{
			sh.autoSizeColumn(i);
		}
		File f=new File("Employees.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		

	}

}
