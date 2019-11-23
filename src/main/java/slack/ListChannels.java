package slack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import reusable.Reusable;

public class ListChannels {
	public static String ChannelId;
	@SuppressWarnings("unlikely-arg-type")
	public static void listChannels(String chanId, String ChanName) throws IOException
	{
		String token = Reusable.runBefore();
		 ChannelId = chanId;
		Response res = RestAssured.given().header("Authorization", token)
				.contentType(ContentType.JSON).when().get("conversations.list").then().assertThat().statusCode(200).and()
				.extract().response();
		System.out.println();
		System.out.println("Response for get the list of channels");
		String response = res.asString();
		System.out.println(response);
		// Validating whether created channel name
		JsonPath js = new JsonPath(response);
		
		//Validating whether the channel name got renamed
		
		List channelsList = js.getList("channels");
		for(int i=0; i<channelsList.size()-1; i++)
		{
			
			HashMap<String, Object> channelMap = (HashMap<String, Object>) channelsList.get(i);
	
     		if(channelMap.get("id").equals(ChannelId))
     		{
     			System.out.println("name of the channel" +channelMap.get("name"));
     			if(channelMap.get("name").equals(ChanName))
     			{
     				System.out.println("Renamed1 successfully");
     			}
     		}
		}
	}

}
