package edu.upenn.cit594.util;

public class State {

    private final String state;
    private final Double latitude;
    private final Double longitude;

    public State(String state, String latitude, String longitude) {
        this.state = state;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

    public String getState() {return state;}

    public Double getLatitude() {return latitude;}

    public Double getLongitude() {return longitude;}


}
