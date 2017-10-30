package worldofzuul.mapAndRooms;

// importing standard libraries for managing datastructures.
import java.util.Set;
import java.util.HashMap;

/**
 *
 * @author Rasmus Willer
 */
public class Room {

    // instantiates room coordinates to set and get.

    // Declare attributes -section.
    private String description;
    RoomCoord roomcords = new RoomCoord();
    // Map type (key/value -pairs data structure)
    private HashMap<String, Room> exits;
    private int[][] roomCoordinates = new int [10][10];
    private int x;
    private int y;

    /**
     * One-arg constructor with description String.
     *
     * @param description Passed string argument providing room description.
     */
    public Room(String description) {
        // Assigning description argument to instance attribute.
        this.description = description;
        /* Instantiating map object with key of String type and
           value as Room object. */
        exits = new HashMap<String, Room>();
    }

    /**
     * Method for designating direction of the exit point. A direction and a
     * neighboring room is passed as arguments to the method, that are then
     * added to the 'exits' map-object.
     *
     * @param direction String describing a exit direction.
     * @param neighbor Room object of neighboring room will be paired with
     * description
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Getter method for instance of room's description.
     *
     * @return Returns String of description of room instance.
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Getter method for extended description of room with room descriptions and
     * exit-waypoints from room.
     *
     * @return Returns String with description and exit-description.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Getter method for String description of exit routes from room instance.
     *
     * @return Returns String describing exit routes from room.
     */
    private String getExitString() {
        // Declare returning String + start of String message.
        String returnString = "Exits:";

        // Declare and assign a Set object 'keys' with all 'exits' Strings
        Set<String> keys = exits.keySet();

        // Add to returning String a list of exit points.
        for (String exit : keys) {
            returnString += " " + exit;
        }
        // Return structured String.
        return returnString;
    }

    /**
     * Getter method, retrieve Room reference for chosen direction. The chosen
     * direction is passed to this method and the corresponding room reference
     * is returned.
     *
     * @param direction String describing direction of other room.
     * @return Return corresponding Room object reference.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
