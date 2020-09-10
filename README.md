# trending-tweet
Prints top 10 trending hashtags from a list of tweets in online/offline mode

# Assumptions
Hashtags are case-sensitive

# Prerequisites
1. Java 8 should be installed in the system, to run the tool.

# How to Build
1. Go to the folder trending-tweet(the folder where pom.xml file exists) after checking out the code.
2. Run the command: mvn clean install.
3. Inside the target folder trending-tweet-0.0.1-SNAPSHOT.jar will be created.

# How to Run
The tool prints top 10 hashtags from a file containing some tweets on sports, it also can fetch science related tweets directly from twitter.
The general run command is: ```java -jar trending-tweet-0.0.1-SNAPSHOT.jar [online|offline]```

## Offline Run Command
```java -jar trending-tweet-0.0.1-SNAPSHOT.jar offline``` or  ```java -jar trending-tweet-0.0.1-SNAPSHOT.jar```

It returns top 10 hashtags from a file in the distribution itself, containing some tweets on sports.

## Online Run Command
```java -jar trending-tweet-0.0.1-SNAPSHOT.jar online```

It returns top 10 hashtags related to the topic science from twitter.

Note: To run the tool in online mode the system must be connected to the internet and twitter must be accessible from the system. Otherwise, exception will be thrown which is unhandled in the tool's code.
