package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	//@Test
	public void testGet(){
		
		baseURI="https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",equalTo("George")).
			body("data.first_name",hasItems("George","Rachel"));
	}
	
	
	@Test
	public void testPost(){
		
		/*
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Ravindu");
		map.put("job", "QA Engineer");
		
		//without using json simple library
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		//with using json simple library
		System.out.println(request.toJSONString());
		*/
		
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
			post("/users").
		then().
			statusCode(201).
			log().all();
	}

}
