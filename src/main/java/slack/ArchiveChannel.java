package slack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusable.Reusable;

public class ArchiveChannel {

	
	public static void archiveChannel(String chanID ) throws IOException
	{
		String token = Reusable.runBefore();	
		Response res = RestAssured.given().header("Authorization", token)
			.body(Reusable.joinChannel(chanID))
			.contentType(ContentType.JSON)
			.when()
			.post("conversations.archive")
			.then()
			.assertThat()
			.statusCode(200)
			.and().extract().response();
	System.out.println();
	System.out.println("Response of Archive the channel");
	String response = res.asString();
	System.out.println(response);
	
	//Validating whether the channel archived
	Response resValidate = RestAssured.given().header("Authorization", token)
			.contentType(ContentType.JSON).when().get("conversations.list").then().assertThat().statusCode(200).and()
			.extract().response();

	String responValidate = resValidate.asString();
	System.out.println(response);
	
	// Validating whether the channel archived
	JsonPath js = new JsonPath(responValidate);
	List channelsList = js.getList("channels");
	for(int i=0; i<channelsList.size()-1; i++)
	{
		
		HashMap<String, Object> channelMap = (HashMap<String, Object>) channelsList.get(i);
		
 		if(channelMap.get("id").equals(chanID))
 		{
 			
 			if((boolean) channelMap.get("is_archived"))
 			{
 				System.out.println("Channel archived successfully");
 			}
 		}
	}
	
	}
}
