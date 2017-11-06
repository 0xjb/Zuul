package worldofzuul.mapAndRooms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import worldofzuul.Entity;
import worldofzuul.Furniture.Furniture;
import worldofzuul.People.Player;
import worldofzuul.People.Student;
import worldofzuul.PrintOut;
import worldofzuul.items.Coffee;
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
    // rooms
    private Room[] rooms;

    public Map() {
        // while(s.hasNext())
        // item.name =
        // item.x =
        // item.y = 
        // item.currentRoom = 
        // itemsInMap.add(item)
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
        for (Item i : itemsInMap) {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.home") + "\\Documents\\SaveItemsTest.txt")))) {
                writer.write(i.getName() + " ");
                writer.write(i.getX() + " ");
                writer.write(i.getY() + " ");
                (i.getClass) i.getName();
            } catch (IOException e) {
                System.err.println("BEEP BOOP, COULDNT SAVE... please check the save directory in the code.");
            }
        }

    }

    public void loadItems() {
        File file = new File(System.getProperty("user.home") + ("\\Documents\\SaveFileTest.txt"));
        ArrayList<String> loadData = new ArrayList<String>();
        try {
            Scanner s2 = new Scanner(file);
            //now read the word by word
            while (s2.hasNext()) {
                Coffee i = new Coffee();
                i.setName(s2.next());
                i.setY(s2.nextInt());
                i.setX(s2.nextInt());
                itemsInMap.add(i);
            }
        } catch (FileNotFoundException e) {
        }
    }

    public void savePlayers() {
        for (Player p : playersInMap) {

        }
    }

    public void saveStudents() {
        for (Student s : studentsInMap) {

        }
    }

    public void saveFurniture() {
        for (Furniture f : furnitureInMap) {

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
