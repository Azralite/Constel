package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    public ImageImport a = new ImageImport();

    public Image[] tabImgEmpty = a.getTabImgEmpty();
    public Image[] tabImgLabeled = a.getTabImgLabel();
    public String[] tapName = a.getTapName();




    @Override
    public void start(Stage primaryStage){

        Random rand = new Random();
        int alea = rand.nextInt(tabImgEmpty.length);
        ImageView imageView = new ImageView(tabImgEmpty[alea]);

        Controller choix = new Controller(tapName, tapName[alea]);

        double width = tabImgEmpty[alea].getWidth()*2;
        double height = tabImgEmpty[alea].getHeight();

        imageView.setX(0);
        imageView.setY(0);

        imageView.setPreserveRatio(true);

        imageView.setFitHeight(height);
//        imageView.setFitWidth(width/2);

        HBox root = new HBox();
        VBox img = new VBox();
        img.getChildren().add(imageView);

        VBox choices = new VBox();


        Reponse r1 = new Reponse(width, height, choix, 0, tapName[alea]);
        Reponse r2 = new Reponse(width, height, choix, 1, tapName[alea]);
        Reponse r3 = new Reponse(width, height, choix, 2, tapName[alea]);
        Reponse r4 = new Reponse(width, height, choix, 3, tapName[alea]);

        

        EventHandler<ActionEvent> testVictoire = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (choix.getChoixTab().get(0).equalsIgnoreCase(tapName[alea])){
                    System.out.println("Bravo");
                }
                else {
                    System.out.println("Mauvais Choix");
                }
            }
        };

        r1.getVictoire();
        r2.getVictoire();
        r3.getVictoire();
        r4.getVictoire();

        choices.getChildren().addAll(r1.getSp(),r2.getSp(),r3.getSp(),r4.getSp());

        root.getChildren().addAll(img, choices);

        //Group root2 = new Group(imageView);


        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Constellation");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        //TODO : Charger les images avant de lancer l'application, ca fait plus pro :) 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
