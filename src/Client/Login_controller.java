package Client;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import marketing.Login;
import marketing.Logout;
import marketing.Signup;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Login_controller {
    
    public TextField textfield1;
    public PasswordField passfield;
    public PasswordField passfield1;
    public Button loginid;
    public Button resetid;
    public Label passid;
    public Label clubname_id;
    private ObjectOutputStream oos;
    public TextField textfield;
   

    public void login_action(ActionEvent actionEvent) {
        Login login=new Login();
        login.setClubname(textfield.getText());
        login.setPassword(passfield.getText());
        try {
            oos.writeUnshared(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textfield.setText("");
        passfield.setText("");
    }

    public void setoos(ObjectOutputStream oos) {
        this.oos=oos;
        resetid.setVisible(false);
        loginid.setVisible(false);
        clubname_id.setVisible(false);
        passid.setVisible(false);
        passfield.setVisible(false);
        textfield.setVisible(false);

    }

    public void Signup_action(ActionEvent actionEvent) {
        Signup signup=new Signup();
        signup.setClubname(textfield1.getText());
        signup.setPassword(passfield1.getText());
        try {
            oos.writeUnshared(signup);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textfield1.setText("");
        passfield1.setText("");
    }

    public void reset_action_for_signup(ActionEvent actionEvent) {
        textfield1.setText("");
        passfield1.setText("");

    }

    public void Resetaction_for_login(ActionEvent actionEvent) {
        textfield.setText("");
        passfield.setText("");

    }

    public void Click_here(ActionEvent actionEvent) {
        resetid.setVisible(true);
        loginid.setVisible(true);
        clubname_id.setVisible(true);
        passid.setVisible(true);
        passfield.setVisible(true);
        textfield.setVisible(true);
    }

    public void previous(ActionEvent actionEvent) {
        Logout logout=new Logout();
        try {
            oos.writeUnshared(logout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
