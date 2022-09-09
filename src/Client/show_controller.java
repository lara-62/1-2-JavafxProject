package Client;

import Classes.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import marketing.Buy;
import marketing.Sell;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class show_controller {
    public Label name;
    public Button buyid;
    public Button sellid;
    private Player player;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;



    public void sell_action(ActionEvent actionEvent) {
        Sell sell=new Sell();

        sell.setPlayer(player);
        try {
            oos.writeUnshared(sell);

        } catch (IOException e) {
            e.printStackTrace();
        }


        sellid.setDisable(true);
       player.setBuy(false);
       player.setSell(true);

    }

    public void Shoe_detail(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../Client/Player_detail.fxml"));
            DialogPane p=fxmlLoader.load();
            PlayerDetail_controller playerDetail_controller=fxmlLoader.getController();
            playerDetail_controller.Set_data(player);
            Dialog<ButtonType>dialog=new Dialog<>();
            dialog.setDialogPane(p);
            dialog.setTitle("Detail Information");
            dialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPlayer(Player player) {

        this.player = player;
        name.setText(player.getName());
        buyid.setDisable(player.isBuy());
        sellid.setDisable(player.isSell());
    }
    public void sets(ObjectInputStream ois, ObjectOutputStream oos) {
        this.ois=ois;
        this.oos=oos;
    }
    public void setBuyid()
    {
        buyid.setDisable(true);
    }

    public void Buyaction(ActionEvent actionEvent) {
        Buy buy=new Buy();
        buy.setClub_name(player.getClub_name());
        buy.setPlayer(player);
        try {
            oos.writeUnshared(buy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
