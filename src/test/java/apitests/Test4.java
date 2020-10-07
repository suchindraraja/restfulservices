package apitests;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test4 
{

	public static void main(String[] args) 
	{
		//specify base URI to the restful web service
		RestAssured.baseURI="https://date.nager.at/api/v2/publicholidays";
		Response res=RestAssured.given().request(Method.GET,"2020/us");
		//System.out.println(res);
		JsonPath jp=res.jsonPath();
		List<String> restres=jp.getList("date");
		for(int i=0;i<restres.size();i++)
		{
			System.out.println(restres.get(i));
		}
	}

}
