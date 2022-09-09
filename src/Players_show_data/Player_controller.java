package Players_show_data;

import Classes.Player;

import Client.PlayerDetail_controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class Player_controller {


    public ImageView image;
    public Label name;
    private Player object;

    public void set_data(Player object)
    {
         name.setText(object.getName());
         image.setImage(new Image(getClass().getResourceAsStream(object.getImage())));
        this.object=object;

    }

    public void detail(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../Client/Player_detail.fxml"));
            DialogPane p=fxmlLoader.load();
            PlayerDetail_controller playerDetail_controller=fxmlLoader.getController();
            playerDetail_controller.Set_data(object);
            Dialog<ButtonType> dialog=new Dialog<>();
            dialog.setDialogPane(p);
            dialog.setTitle("Detail Information");
            dialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
