package edu.upenn.cit594.processor;

import edu.upenn.cit594.datamanagement.TweetReader;
import edu.upenn.cit594.util.Tweet;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FluTweetProcessor {
    protected TweetReader reader;//Holds reader file that is passed to class
    protected List<Tweet> tweets;//Holds the tweets returned from the reader file

    public FluTweetProcessor(TweetReader reader){
        this.reader = reader;//Assigns reader to this class
        tweets = reader.readTweetFile();//Initializes class with tweet list from reader
    }

    public List<Tweet> findFluTweets(){

        List<Tweet> fluTweets = new ArrayList<Tweet>();//Will hold all "flu" tweets
        String regex = "(?i)\\bflu\\b";//Regex for finding flu
        Pattern pattern = Pattern.compile(regex);//Compiles regex into pattern

        //Iterates through the full tweet list
        for (Tweet tweet:tweets){

            Matcher matcher = pattern.matcher(tweet.getText());

            //If a match is found it is added to flu tweets list
            if(matcher.find()) {
                fluTweets.add(tweet);
            }
        }
        return fluTweets;
    }
}
