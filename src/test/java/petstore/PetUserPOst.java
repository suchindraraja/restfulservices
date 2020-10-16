package petstore;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PetUserPOst 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		RequestSpecification req=RestAssured.given();
		req.contentType("application/json");
		JSONObject jo=new JSONObject();
		jo.put("id","1919");
		jo.put("username","elon musk");
		jo.put("firstName","elon");
		jo.put("lastName","musk");
		jo.put("email","muskmama@musk.com");
		jo.put("password","spacerider");
		jo.put("phone","spaceX");
		jo.put("userStatus","0");
		req.body(jo.toString());
		Response res=req.request().post("/user");
		int sc=res.getStatusCode();
		System.out.println("Ststus code is :"+sc);
		String header=res.getHeader("Content-Type");
		System.out.println("ststus header is :"+ header);
		ResponseBody resb=res.getBody();
		String rb=resb.asString();
		System.out.println("Response Body is :"+rb);
		

	}

}
