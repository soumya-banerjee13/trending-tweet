package edu.soumya.trendingtweet.extractor;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import edu.soumya.trendingtweet.extractor.helper.TrendingTweetExtractorHelper;
import edu.soumya.trendingtweet.util.FilesUtil;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TrendingTweetExtractor {
	
	/**
	 * Logger Instance
	 */
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	TrendingTweetExtractorHelper extractorHelper;
	
	@Autowired
	Twitter twitter;
	
	public void printTop10HashTags(String[] args) throws TwitterException {
		String allTweets = null;
		if(args.length==0 || (args.length==1 && args[0].equals("offline"))) {
			allTweets = getOfflineSportsTweets();
		} else if(args.length==1 && args[0].equals("online")) {
			allTweets = getOnlineScienceRelatedTweets();
		} else {
			throw new UnsupportedOperationException("Invalid Argument(s) Passed.");
		}
		LOGGER.info(allTweets);
		System.out.println("Here is the top 10 hashtags:");
		System.out.print(extractorHelper.getTop10HashTags(allTweets));
	}
	
	private String getOnlineScienceRelatedTweets() throws TwitterException {
		StringBuilder sportTweets = new StringBuilder();
		Query sportsHashTagQuery = new Query("#science");
		sportsHashTagQuery.setCount(100);
		QueryResult result = twitter.search(sportsHashTagQuery);
		for(Status status: result.getTweets()) {
			sportTweets.append(status.getText()).append("\n");
		}
		return sportTweets.toString();
	}
	
	private String getOfflineSportsTweets() {
		InputStream stream = this.getClass().getResourceAsStream("/offlineSportsTweet.txt");
		return FilesUtil.getContentFromFile(stream);
	}
}
