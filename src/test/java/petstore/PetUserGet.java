package petstore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PetUserGet 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://petstore.swagger.io/v2/user";
		RequestSpecification req=RestAssured.given();
		req.contentType("application/json");
		Response res=req.request().get("/elon musk");
		int sc=res.getStatusCode();
		System.out.println("Status code is :"+sc);
		String header=res.getHeader("Content-Type");
		System.out.println("status header is :"+ header);
		ResponseBody resb=res.getBody();
		String rb=resb.asString();
		System.out.println("Response Body is :"+rb);
		

	}

}
