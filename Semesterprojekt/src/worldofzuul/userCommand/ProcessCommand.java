package worldofzuul.userCommand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import worldofzuul.People.Player;
import worldofzuul.People.Student;
import worldofzuul.mapAndRooms.RoomManager;
import worldofzuul.PrintOut;
import worldofzuul.Quit;
import worldofzuul.items.Item;

/**
 *
 * @author Rasmus Willer & Magnus Mortensen
 */
public class ProcessCommand {

    private Parser parser;
    private Command command;
    private RoomManager rooms;

    public ProcessCommand() {
        parser = new Parser();
    }

    /**
     * Method processes user command to action. If the user wants to get help
     * printed, go to a different room or quit.
     *
     * @param rooms Room Manager object with room definitions.
     * @return Boolean return true if user wants to quit.
     */
    public boolean process(RoomManager rooms, Player p, Student s) {
        this.parser = parser;
        this.rooms = rooms;
        boolean gameLoop = true;

        CommandWord commandWord = command.getCommandWord();

        // If user input is not a defined command.
        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return true;
        }

        if (null != commandWord) { // If user input is request for help print.
            switch (commandWord) {
                // Or if user prompts for move to another room.
                case HELP:
                    PrintOut.printHelp(parser);
                    break;
                // Or if user prompt to quit.
                case GO:
                    rooms.goRoom(command, p);
                    s.move();
                    break;
                case MOVE:
                    s.move();
                    p.move(command);
                    break;
                case LOOT:
                    if (rooms.getCurrentRoom().roomArray[p.getX()][p.getY() - 1] != null) {
                        p.inventory().lootItem((Item) rooms.getCurrentRoom().roomArray[p.getX()][p.getY() - 1]);
                    } else {
                        System.out.println("no item found :(");
                    }
                    break;
                case USE:
                    p.use(command);
                    break;
                case LOAD:
                    File file = new File(System.getProperty("user.home") + ("\\Documents\\SaveFileTest.txt"));
                    ArrayList<String> loadData = new ArrayList<String>();
                    try {
                        Scanner s2 = new Scanner(file);
                        //now read the word by word
                        while (s2.hasNext()) {
                            String word = s2.next().toString();
                            loadData.add(word);}
                        p.getCurrentRoom().roomArray[p.getY()][p.getX()] = null;
                        p.setName(loadData.get(0));
                        p.setEnergy(Integer.parseInt(loadData.get(1)));
                        p.setX(Integer.parseInt(loadData.get(2)));
                        p.setY(Integer.parseInt(loadData.get(3)));
                       // p.setAssignmentProgress(Integer.parseInt(loadData.get(4)));
                       // p.setGradedAssignments(Integer.parseInt(loadData.get(5)));
                        p.spawnPlayer();
                        PrintOut.displayRoom(p.getCurrentRoom());
                    } catch (FileNotFoundException e) {
                    }
                    break;
                case SAVE:
                    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.home") + "\\Documents\\SaveFileTest.txt")))) {
                        writer.write(p.getName() + " ");
                        writer.write(p.getEnergy() + " ");
                        writer.write(p.getX() + " " + p.getY() + " ");
                        writer.write(p.getAssignmentProgress());
                        writer.write(p.getGradedAssignments());
                    } catch (IOException e) {
                        System.err.println("BEEP BOOP, COULDNT SAVE... please check the save directory in the code.");
                    }
                    break;
                case QUIT:
                    gameLoop = Quit.quit(command);
                    break;
                default:
                    break;
            }
        }

        // Quit boolean, true if user wants to quit.
        return gameLoop;
    }

    public void getCommand() {
        command = parser.getCommand();
    }

    public RoomManager getRooms() {
        return rooms;
    }
}
