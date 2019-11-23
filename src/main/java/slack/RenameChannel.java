package slack;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusable.Reusable;

public class RenameChannel {
	
	public static String renameChannel(String chanID,String rename) throws IOException {

		String token = Reusable.runBefore();
		
		Response res = RestAssured.given().header("Authorization", token)
			.body(Reusable.renameChannel(chanID,rename))
			.contentType(ContentType.JSON)
			.when()
			.post("conversations.rename")
			.then()
			.assertThat()
			.statusCode(200)
			.and().extract().response();
	System.out.println();
	System.out.println("Response of rename the channel");

	String response = res.asString();
	System.out.println(response);
	JsonPath js = new JsonPath(response);	
	String channelName = js.get("channel.name");
	
	//Validating renames a channel
	if(rename.equalsIgnoreCase(channelName))
	{
		System.out.println("Renamed successfully");
		}

	return channelName;
	}

}
