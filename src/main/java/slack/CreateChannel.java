package slack;

import java.io.IOException;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusable.Reusable;

public class CreateChannel {
	public static String channelId;
	
	public static String creatChannel1(String channelName) throws IOException {
		System.out.println("Started hitting for create a new channel");
		String token = Reusable.runBefore();
		Response res = RestAssured.given().header("Authorization", token).body(Reusable.createChannel(channelName))
				.contentType(ContentType.JSON).when().post("conversations.create").then().assertThat().statusCode(200).and()
				.extract().response();

		System.out.println("Response of Create a new channel");
		String response = res.asString();
		System.out.println(response);
	
		JsonPath js = new JsonPath(response);
		String chanNAme = js.get("channel.name");
		
		// Validating whether the channel created
		if (chanNAme.equalsIgnoreCase(channelName)) {
			System.out.println("Created channel successfully");
		}
		channelId = js.get("channel.id");
		return chanNAme;
	}


}
