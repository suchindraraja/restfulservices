package petstore;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PetGet 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification req=RestAssured.given();
		Response res=req.request(Method.GET,"/1");
		int sc=res.getStatusCode();
		System.out.println("Ststus code is :"+sc);
		String header=res.getHeader("Content-Type");
		System.out.println("ststus header is :"+ header);
		ResponseBody resb=res.getBody();
		String rb=resb.asString();
		System.out.println("Response Body is :"+rb);

	}

}
