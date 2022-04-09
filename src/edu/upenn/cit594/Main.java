package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.ReadStateCSV;
import edu.upenn.cit594.datamanagement.ReadTweetTXT;
import edu.upenn.cit594.datamanagement.StateReader;
import edu.upenn.cit594.datamanagement.TweetReader;
import edu.upenn.cit594.processor.FluTweetProcessor;
import edu.upenn.cit594.processor.StateTweetProcessor;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.util.Tweet;

import java.util.*;

public class Main {

    public static void main(String[] args){

        StateReader sReader = new ReadStateCSV("states.csv");
        TweetReader tReader = new ReadTweetTXT("flu_tweets.txt");

        StateTweetProcessor stateProcessor = new StateTweetProcessor(sReader,tReader);
        HashMap<Tweet, State> fluMap = stateProcessor.nearestState();

        for (Tweet key: fluMap.keySet()){
            System.out.println(key.getText());
            System.out.println(fluMap.get(key).getState());
        }
    }

}
