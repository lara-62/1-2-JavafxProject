package marketing;

import Classes.Player;

import java.io.Serializable;

public class Buy implements Serializable {
    private String Club_name;
    private Player player;

    public void setClub_name(String club_name) {
        Club_name = club_name;
    }

    public void setPlayer(Player player_name) {
        this.player = player_name;
    }

    public String getClub_name() {
        return Club_name;
    }

    public Player getPlayer() {
        return player;
    }
}
