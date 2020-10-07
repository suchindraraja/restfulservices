package apitests;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutJson 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification req=RestAssured.given();
		JSONObject jo=new JSONObject();
		jo.put("id","25");
		jo.put("employee_name","virat");
		jo.put("employee_age","25");
		jo.put("employee_salary","100000");
		jo.put("profile_image","");
		req.body(jo.toString());
		Response res=req.request(Method.PUT,"/update/25");
		int sc=res.getStatusCode();
		System.out.println("status code is :"+sc);
		String header=res.getHeader("Content-Type");
		System.out.println("Representation is :"+header);
		System.out.println("Response body is :"+res.body().asString());

	}

}
