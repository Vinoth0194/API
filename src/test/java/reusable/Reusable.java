package reusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;

import io.restassured.RestAssured;

public class Reusable {

	public static Properties prop = new Properties();
	public static String token;
	@Before
	public static void readProperty() throws IOException {

		FileInputStream inStream = new FileInputStream("../slack/src/test/resources/slack.properties");
				prop.load(inStream);
		
	}

	public static String getData() throws IOException {
		readProperty();
		String accToken = "Bearer " + prop.getProperty("Token");
		return accToken;
	}

	public static String runBefore() throws IOException {
		token = Reusable.getData();
		// String token = Token;
		
		RestAssured.baseURI = "https://slack.com/api/";
		return token;
	}
	
	public static String createChannel(String ChannelName) {

		String payload = "{\n" + "	\"name\":\"" + ChannelName + "\"\n" + "	\n" + "}";
		return payload;
	}
	
	public static String joinChannel(String channelID)
	{
		String  payload = "{\n" + "	\"channel\":\"" + channelID + "\"\n" + "	\n" + "}";
		return payload;
		
	}
	
	public static String renameChannel(String channelID, String rename)
	{
		
		String payload = "{\n" + "	\n" + "\"channel\"	: \"" + channelID + "\" ," + "	\"name\":    \"" + rename + "\" \n" + "}";
		return payload;
		
		
	}
	
	public static String archiveChannel(String channelID)
	{
		String  payload = "{\n" + "	\"channel\":\"" + channelID + "\"\n" + "	\n" + "}";
		return payload;
		
	}
	

}
