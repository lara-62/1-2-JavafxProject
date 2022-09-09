package marketing;

import Classes.Player;

import java.io.Serializable;
import java.util.List;

public class Logout implements Serializable {
    private List<Player>playerList;

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
