/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.Furniture;

import worldofzuul.People.Player;
import worldofzuul.items.Item;
import worldofzuul.items.Key;

/**
 *
 * @author Niclas
 */
public class Door extends Furniture {
    private boolean doorLocked;
    private Item items[];
    private KeyHole keyHole;
    
    /**
     * constructor for a door
     * @param doorName
     * @param doorDescription
     * @param doorLocked
     */
    
    public Door (String doorName, String doorDescription, boolean doorLocked ){
        super.setFurnitureName(doorName);
        super.setFurnitureDiscription(doorDescription);
        this.doorLocked = doorLocked;
        
    }

    
    /**
     * method for inspect in door
     */
    public KeyHole inspectKeyhole(KeyHole picture ){
            return picture;
    }
    
    /**
     * method for checking if the door is locked
     */
    public boolean isDoorLocked(Key key, Item items[]){
        if (items.contains(key)) {
            System.out.println("You got the key! Door is now open Sir");
            items.remove(key);
        }
        else {
           System.out.println("Nahh. Door is locked");
        }
        return true;
        
    }
    
    
}
