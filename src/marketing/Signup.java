package marketing;

import java.io.Serializable;

public class Signup implements Serializable {
   public String Clubname;
   public String Password;

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
}
