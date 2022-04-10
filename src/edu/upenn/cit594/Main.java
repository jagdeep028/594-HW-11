package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.processor.FluTweetProcessor;
import edu.upenn.cit594.processor.StateTweetProcessor;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.util.Tweet;

import java.util.*;

public class Main {

    public static void main(String[] args){

        StateReader sReader = new ReadStateCSV("states.csv");
        TweetReader tReader = new ReadTweetTXT("flu_tweets.txt");
        TweetReader jReader = new ReadTweetJSON("flu_tweets.json");

        List<Tweet> tweets = jReader.readTweetFile();

        for(Tweet tweet: tweets){
            System.out.println(tweet.getText());
            System.out.println(tweet.getLatitude());
            System.out.println(tweet.getLongitude());
        }

        StateTweetProcessor stateProcessor = new StateTweetProcessor(sReader,tReader);
        HashMap<Tweet, State> fluMap = stateProcessor.nearestState();

        for (Tweet key: fluMap.keySet()){
            System.out.println(key.getText());
            System.out.println(fluMap.get(key).getState());
        }
    }

}
