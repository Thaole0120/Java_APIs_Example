package org.example;

import kong.unirest.Unirest;

import java.sql.SQLOutput;
import java.util.Map;

import static input.InputUtils.stringInput;

public class YelpSearch {
    public static void main(String[] args) {
        String yelpURL = "https://docs.developer.yelp.com/reference/v3_business_search";
        String YELP_API_KEY = System.getenv("YELP_API_KEY");
        String typeOfRestaurant = stringInput(" What type of restaurant would you like to search for? ");
        Map<String, Object> yelpQuery = Map.of(
                "term", typeOfRestaurant,
                "location", "Minneapolis,MN",
                "categories", "restaurants",
                "price", "1");


        YelpResponse response = Unirest
                .get(yelpURL)
                .header("Authorization", "Bearer" + YELP_API_KEY)
                .queryString(yelpQuery)
                .asObject(YelpResponse.class).getBody();

        System.out.println(response);
        for (Business b : response.businesses) {
            System.out.println(b.name);
            System.out.println("Rating: " + b.rating);
            System.out.println(b.location.address1 + "," + b.location.city);
        }
    }
}
