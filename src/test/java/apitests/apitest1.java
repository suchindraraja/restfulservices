package apitests;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class apitest1 
{

	public static void main(String[] args) 
	{
		//create HTTP request
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/locationutil/weather/city";
		RequestSpecification req=RestAssured.given();
		//send request with required HTTP method and parameter value
		Response res=req.request(Method.GET,"/Hyderabad");
		//analyze HTTP response in various representations
		String rsl=res.getStatusLine();
		System.out.println("status line is \n"+rsl);
		System.out.println("Headers are:");
		List<Header> hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		ResponseBody rbobj=res.getBody();
		String rb=rbobj.asString();
		System.out.println("Response body is:\n"+rb);

	}

}
