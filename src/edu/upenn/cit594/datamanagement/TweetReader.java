package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;
import java.util.*;

public interface TweetReader {

    List<Tweet> readTweetFile();
}
