package sample;

import Classes.Player;
import Client.Read_thread;
import Client.client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import marketing.givefullist;
import marketing.givefullist2;
import marketing.news;
import news_forum.news_forum_controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;

public class Controller implements Serializable {
    public ImageView image;
    private Stage stage;
    @FXML
    public Pane pane;
    @FXML
    public VBox vboxsubmenu;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;

    public boolean menu1=false;
    public boolean menu2=false;
    public Main instance;
    public List<Player>playerList;
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    @FXML
    public void Search_by_Club(ActionEvent actionEvent) throws IOException {

        givefullist g=new givefullist();
        oos.writeUnshared(g);


    }
    @FXML
    public void Search_by_players(ActionEvent actionEvent) throws IOException {

        givefullist2 g2=new givefullist2();
        oos.writeUnshared(g2);

    }




    public void marketing(ActionEvent actionEvent) {
        new client(instance,socket,oos,ois);
    }

    public void ExitFromsystem(ActionEvent actionEvent) throws IOException {


        Platform.exit();
        System.exit(0);
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    public void setmain(Main main)
    {
        instance=main;
        try {
            socket=new Socket("127.0.0.1",2222);
            oos=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());
            new Read_thread(socket,instance,oos,ois);

//            image.setImage(new Image(getClass().getResourceAsStream("image/Alisson.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setplayerlist(List<Player>list)
    {
        playerList=list;
    }

    public void news_portal(ActionEvent actionEvent) {
        news n=new news();
        try {
            oos.writeUnshared(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
