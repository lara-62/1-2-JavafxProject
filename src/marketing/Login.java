package marketing;

import Classes.Club;

import java.io.Serializable;

public class Login implements Serializable {
    public String Clubname;
    public String Password;
    public boolean is_status;
    public Club club;
    public void setClubname(String clubname) {
        Clubname = clubname;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getClubname() {
        return Clubname;
    }

    public String getPassword() {
        return Password;
    }

    public void setIs_status(boolean is_status) {
        this.is_status = is_status;
    }
    public boolean getIs_status()
    {
        return is_status;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Club getClub() {
        return club;
    }
}
