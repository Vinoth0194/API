package slack;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusable.Reusable;

public class JoinChannel {
	
public static void joinChannel(String chanID) throws IOException {

	String token = Reusable.runBefore();
	Response res = RestAssured.given().header("Authorization", token)
		.body(Reusable.joinChannel(chanID))
		.contentType(ContentType.JSON)
		.when()
		.post("conversations.join")
		.then()
		.assertThat()
		.statusCode(200)
		.and().extract().response();
System.out.println();
System.out.println("Response of join a channel");

String response = res.asString();
System.out.println(response);
JsonPath js = new JsonPath(response);
String channelId = js.get("channel.id");

//Validating whether the user joined to the same channel
if(channelId.equals(chanID))
{
	System.out.println("User joined to the same channel successfully");
	}

}

}
