/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuulgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import worldofzuul.Game;

/**
 *
 * @author J
 */
public class FXMLDocumentController implements Initializable {

    private Game g = new Game();
    private ImageView[][] imageArray = new ImageView[10][10];
    private Label label;
    private GridPane gPane;
    @FXML
    private Pane p;
    @FXML
    private Canvas c;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//
//                x += 64;
//            }
//            y += 64;
//        }
    }

    /**
     * fills a 2d ImageView array with images and then adds them to the gridpane
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int x = 64;
        int y = 64;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                    imageArray[i][j] = new ImageView(new Image("test.png"));
                    imageArray[i][j].setX(x * j);
                    imageArray[i][j].setY(y * i);
                    

            }
        }
    }

    public void drawImages() {
        GraphicsContext gc = c.getGraphicsContext2D();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                c.getGraphicsContext2D().drawImage(imageArray[i][j].getImage(),imageArray[i][j].getX() , imageArray[i][j].getY());
            }
        }

    }

}
