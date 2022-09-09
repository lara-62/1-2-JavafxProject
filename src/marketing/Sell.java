package marketing;

import Classes.Player;

import java.io.Serializable;

public class Sell implements Serializable {

    private Player player;


    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
