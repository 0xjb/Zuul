package worldofzuul.mapAndRooms;

import java.util.ArrayList;
import worldofzuul.Entity;
import worldofzuul.Furniture.Furniture;
import worldofzuul.People.Player;
import worldofzuul.People.Student;
import worldofzuul.items.Item;

/**
 *
 * @author Niclas Johansen & Rasmus WIller & Søren Bendtsen
 */
public class Map {
    MapCoord mapcords = new MapCoord();
    private int item;
    private int exit;
    private String description;
    private boolean locked;
    // containers for entities
    private ArrayList<Item> itemsInMap = new ArrayList<>();
    private ArrayList<Player> playersInMap = new ArrayList<>();
    private ArrayList<Student> studentsInMap = new ArrayList<>();
    private ArrayList<Furniture> furnitureInMap = new ArrayList<>();
    public Map(){
        
    }

    /**
     *
     * @param eList
     * @param o
     */
    public void save() {
        saveItems();
        savePlayers();
        saveStudents();
        saveFurniture();
    }
    public void saveItems() {
        for(Item i : itemsInMap) {
            // save name to txt file
            // save x coord to txt file
            // save y coord to txt file
            // save currentRoom
        }
        
    }
    public void savePlayers() {
        for(Player p : playersInMap) {
            
        }
    }
    public void saveStudents() {
        for(Student s : studentsInMap) {
            
        }
    }
    public void saveFurniture() {
        for(Furniture f : furnitureInMap) {
            
        }
    }

    /**
     *
     * @param iList
     */


    public int item() {
        return this.item;
    }

    public int exit() {
        return this.exit;
    }

    public String description() {
        return this.description;
    }

    public boolean locked() {
        return this.locked;

    }
}
