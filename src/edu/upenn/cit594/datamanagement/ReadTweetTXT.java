package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ReadTweetTXT implements TweetReader{

    //Will hold file name
    protected String filename;

    //Constructor, reads text in name and assigns to file name
    public ReadTweetTXT(String name){filename=name;}

    @Override
    public List<Tweet> readTweetFile() {

        List<Tweet> tweets = new ArrayList<Tweet>();//Initialize list (to be returned) to hold tweet objects

        //Try to read file ot catch and print error if there is one
        try {
            FileReader fr = new FileReader(filename);//Create file reader object with txt file
            BufferedReader br = new BufferedReader(fr);//Create buffered reader object to read file object

            String line; //Init string to hold each iterated line

            //Create regex matcher for lat and long index
            String regex = "\\[(?<latitude>\\d*\\.\\d*),\\s(?<longitude>[-\\d]\\d*.\\d*)";
            Pattern latLongRegex = Pattern.compile(regex);

            while((line = br.readLine()) != null ){
                String[] tweetLine = line.split("\t");

                Matcher matcher = latLongRegex.matcher(tweetLine[0]);
                matcher.find();
                String latitude = (matcher.group("latitude"));
                String longitude = (matcher.group("longitude"));
                String tweetText = tweetLine[3];

                tweets.add(new Tweet(latitude,longitude,tweetText));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return tweets;
    }
}
