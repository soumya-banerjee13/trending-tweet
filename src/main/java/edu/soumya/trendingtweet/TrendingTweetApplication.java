package edu.soumya.trendingtweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.soumya.trendingtweet.extractor.TrendingTweetExtractor;

@SpringBootApplication
public class TrendingTweetApplication implements ApplicationRunner {

	@Autowired
	TrendingTweetExtractor extractor;
	
	public static void main(String[] args) {
		SpringApplication.run(TrendingTweetApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		extractor.printTop10HashTags(args.getSourceArgs());
	}

}
