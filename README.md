API Automation - Slack


This automation project is used to perform testing in Slack. The code covers Create a new channel, Join the Channel, Rename the channel,
List out all the channels and Archive the channel.

Main classes: src/main/java/slack

The "CreateChannel" class is used as the Create the new channel in slack and validate the same for channel creation.
Then "joinChannel" class is used as Join the user to the channel and validated the user joined to the Channel.
The "RenameChannel" class is used as rename the already created channel and validated the channel name got changed.
The "ListChannels" class is used as get all the channels from the account and validated whether the channel changed.
The "ArchiveChannel" class is used to archive the renamed channel and List out all the channels and  validated whether the channel 
archived.
The "MainMethod" class is used to execute the classes.

Reusable Class: src/test/java/reusable

The "Reusable" class is used as the util class which takes care of reusable codes.

Property file: src/test/resources

The "Slack" property file used as store the token of the user.

Environment Setup:
Eclipse
Junit
Gradle


