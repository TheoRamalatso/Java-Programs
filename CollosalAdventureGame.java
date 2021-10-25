package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();;
        this.exits.put("Q", 0); //quit applies for all locations

    }
    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
}


package com.company;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));
        //
    //all directions are provide in loc
        locations.get(1).addExit("W", 2); //puts direction and location
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);


        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");  //direction will re-map into keys to locations
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1; //default state
        while (true) {
            System.out.println(locations.get(loc).getDescription()); //all the directions at loc (1) pro
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();

            System.out.print("Availabe exist :");
            System.out.println();
            for (String exit : vocabulary.keySet()) {
                System.out.print("" + exit + ": ");
              //  System.out.println(locations.get(loc).getDescription()); loc++;
            }

            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1){
                String [] words = direction.split(" " );
                for(String word : words){
                    if(vocabulary.containsKey(word)){ //if entered sentence
                                                    //..contains the stored map of words, find that word perform an action
                        direction = vocabulary.get(word);
                        break;
                    }
                }

            }
            if(exits.containsKey(direction)) {
               loc = exits.get(direction);

            } else {
               System.out.println("You cannot go in that direction");
           }
            if(vocabulary.containsKey(direction)){
                System.out.println(direction);
            }else{

            }


            }
        }
    }

