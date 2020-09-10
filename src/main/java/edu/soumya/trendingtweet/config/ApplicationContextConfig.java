package edu.soumya.trendingtweet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.soumya.trendingtweet.extractor.TrendingTweetExtractor;
import edu.soumya.trendingtweet.extractor.helper.TrendingTweetExtractorHelper;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Configuration
public class ApplicationContextConfig {
	@Bean
	public TrendingTweetExtractor extractor() {
		return new TrendingTweetExtractor();
	}
	@Bean
	public TrendingTweetExtractorHelper extractorHelper() {
		return new TrendingTweetExtractorHelper();
	}
	@Bean
	public Twitter twitter() {
		return TwitterFactory.getSingleton();
	}
	
}
