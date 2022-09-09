package Input;
import Classes.Player;
import Classes.Club_wise_search;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Submenu2_controller {
    public Button okButton;
    public TextField textfield;
    public HBox hbox;
    public Label total_salary2;
    public Label total_salary1;
    public Label total_salary3;
    private Main main;
    private Stage stage;
    private FXMLLoader loader;
    public String club_name;
    public boolean salary;
    public boolean age;
    public boolean height;
    public boolean total_salary;
    private List<Player>playerList;
    public void ok(ActionEvent actionEvent) {
        Club_wise_search object=new Club_wise_search();
        club_name=textfield.getText();
        club_name=club_name.trim();
        List<Player>list=new ArrayList<>();
        if(object.is_club(playerList,club_name))
        {  if(total_salary)
        {
           double s=object.total_yearly_salary(playerList,club_name);
           total_salary1.setText(club_name.toUpperCase());
           total_salary1.setVisible(true);
           String str=String.format("%8.0f",s);
           total_salary2.setText(str);
           total_salary2.setVisible(true);
           total_salary3.setVisible(true);

        }
        else {
            if (salary) {
                double s = object.search_by_maximum_salary(playerList, club_name);
                for (Player ob : playerList) {
                    if (ob.getClub_name().equalsIgnoreCase(club_name)) {
                        if (ob.getWeekly_salary() == s) {
                            list.add(ob);
                        }
                    }
                }


            }
            if (age) {
                int s = object.search_by_maximum_Age(playerList, club_name);
                for (Player ob : playerList) {
                    if (ob.getClub_name().equalsIgnoreCase(club_name)) {
                        if (ob.getAge() == s) {
                            list.add(ob);
                        }
                    }
                }
            }
            if (height) {
                double s = object.search_by_maximum_Height(playerList, club_name);
                for (Player ob : playerList) {
                    if (ob.getClub_name().equalsIgnoreCase(club_name)) {
                        if (ob.getHeight() == s) {
                            list.add(ob);
                        }
                    }
                }
            }
            stage.setTitle("Players Data");
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Players_show_data.player_data_controller controller = loader.getController();
            try {
                controller.setPlayerList(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
            controller.setmain(main,playerList);
            controller.setLabel(club_name.toUpperCase());
            controller.setNumber(2);
            stage.setScene(new Scene(root, 1000, 600));
            stage.show();
        }
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("There is No Club with this name");
            textfield.setText("");
            a.showAndWait();

        }
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
        total_salary2.setVisible(false);
        total_salary3.setVisible(false);
        total_salary1.setVisible(false);

    }

    public void total_yearly_salary(ActionEvent actionEvent) {

        salary=false;
        total_salary=true;
        height=false;
        age=false;
        total_salary2.setVisible(false);
        total_salary3.setVisible(false);
        total_salary1.setVisible(false);
    }

    public void maximum_height(ActionEvent actionEvent) {
        salary=false;
        total_salary=false;
        height=true;
        age=false;
        total_salary2.setVisible(false);
        total_salary3.setVisible(false);
        total_salary1.setVisible(false);

    }

    public void maximum_age(ActionEvent actionEvent) {
        salary=false;
        total_salary=false;
        height=false;
        age=true;
        total_salary2.setVisible(false);
        total_salary3.setVisible(false);
        total_salary1.setVisible(false);
    }

    public void maximum_salary(ActionEvent actionEvent) {
        salary=true;
        total_salary=false;
        height=false;
        age=false;
        total_salary2.setVisible(false);
        total_salary3.setVisible(false);
        total_salary1.setVisible(false);
    }

    public void setmain(Main instance) {
        main=instance;

        stage = main.getStage();
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Players_show_data/player_data.fxml"));
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
