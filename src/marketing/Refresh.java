package marketing;

import Classes.Club;
import Classes.Player;

import java.io.Serializable;
import java.util.List;

public class Refresh implements Serializable {
    private Club club;
    private List<Player> buyplayer;

    public void setClub(Club club) {

        this.club = club;
    }

//    //public void setBuyplayer(List<Player> buyplayer) {
//        this.buyplayer = buyplayer;
//    }

    public Club getClub() {
        return club;
    }

//   // public List<Player> getBuyplayer() {
//        return buyplayer;
//    }
}
