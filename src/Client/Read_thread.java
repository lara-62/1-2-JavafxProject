package Client;

import Classes.Club;
import Classes.Player;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import marketing.*;
import news_forum.news_forum_controller;
import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Read_thread implements Runnable{
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   private Main main;
   private Stage stage;
   private Club club;
    private Client.client_controller controller;
    public Read_thread(Socket socket,Main main,ObjectOutputStream oos,ObjectInputStream ois)
    {   this.main=main;
        this.oos=oos;
        stage=main.getStage();
        Thread thread=new Thread(this);
        this.ois=ois;
        thread.start();
    }

    @Override
    public void run() {

        while (true)
        {
            try {
                Object object=ois.readUnshared();
                if (object instanceof Login)
                {
                    Login login=(Login) object;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (login.getIs_status()) {
                                try {
                                    FXMLLoader loader=new FXMLLoader();
                                    loader.setLocation(getClass().getResource("../Client/client.fxml"));
                                    stage=main.getStage();
                                    stage.setTitle("Client");
                                    Parent root=loader.load();
                                    controller=loader.getController();
                                    controller.setoos(oos);
                                    controller.setois(ois);
                                    club=login.getClub();
                                    controller.setClub(club);
                                    controller.setmain(main);


                                    stage.setScene(new Scene(root, 1000, 600));
                                    stage.show();



                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                               // Alert a=new Alert(Alert.AlertType.valueOf("Wrong Username or Password"));
                                Alert a = new Alert(Alert.AlertType.WARNING);
                                a.setContentText("There is No Account with this username and password");
                                a.showAndWait();

                            }

                        }
                    });
                }
                if(object instanceof news)
                {
                    news n=(news) object;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            FXMLLoader loader=new FXMLLoader();
                            loader.setLocation(getClass().getResource("../news_forum/news_forum.fxml"));
                            stage=main.getStage();
                            stage.setTitle("News");
                            Parent root= null;
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            news_forum_controller controller4=loader.getController();

                            controller4.setmain(main);
                            controller4.setlist(n.getList());
                            controller4.setlist2(n.getList2());
                            controller4.setoos(oos);
                            stage.setScene(new Scene(root, 1000, 600));
                            stage.show();

                        }
                    });

                }
                if(object instanceof givelist)
                {

                    givelist g=(givelist) object;

                    List<Player>list=g.getBuy_playerlist();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (controller.getHome()[1] == true) {
                                controller.contain.getChildren().clear();
                                int column = 1, row = 1;
                                for (int i = 0; i < list.size(); i++) {


                                    try {
                                        FXMLLoader fxmlLoader = new FXMLLoader();
                                        System.out.println(list.get(i).getName());
                                        fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                                        VBox cardbox = fxmlLoader.load();
                                        show_controller Show_controller = fxmlLoader.getController();
                                        Show_controller.setPlayer(list.get(i));
                                        Show_controller.sets(ois, oos);
                                        if (column == 3) {
                                            column = 1;
                                            row++;
                                        }
                                        controller.contain.add(cardbox, column++, row);
                                        Show_controller.sellid.setDisable(true);
                                        Show_controller.buyid.setDisable(false);
                                        GridPane.setMargin(cardbox, new Insets(20));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }


                                }
                            }
                        }
                    });

                }
                if(object instanceof Refresh)
                {
                    Refresh refresh=(Refresh) object;

                    for (Player player:refresh.getClub().get_Playerlist())
                    {
                        System.out.println(player.getName());
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            controller.setClub(refresh.getClub());
                            controller.contain.getChildren().clear();
                            controller.clubid.setText(refresh.getClub().getClub_name());
                            int column=1,row=1;
                            for (int i=0;i<refresh.getClub().get_Playerlist().size();i++)
                            {


                                try {
                                    FXMLLoader fxmlLoader=new FXMLLoader();
                                    System.out.println(refresh.getClub().get_Playerlist().get(i).getName());
                                    fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                                    VBox cardbox = fxmlLoader.load();
                                    show_controller Show_controller=fxmlLoader.getController();
                                    Show_controller.setPlayer(refresh.getClub().get_Playerlist().get(i));
                                    Show_controller.sets(ois,oos);
                                    if(column==3)
                                    {
                                        column=1;
                                        row++;
                                    }
                                    controller.contain.add(cardbox,column++,row);

                                    Show_controller.sellid.setDisable(false);
                                    Show_controller.buyid.setDisable(true);
                                    GridPane.setMargin(cardbox,new Insets(20));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                            }
                        }
                    });
                }
                if(object instanceof Logout)
                {
                    Logout logout=(Logout) object;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            try {
                                FXMLLoader loader=new FXMLLoader();
                                loader.setLocation(getClass().getResource("../sample/sample.fxml"));
                                stage=main.getStage();
                                stage.setTitle("Main menu");
                                Parent root= loader.load();
                                sample.Controller controller=loader.getController();
                                controller.setmain(main);
                                controller.setplayerlist(logout.getPlayerList());
                                stage.setScene(new Scene(root, 650, 500));
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
                if(object instanceof givefullist)
                {
                    givefullist g=(givefullist) object;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {



                            try {
                                stage=main.getStage();
                                FXMLLoader loader=new FXMLLoader();
                                loader.setLocation(getClass().getResource("../Input/submenu2.fxml"));
                                stage.setTitle("Search Clubs");
                                Parent root = loader.load();
                                Input.Submenu2_controller controller1=loader.getController();
                                controller1.setmain(main);
                                controller1.setPlayerList(g.getPlayerList());
                                stage.setScene(new Scene(root, 800, 500));
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });

                }
                if(object instanceof givefullist2)
                {
                    givefullist2 g2=(givefullist2) object;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {



                            try {

                                stage=main.getStage();
                                FXMLLoader loader=new FXMLLoader();
                                loader.setLocation(getClass().getResource("../Input/Submenu1.fxml"));
                                stage.setTitle("Search Players");
                                Parent root=loader.load();
                                Input.Submenu1_controller controller2=loader.getController();
                                controller2.setmain(main);
                                controller2.setPlayerList(g2.getPlayerList());
                                stage.setScene(new Scene(root, 652, 500));
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
