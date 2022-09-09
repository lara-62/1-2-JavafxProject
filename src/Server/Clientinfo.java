package Server;

import javafx.scene.Parent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clientinfo {
    public String club_name;
    public String password;
    public ObjectInputStream ois;
    public ObjectOutputStream oos;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public String getPassword() {
        return password;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public String getClub_name() {
        return club_name;
    }
}
