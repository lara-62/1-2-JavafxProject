package sample;
import Classes.Player;
import Classes.Club;
import Classes.add_club;
import Server.server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application implements Serializable {
    public Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root=loader.load();
         Controller controller=loader.getController();
         controller.setmain(this);
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(new Scene(root, 650, 500));
        this.stage=primaryStage;

        primaryStage.show();

    }
    public  Stage getStage() {
        return  stage;

    }



    public static void main(String[] args) throws Exception {


        launch(args);
    }


}
