package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Reponse {

    private StackPane sp;
    private Rectangle rec;
    private Button bt;
    private Label lb;
    private String BonneRep;
    private String rep;

    public Reponse(double width, double height, Controller choix, int i, String rep){
        this.sp = new StackPane();
        this.rec = new Rectangle(width/2-20, (height/4)-10, Color.LIGHTGREY);
        this.bt = new Button("", rec);
        this.lb = new Label(choix.getChoixTab().get(i));
        sp.getChildren().addAll(rec, bt, lb);
        this.BonneRep = rep;
        this.rep = choix.getChoixTab().get(i);
    }


    public void getVictoire(){
        EventHandler<ActionEvent> testVictoire = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (rep.equalsIgnoreCase(BonneRep)){
                    System.out.println("Bravo");
                }
                else {
                    System.out.println("Mauvais Choix");
                }
            }
        };
        this.bt.setOnAction(testVictoire);
    }

    public StackPane getSp() {
        return sp;
    }
}