package Players_show_data;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class player_data_controller {

    public Stage stage;
    public Main instance;
    public GridPane contain;
    public ScrollPane scroll;
    public Label label;
    private List<Player> list;
    private List<Player> playerList;
    private HashMap<String,Integer>hashMap;
    private int number=1;
    public void setNumber(int number)
    {
        this.number=number;
    }
    public void setmain(Main main,List<Player>playerList)
    {
        instance=main;
        this.playerList=playerList;
    }
    public void setPlayerList(List<Player> list) throws IOException {
        this.list=list;
        int column=1,row=1;
        for (int i=0;i<list.size();i++)
        {
            FXMLLoader fxmlLoader=new FXMLLoader();
            System.out.println(list.get(i).getName());
            fxmlLoader.setLocation(getClass().getResource("Player.fxml"));
            VBox cardbox=fxmlLoader.load();
            Player_controller player_controller=fxmlLoader.getController();
            player_controller.set_data(list.get(i));
            if(column==5)
            {
                column=1;
                row++;
            }
            contain.add(cardbox,column++,row);
            GridPane.setMargin(cardbox,new Insets(15));

        }
    }
    public void setPlayerList(List<String>list, HashMap<String,Integer>hashMap) throws IOException {

        this.hashMap=hashMap;
        int column=1,row=1;
        for (int i=0;i<list.size();i++)
        {
            FXMLLoader fxmlLoader=new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("Country_wise_player_count.fxml"));
            HBox cardbox=fxmlLoader.load();
           Country_wise_player_count_controller controller=fxmlLoader.getController();
            controller.set_data(list.get(i),hashMap.get(list.get(i)));
            if(column==2)
            {
                column=1;
                row++;
            }
            contain.add(cardbox,column++,row);
            GridPane.setMargin(cardbox,new Insets(20));

        }
    }

    public void button(ActionEvent actionEvent) throws IOException {
        if(number==2) {
            stage = instance.getStage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../Input/submenu2.fxml"));

            stage.setTitle("Search Players");
            Parent root = loader.load();
            Input.Submenu2_controller controller = loader.getController();
            controller.setmain(instance);
            controller.setPlayerList(playerList);
            stage.setScene(new Scene(root, 800, 500));
            stage.show();
        }
        else
        {
            stage = instance.getStage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../Input/Submenu1.fxml"));

            stage.setTitle("Search Players");
            Parent root = loader.load();
            Input.Submenu1_controller controller = loader.getController();
            controller.setmain(instance);
          controller.setPlayerList(playerList);
            stage.setScene(new Scene(root, 652, 500));
            stage.show();

        }

    }
    public void setLabel(String s)
    {
        label.setText(s);

    }
}
