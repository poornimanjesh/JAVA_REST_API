package Day2;
import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.nio.charset.Charset;
import java.util.HashMap;

import javax.swing.text.AbstractDocument.Content;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class differentWaysPostmethods {
	
	@Test(priority = 1)
	void HashmapWaytoSendPostrequest() {
		HashMap data=new HashMap();
		data.put("name", "morpheus");
		data.put("job","leader");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("morpheus"))
		.body("job",equalTo("leader"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	@Test(priority = 2)
	void DeleteHashmapPostrequest() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204);
	}
	@Test (priority = 3)
	
	void jsonWaytoSendPostrequest() {
		
		JSONObject data=new JSONObject();
		
		try {
			data.put("name", "morpheus");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data.put("job","leader");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("morpheus"))
		.body("job",equalTo("leader"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	
	@Test(priority = 4)
	void DeleteJsonPostrequest() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204);
	}
	
@Test (priority = 3)
	
	void POJOWaytoSendPostrequest() {
		
		JSONObject data=new JSONObject();
		
		try {
			data.put("name", "morpheus");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			data.put("job","leader");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("morpheus"))
		.body("job",equalTo("leader"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
	}
	
	@Test(priority = 4)
	void DeletePOJOPostrequest() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204);
	}
}
