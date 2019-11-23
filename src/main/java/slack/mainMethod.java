package slack;

import java.io.IOException;

public class mainMethod  {

	public static void main(String[] args) throws IOException {
		
		//Create a new Channel
		CreateChannel.creatChannel1("firstproject2");
		//Getting channelId of Created Channel
		String chanID = CreateChannel.channelId;
		//Join the channel
		JoinChannel.joinChannel(chanID);
		//Rename the channel Name and getting the renamed channel name
		String channelName = RenameChannel.renameChannel(chanID, "project3");
		//List of channels and validating.
		ListChannels.listChannels(chanID, channelName);
		//Archive the channel
		ArchiveChannel.archiveChannel(chanID);
	}

}
