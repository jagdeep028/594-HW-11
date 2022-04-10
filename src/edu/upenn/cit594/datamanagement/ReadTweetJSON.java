package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTweetJSON implements TweetReader{

    //Will hold file name
    protected String filename;

    //Constructor, reads text in name and assigns to file name
    public ReadTweetJSON(String name){filename=name;}

    @Override
    public List<Tweet> readTweetFile() {
        List<Tweet> tweets = new ArrayList<Tweet>();//Initialize list (to be returned) to hold tweet objects

        //Create regex matcher for lat and long index
        String regex = "\\[(?<latitude>\\d*\\.\\d*),\\s(?<longitude>[-\\d]\\d*.\\d*)";
        Pattern latLongRegex = Pattern.compile(regex);

        try {
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(new FileReader(filename));

            // typecasting obj to JSONObject
            JSONArray tweetJSON = (JSONArray) obj;

            for (int i = 0; i < tweetJSON.size(); i++){
                Object obj2 = tweetJSON.get(i);
                JSONObject jsonObject = (JSONObject) obj2;

                List latLong =  (List) jsonObject.get("location");


                Double latitude = (Double) latLong.get(0);
                Double longitude = (Double) latLong.get(1);
                String tweetText = (String) jsonObject.get("text");

                tweets.add(new Tweet(latitude,longitude,tweetText));
            }


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }


        return tweets;
    }
}
