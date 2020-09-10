package edu.soumya.trendingtweet.extractor.helper;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TrendingTweetExtractorHelper {
	public String getTop10HashTags(String allTweets) {
		StringBuilder result = new StringBuilder();
		Map<String,Integer> hashTagCountMap = new HashMap<>();
		Map<Integer, List<String>> hashTagCountReverseMap = new TreeMap<>(Collections.reverseOrder());
		String[] lines = allTweets.split("\n");
		for(String line: lines) {
			if(line.length()==0) continue;
			String[] words = line.split(" ");
			for(String word: words) {
				if(word.length()<2) continue;
				if(word.startsWith("#")) {
					hashTagCountMap.put(word, hashTagCountMap.getOrDefault(word, 0)+1);
				}
			}
		}
		for(String hashTag: hashTagCountMap.keySet()) {
			int count = hashTagCountMap.get(hashTag);
			if(!hashTagCountReverseMap.containsKey(count)) {
				hashTagCountReverseMap.put(count, new LinkedList<String>());
			}
			hashTagCountReverseMap.get(count).add(hashTag);
		}
		int found = 0;
		loop1:for(int count:hashTagCountReverseMap.keySet()) {
			for(String hashTag: hashTagCountReverseMap.get(count)) {
				if(found>=10) break loop1;
				result.append(hashTag).append("\n");
				found++;
			}
		}
		return result.toString();
	}
}
