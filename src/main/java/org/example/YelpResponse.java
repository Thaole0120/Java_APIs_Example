package org.example;

public class YelpResponse {
    // field for business
    public Business[] businesses;
}

class Business {
    public String name;
    public double rating;
    public Location location;

}

class Location {
    public String city;
    public String address1;
}
