package news_forum;

import Classes.news_portal;
import Client.show_controller;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import marketing.Logout;
import sample.Main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class news_forum_controller implements Initializable {
    public ImageView menu;
    public VBox slider;
    public ImageView menu_back;
    public GridPane gridpane;
    private Main main;
    private List<news_portal>list;
    private List<news_portal>list2;
    private ObjectOutputStream oos;
    public void schedule(ActionEvent actionEvent) {
        gridpane.getChildren().clear();
        int column=1,row=1;
        for (int i=0;i<list.size();i++)
        {


            try {
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("news.fxml"));
                AnchorPane cardbox = fxmlLoader.load();
                News news=fxmlLoader.getController();
                news.setPlayer(list.get(i));
                if(column==2)
                {
                    column=1;
                    row++;
                }
               gridpane.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void match_results(ActionEvent actionEvent) {
        gridpane.getChildren().clear();
        int column=1,row=1;
        for (int i=0;i<list2.size();i++)
        {


            try {
                FXMLLoader fxmlLoader=new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("news2.fxml"));
                AnchorPane cardbox = fxmlLoader.load();
                News2 news=fxmlLoader.getController();
                news.setPlayer(list2.get(i));
                if(column==2)
                {
                    column=1;
                    row++;
                }
                gridpane.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(20));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void back(ActionEvent actionEvent) {
        Logout logout=new Logout();
        try {
            oos.writeUnshared(logout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider.setTranslateX(-183);
        menu.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(0);
            slide.play();
            slider.setTranslateX(-183);
            slide.setOnFinished((ActionEvent e)->
            {
                menu.setVisible(false);
                menu_back.setVisible(true);
            });
        });
        menu_back.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide=new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            slide.setToX(-183);
            slide.play();
            slider.setTranslateX(0);
            slide.setOnFinished((ActionEvent e)->
            {
                menu.setVisible(true);
                menu_back.setVisible(false);
            });
        });
    }

    public void setmain(Main instance) {
        this.main=main;
    }

    public void setlist(List<news_portal> list) {
        this.list=list;
    }

    public void setoos(ObjectOutputStream oos) {
        this.oos=oos;
    }

    public void setlist2(List<news_portal> list2) {
        this.list2=list2;
    }
}
