package marketing;

import Classes.Player;
import sample.Controller;

import java.io.Serializable;
import java.util.List;

public class givefullist implements Serializable {
    Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    private List<Player>playerList;

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
