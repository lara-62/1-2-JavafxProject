package marketing;

import Classes.Club;
import Classes.Player;

import java.io.Serializable;
import java.util.List;

public class givelist implements Serializable {
    public List<Club> list;
    public List<Player> buy_playerlist;
    public String club_name;
    public void setList(List<Club> list) {
        this.list = list;
    }

    public List<Club> getList() {
        return list;
    }

    public void setBuy_playerlist(List<Player> buy_playerlist) {
        this.buy_playerlist = buy_playerlist;
    }

    public List<Player> getBuy_playerlist() {
        return buy_playerlist;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getClub_name() {
        return club_name;
    }
}
