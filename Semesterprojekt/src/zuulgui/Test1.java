/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuulgui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import worldofzuul.Game;
import worldofzuul.userCommand.Command;
import worldofzuul.userCommand.CommandWord;

/**
 *
 * @author J
 */
public class Test1 extends Application {

    private final int X = 64;
    private final int Y = 64;
    private Game g = new Game();

    @Override
    public void start(Stage primaryStage) {
        // not sure 'bout the usage of Group, im sure you could 
        // replace it with StackPanel or other containers
        Group root = new Group();
        // instantiate scene & add it to the primary stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        // instantiate canvas - where we'll be drawing our images
        Canvas c = new Canvas(640, 640);
        // add it to root
        root.getChildren().add(c);
        // get graphicscontext so that we can call .drawImage
        GraphicsContext gc = c.getGraphicsContext2D();
        // set focus on canvas
        c.setFocusTraversable(true);
        // set keylistener
        c.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case D: g.getPlayer().move(new Command(CommandWord.MOVE,"right"));
                            break;
                    case A: g.getPlayer().move(new Command(CommandWord.MOVE,"left"));
                            break;
                    case W: g.getPlayer().move(new Command(CommandWord.MOVE,"up"));
                            break;
                    case S: g.getPlayer().move(new Command(CommandWord.MOVE,"down"));
                            break;
                }
            }
        });
        // current time in nano time
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // draw room 60 times per second
                drawRoom(gc);
            }
        }.start();
        // display the stage
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void drawRoom(GraphicsContext gc) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Image image = new Image(choosePic(i,j));
                gc.drawImage(image, X*j, Y*i);
            }
        }
    }
    public String choosePic(int row, int col) {
        if(g.getRoomManager().getCurrentRoom().roomArray[row][col] == null) {
            return "500.png";
        } else {
            return "test69.png";
        }
    }

}
