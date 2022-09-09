package Client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client {
    private Main main;
    private Stage stage;
    private ObjectOutputStream oos;
private ObjectInputStream ois;
  public client(Main main,Socket socket,ObjectOutputStream oos,ObjectInputStream ois)
  {
      this.main=main;
      stage=main.getStage();
      try {

          this.oos=oos;
          this.ois=ois;



          FXMLLoader loader=new FXMLLoader();
          loader.setLocation(getClass().getResource("../Client/Login.fxml"));
          stage.setTitle("Login");
          Parent root=loader.load();
          Client.Login_controller controller=loader.getController();
          controller.setoos(oos);
          stage.setScene(new Scene(root, 652, 500));
          stage.show();


      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
