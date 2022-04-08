package edu.upenn.cit594.util;

public class Tweet {

    private final Double latitude;
    private final Double longitude;
    private final String text;

    public Tweet(String latitude, String longitude, String text) {
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.text = text;
    }

    public Double getLatitude() {return latitude;}

    public Double getLongitude() {return longitude;}

    public String getText() {return text;}
}
