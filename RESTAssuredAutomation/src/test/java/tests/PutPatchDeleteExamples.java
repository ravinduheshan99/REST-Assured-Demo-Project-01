package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut(){
		
		baseURI="https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "Ravindu");
		request.put("job", "QA Engineer");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON). //explicitly saying that this post request sending json type contents only
			accept(ContentType.JSON).     //explicitly saying that this post request accepting json type contents only
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void testPatch(){
		
		baseURI="https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "Ravindu");
		request.put("job", "QA Engineer");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON). //explicitly saying that this post request sending json type contents only
			accept(ContentType.JSON).     //explicitly saying that this post request accepting json type contents only
			body(request.toJSONString()).
		when().
		patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void testDelete(){
		
		baseURI="https://reqres.in/api";
		
		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
	}

}
