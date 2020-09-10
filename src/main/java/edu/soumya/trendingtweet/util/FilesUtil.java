package edu.soumya.trendingtweet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FilesUtil {

	public static String getContentFromFile(InputStream file) {
		try (Reader reader = new InputStreamReader(file)) {
			BufferedReader buffReader = new BufferedReader(reader, 32768);
			StringBuilder fileContent = new StringBuilder();
			String line;
			while ((line = buffReader.readLine()) != null) {
				fileContent.append(line).append("\n");
			}
			buffReader.close();
			return fileContent.toString();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

}
