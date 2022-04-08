package edu.upenn.cit594.datamanagement;


import edu.upenn.cit594.util.State;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;


public class ReadStateCSV implements StateReader {

    protected String filename;//Holds name of csv file

    public ReadStateCSV(String name){
        filename = name;//construct read state CSV by passing string to filename
    }

    @Override
    //Overide of read state file method in State Reader interface with method that can read CSV
    public List<State> readStateFile() {

        List<State> states = new ArrayList<State>();//Init states list

        //Try to read file ot catch and print error if there is one
        try{
            FileReader fr = new FileReader(filename);//Create file reader object with csv file
            BufferedReader br = new BufferedReader(fr);//Create buffered reader object to read file object

            String line = null;//Empty string initialization to iterate through buffered reader

            //Iterate through buffered reader until there are no more lines to iterate
            while((line = br.readLine()) !=null){
                String[] stateLine = line.split(",");//Split each line by a comma

                String state = stateLine[0];//Store text in first position as state
                String latitude = stateLine[1];//Store text in second position as latitude
                String longitude = stateLine[2];//Store text in last position as longitude

                //Take strings above and use them to construct a state object and add them to states list
                states.add(new State(state,latitude,longitude));
            }

            //Close buffered read and file reader objects
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace(); //If an error is found print it
        }

        return states;//Return states list
    }
}
