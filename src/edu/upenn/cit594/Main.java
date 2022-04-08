package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.ReadStateCSV;
import edu.upenn.cit594.datamanagement.ReadTweetTXT;
import edu.upenn.cit594.datamanagement.StateReader;
import edu.upenn.cit594.datamanagement.TweetReader;
import edu.upenn.cit594.processor.FluTweetProcessor;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.util.Tweet;

import java.util.*;

public class Main {

    public static void main(String[] args){

        StateReader sReader = new ReadStateCSV("states.csv");
        List<State> states = sReader.readStateFile();

        for (State state : states) {
            System.out.println(state.getState());
            System.out.println(state.getLatitude());
            System.out.println(state.getLongitude());
        }

        TweetReader tReader = new ReadTweetTXT("flu_tweets.txt");
        FluTweetProcessor fluProcessor = new FluTweetProcessor(tReader);

        List <Tweet> tweets = fluProcessor.findFluTweets();

        for (Tweet tweet: tweets){
            System.out.println(tweet.getLatitude());
            System.out.println(tweet.getLongitude());
            System.out.println(tweet.getText());
        }
    }

}
