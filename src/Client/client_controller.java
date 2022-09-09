package Client;

import Classes.Club;
import Classes.Club_wise_search;
import Classes.Player;
import Classes.Search;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import marketing.Logout;
import marketing.Refresh;
import marketing.givelist;
import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class client_controller {
    public Label clubid;
    public TextField text_id;
    public Button ok_button;
    public Button home_id;
    public Button buy_id;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Main main;
    private Stage stage;
    public Club club;
    private List<Player>list;
    private List<Player>buy;
    private List<Player>playerList;
    public GridPane contain;
    private boolean[] home;

    public boolean b1=false;
    public boolean b2=false;
    public boolean b3=false;
    public boolean b4=false;

    public void setoos(ObjectOutputStream oos)
    {
        this.oos=oos;

    }
    public void setClub(Club club)
    {
        this.club=club;
        list=club.get_Playerlist();
    }

    public void setmain(Main main) {
       home=new boolean[2];
       home[0]=true;
       home[1]=false;
        this.main=main;

        stage=main.getStage();

        clubid.setText(club.getClub_name());
        int column=1,row=1;
        for (int i=0;i<list.size();i++)
        {


            try {
                FXMLLoader fxmlLoader=new FXMLLoader();
                System.out.println(list.get(i).getName());
                fxmlLoader.setLocation(getClass().getResource("show.fxml"));
               VBox cardbox = fxmlLoader.load();
                show_controller Show_controller=fxmlLoader.getController();
                Show_controller.setPlayer(list.get(i));

                Show_controller.sets(ois,oos);
                if(column==3)
                {
                    column=1;
                    row++;
                }
                contain.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void Home_action(ActionEvent actionEvent) {
        home[1]=false;
        home[0]=true;
        Refresh refresh=new Refresh();
        refresh.setClub(club);
        try {
            oos.writeUnshared(refresh);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void buy_action(ActionEvent actionEvent) {

       home[1]=true;
       home[0]=false;
        clubid.setText("Market Place");
        givelist g=new givelist();
        g.setClub_name(club.getClub_name());

        try {
            oos.writeUnshared(g);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setois(ObjectInputStream ois) {
        this.ois=ois;

    }


    public void ok_action(ActionEvent actionEvent) {
        if(b1)
        {    String name =text_id.getText();
            Search obj = new Search();
            int i = obj.searchbyname(name, list);
            text_id.setText("");
            if (i == -1) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player with this name");
                text_id.setText("");
                a.showAndWait();
                System.out.println("wrong");



            } else {
                List<Player> l = new ArrayList<>();
                l.add(list.get(i));
                contain.getChildren().clear();
                clubid.setText(club.getClub_name());
                int column=1,row=1;
                for (int j=0;j<l.size();j++)
                {


                    try {
                        FXMLLoader fxmlLoader=new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                        VBox cardbox = fxmlLoader.load();
                        show_controller Show_controller=fxmlLoader.getController();
                        Show_controller.setPlayer(l.get(j));

                        Show_controller.sets(ois,oos);
                        if(column==3)
                        {
                            column=1;
                            row++;
                        }
                        contain.add(cardbox,column++,row);
                        GridPane.setMargin(cardbox,new Insets(20));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
        if(b2)
        {
            Search obj = new Search();
            //System.out.println(position);
            List<Player> l = obj.searchbyclubandcountry(text_id.getText(),club.getClub_name(),list);
            text_id.setText("");
            if (l.size()==0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player of this country");
                text_id.setText("");
                a.showAndWait();
                System.out.println("wrong");



            } else {


                contain.getChildren().clear();
                clubid.setText(club.getClub_name());
                int column=1,row=1;
                for (int j=0;j<l.size();j++)
                {


                    try {
                        FXMLLoader fxmlLoader=new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                        VBox cardbox = fxmlLoader.load();
                        show_controller Show_controller=fxmlLoader.getController();
                        Show_controller.setPlayer(l.get(j));

                        Show_controller.sets(ois,oos);
                        if(column==3)
                        {
                            column=1;
                            row++;
                        }
                        contain.add(cardbox,column++,row);
                        GridPane.setMargin(cardbox,new Insets(20));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
        if(b3)
        {
            Search obj = new Search();
            //System.out.println(position);
            List<Player> l = obj.searchbyposition(text_id.getText(),list);
            text_id.setText("");
            if (l.size()==0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player with this position");
                text_id.setText("");
                a.showAndWait();
                System.out.println("wrong");



            } else {


                contain.getChildren().clear();
                clubid.setText(club.getClub_name());
                int column=1,row=1;
                for (int j=0;j<l.size();j++)
                {


                    try {
                        FXMLLoader fxmlLoader=new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                        VBox cardbox = fxmlLoader.load();
                        show_controller Show_controller=fxmlLoader.getController();
                        Show_controller.setPlayer(l.get(j));

                        Show_controller.sets(ois,oos);
                        if(column==3)
                        {
                            column=1;
                            row++;
                        }
                        contain.add(cardbox,column++,row);
                        GridPane.setMargin(cardbox,new Insets(20));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
        if (b4)
        {
            Search obj = new Search();
            //System.out.println(position);
            String []s=text_id.getText().split(",");
            List<Player> l = obj.search_by_salary_with_range(Double.parseDouble(s[0]),Double.parseDouble(s[1]),list);
            text_id.setText("");
            if (l.size()==0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("There is No Player in this salary range");
                a.showAndWait();
                System.out.println("wrong");



            } else {


                contain.getChildren().clear();
                clubid.setText(club.getClub_name());
                int column=1,row=1;
                for (int j=0;j<l.size();j++)
                {


                    try {
                        FXMLLoader fxmlLoader=new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                        VBox cardbox = fxmlLoader.load();
                        show_controller Show_controller=fxmlLoader.getController();
                        Show_controller.setPlayer(l.get(j));

                        Show_controller.sets(ois,oos);
                        if(column==3)
                        {
                            column=1;
                            row++;
                        }
                        contain.add(cardbox,column++,row);
                        GridPane.setMargin(cardbox,new Insets(20));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        }

        text_id.setVisible(false);
        ok_button.setVisible(false);

    }

    public void player_name_action(ActionEvent actionEvent) {
        b1=true;
        text_id.setVisible(true);
        ok_button.setVisible(true);
        b2=b3=b4=false;
    }

    public void country_action(ActionEvent actionEvent) {
        b2=true;
        text_id.setVisible(true);
        ok_button.setVisible(true);
        b1=b3=b4=false;
    }

    public void position_action(ActionEvent actionEvent) {
        b3=true;
        text_id.setVisible(true);
        ok_button.setVisible(true);
        b2=b1=b4=false;
    }

    public void salary_action(ActionEvent actionEvent) {
        b4=true;
        text_id.setVisible(true);
        ok_button.setVisible(true);
        b2=b3=b1=false;
    }

    public void max_salary(ActionEvent actionEvent) {
        Club_wise_search object=new Club_wise_search();
        List<Player> l = new ArrayList<>();
        double s = object.search_by_maximum_salary(list,club.getClub_name());
        for (Player ob :list) {

            if (ob.getWeekly_salary() == s) {
                l.add(ob);

            }
        }
        contain.getChildren().clear();
        clubid.setText(club.getClub_name());
        int column=1,row=1;
        for (int j=0;j<l.size();j++)
        {


            try {
                FXMLLoader fxmlLoader=new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                VBox cardbox = fxmlLoader.load();
                show_controller Show_controller=fxmlLoader.getController();
                Show_controller.setPlayer(l.get(j));

                Show_controller.sets(ois,oos);
                if(column==3)
                {
                    column=1;
                    row++;
                }
                contain.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

    public void max_height(ActionEvent actionEvent) {
        Club_wise_search object=new Club_wise_search();
        List<Player> l = new ArrayList<>();
        double s = object.search_by_maximum_Height(list,club.getClub_name());
        for (Player ob :list) {

            if (ob.getHeight()== s) {
                l.add(ob);

            }
        }
        contain.getChildren().clear();
        clubid.setText(club.getClub_name());
        int column=1,row=1;
        for (int j=0;j<l.size();j++)
        {


            try {
                FXMLLoader fxmlLoader=new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                VBox cardbox = fxmlLoader.load();
                show_controller Show_controller=fxmlLoader.getController();
                Show_controller.setPlayer(l.get(j));

                Show_controller.sets(ois,oos);
                if(column==3)
                {
                    column=1;
                    row++;
                }
                contain.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void max_age(ActionEvent actionEvent) {
        Club_wise_search object=new Club_wise_search();
        List<Player> l = new ArrayList<>();
        double s = object.search_by_maximum_Age(list,club.getClub_name());
        for (Player ob :list) {

            if (ob.getAge() == s) {
                l.add(ob);

            }
        }
        contain.getChildren().clear();
        clubid.setText(club.getClub_name());
        int column=1,row=1;
        for (int j=0;j<l.size();j++)
        {


            try {
                FXMLLoader fxmlLoader=new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("show.fxml"));
                VBox cardbox = fxmlLoader.load();
                show_controller Show_controller=fxmlLoader.getController();
                Show_controller.setPlayer(l.get(j));

                Show_controller.sets(ois,oos);
                if(column==3)
                {
                    column=1;
                    row++;
                }
                contain.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void logout(ActionEvent actionEvent)  {
        Logout logout=new Logout();
        try {
            oos.writeUnshared(logout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean[] getHome() {
        return home;
    }
}
