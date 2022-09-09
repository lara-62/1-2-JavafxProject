package Input;

import Classes.Player;
import Classes.Search;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.Controller;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Submenu1_controller implements Initializable {
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public boolean b1=false;
    public boolean b2=false;
    public boolean b3=false;
    public boolean b4=false;
    public boolean b5=false;
    public boolean b6=false;
    public TextField textfield;
    public Button okButton;
    public HBox hbox;
    private Main main;
    private String name;
    private String position;
    private String[] country_club;
    private String[] salary;

    private Stage stage;
    private List<Player>playerList;
    private FXMLLoader loader;
    public void setmain(Main instance) {
       main=instance;

        stage = main.getStage();
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Players_show_data/player_data.fxml"));
    }
    public void setPlayerList(List<Player>playerList)
    {
        this.playerList=playerList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void Back_to_main_menu(ActionEvent actionEvent) throws IOException {

        loader.setLocation(getClass().getResource("../sample/sample.fxml"));
        stage.setTitle("Main menu");
        Parent root=loader.load();
        sample.Controller controller=loader.getController();
        controller.setmain(main);
        controller.setplayerlist(playerList);
        stage.setScene(new Scene(root, 650, 500));
        stage.show();


    }

    public void Country_wise_player_count(ActionEvent actionEvent) throws IOException {
        Search obj = new Search();
        List<String>country_list=obj.country_wise_countforplayers(playerList);
        HashMap<String,Integer>hashMap=new HashMap<>();
        int count;
        for(String player:country_list)
        {
            count=0;
            for(Player ob:playerList)
            {
                if(ob.getCountry().equalsIgnoreCase(player))
                {
                    count++;
                }
            }
            hashMap.put(player,count);
        }
        stage.setTitle("Players Data");
        Parent root = loader.load();
        Players_show_data.player_data_controller controller = loader.getController();
        controller.setPlayerList(country_list,hashMap);
        controller.setmain(main,playerList);
        controller.setLabel("COUNTRY WISE PLAYER COUNT");
        stage.setScene(new Scene(root, 1000, 600));
        stage.show();


    }

    public void Salary_Range(ActionEvent actionEvent) {
        hbox.setVisible(true);
        textfield.setDisable(false);
        textfield.setVisible(true);
        okButton.setDisable(false);
        okButton.setVisible(true);
        textfield.setPromptText("Search By Salary Range");
        b4=true;
        b1=b2=b3=b5=b6=false;

    }

    public void By_Position(ActionEvent actionEvent) {
        hbox.setVisible(true);
        textfield.setDisable(false);
        textfield.setVisible(true);
        okButton.setDisable(false);
        okButton.setVisible(true);
        textfield.setPromptText("Search By Position");
        b3=true;
        b1=b2=b4=b5=b6=false;
    }

    public void By_Club_and_Country(ActionEvent actionEvent) {
        hbox.setVisible(true);
        textfield.setDisable(false);
        textfield.setVisible(true);
        okButton.setDisable(false);
        okButton.setVisible(true);
        textfield.setPromptText("Search By Country and Club");
        b2=true;
        b1=b3=b4=b5=b6=false;

    }

    public void By_Player_name(ActionEvent actionEvent) {
        hbox.setVisible(true);
        textfield.setDisable(false);
        textfield.setVisible(true);
        okButton.setDisable(false);
        okButton.setVisible(true);
        textfield.setPromptText("Search By player name");
        b1=true;
        b2=b3=b4=b5=b6=false;

    }

    public void ok(ActionEvent actionEvent) throws IOException {
        if(b1==true) {
            name = textfield.getText();
            Search obj = new Search();
            int i = obj.searchbyname(name, playerList);
            textfield.setText("");
            hbox.setVisible(false);
            textfield.setVisible(false);
            okButton.setVisible(false);
            okButton.setDisable(true);
            textfield.setDisable(true);
            if (i == -1) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player with this name");
                textfield.setText("");
                a.showAndWait();
                System.out.println("wrong");



            } else {
                List<Player> list = new ArrayList<>();
                list.add(playerList.get(i));



                stage.setTitle("Players Data");
                Parent root = loader.load();
                Players_show_data.player_data_controller controller = loader.getController();
                controller.setPlayerList(list);
                controller.setmain(main,playerList);
                controller.setLabel("SEARCH BY NAME");
                stage.setScene(new Scene(root, 1000, 600));
                stage.show();

            }
            b1=false;
        }
        if(b3==true)
        {

            position = textfield.getText();

            Search obj = new Search();
            System.out.println(position);
            List<Player> list = obj.searchbyposition(position, playerList);
            textfield.setText("");
            hbox.setVisible(false);
            textfield.setVisible(false);
            okButton.setVisible(false);
            okButton.setDisable(true);
            textfield.setDisable(true);
            System.out.println(list.size());
            if (list.size()==0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player with this position");
                a.showAndWait();
                System.out.println("wrong");



            } else {




                stage.setTitle("Players Data");
                Parent root = loader.load();
                Players_show_data.player_data_controller controller = loader.getController();
                controller.setPlayerList(list);
                controller.setmain(main,playerList);
                controller.setLabel("SEARCH BY POSITION");
                stage.setScene(new Scene(root, 1000, 600));
                stage.show();

            }
            b3=false;

        }
        if(b2==true)
        {
            country_club=textfield.getText().split(",");
            Search obj = new Search();
            //System.out.println(position);
            List<Player> list = obj.searchbyclubandcountry(country_club[0],country_club[1], playerList);
            textfield.setText("");
            hbox.setVisible(false);
            textfield.setVisible(false);
            okButton.setVisible(false);
            okButton.setDisable(true);
            textfield.setDisable(true);
            System.out.println(list.size());
            if (list.size()==0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player with this Country and club");
                a.showAndWait();
                System.out.println("wrong");



            } else {
                stage.setTitle("Players Data");
                Parent root = loader.load();
                Players_show_data.player_data_controller controller = loader.getController();
                controller.setPlayerList(list);
                controller.setmain(main,playerList);
                controller.setLabel("SEARCH BY COUNTRY AND CLUB");
                stage.setScene(new Scene(root, 1000, 600));
                stage.show();

            }
            b3=false;
        }
        if(b4==true)
        {   salary=textfield.getText().split(",");
            Search obj = new Search();
            List<Player> list = obj.search_by_salary_with_range(Double.parseDouble(salary[0]),Double.parseDouble(salary[1]), playerList);
            textfield.setText("");
            hbox.setVisible(false);
            textfield.setVisible(false);
            okButton.setVisible(false);
            okButton.setDisable(true);
            textfield.setDisable(true);
            System.out.println(list.size());
            if (list.size()==0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player in this salary range");
                a.showAndWait();
                System.out.println("wrong");



            } else {
                stage.setTitle("Players Data");
                Parent root = loader.load();
                Players_show_data.player_data_controller controller = loader.getController();
                controller.setPlayerList(list);
                controller.setmain(main,playerList);
                controller.setLabel("SEARCH BY SALARY RANGE");
                stage.setScene(new Scene(root, 1000, 600));
                stage.show();

            }

            b4=false;
        }


    }
}
