package edu.upenn.cit594.processor;

import edu.upenn.cit594.datamanagement.StateReader;
import edu.upenn.cit594.datamanagement.TweetReader;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.util.Tweet;

import java.util.*;

public class StateTweetProcessor {
    protected StateReader sReader;
    protected TweetReader tReader;
    protected List<Tweet> tweets;
    protected List<State> states;

    public StateTweetProcessor(StateReader sReader, TweetReader tReader){
        this.sReader = sReader;
        this.tReader = tReader;

        tweets = new FluTweetProcessor(this.tReader).findFluTweets();
        states = sReader.readStateFile();
    }


    public HashMap<Tweet, State> nearestState(){

        HashMap<Tweet, State> fluMap = new HashMap<>();
        HashMap<State, Double> allDistances = new HashMap<>();
        double distance;

        for(Tweet tweet: tweets){

            for(State state: states){
                distance = Math.sqrt((state.getLongitude()-tweet.getLongitude())+(state.getLatitude()- tweet.getLatitude()));
                allDistances.put(state,distance);
            }

            Double minDistance = Collections.min(allDistances.values());

            for(State key: allDistances.keySet()){
                if (minDistance.equals(allDistances.get(key))){
                    fluMap.put(tweet,key);
                }
            }

        }

        return fluMap;
    }



}
