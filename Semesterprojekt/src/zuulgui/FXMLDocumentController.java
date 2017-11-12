/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuulgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import worldofzuul.Game;
import worldofzuul.userCommand.Command;
import worldofzuul.userCommand.CommandWord;

/**
 *
 * @author J
 */
public class FXMLDocumentController implements Initializable {

    private Game g = new Game();
    private final int X = 64;
    private final int Y = 64;
    @FXML
    private Canvas c;
    @FXML
    private Pane pane;
    @FXML
    private Button button;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        GraphicsContext gc = c.getGraphicsContext2D();
        // set focus on canvas
        pane.setFocusTraversable(true);
        // set keylistener
        pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D:
                        g.getPlayer().move(new Command(CommandWord.MOVE, "right"));
                        System.out.println("hello");
                        break;
                    case A:
                        g.getPlayer().move(new Command(CommandWord.MOVE, "left"));
                        break;
                    case W:
                        g.getPlayer().move(new Command(CommandWord.MOVE, "up"));
                        break;
                    case S:
                        g.getPlayer().move(new Command(CommandWord.MOVE, "down"));
                        break;
                }
            }
        });

        // current time in nano time
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // draw room 60 times per second
                drawImages(gc);
            }
        }.start();

    }

    /**
     * fills a 2d ImageView array with images and then adds them to the gridpane
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("hello");
    }

    public void drawImages(GraphicsContext gc) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Image image = new Image(choosePic(i, j));
                gc.drawImage(image, X * j, Y * i);
            }
        }

    }

    public String choosePic(int row, int col) {
        if (g.getRoomManager().getCurrentRoom().roomArray[row][col] == null) {
            return "500.png";
        } else {
            return "test69.png";
        }
    }

}
