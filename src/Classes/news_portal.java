package Classes;

import java.io.Serializable;

public class news_portal implements Serializable {
    private String club_name1;
    private String club_image1;
    private String club_name2;
    private String club_image2;
    private String time;
     private int goal1;
     private int goal2;
    public void setClub_image1(String club_image1) {
        this.club_image1 = club_image1;
    }

    public void setClub_image2(String club_image2) {
        this.club_image2 = club_image2;
    }

    public void setClub_name1(String club_name1) {
        this.club_name1 = club_name1;
    }

    public void setClub_name2(String club_name2) {
        this.club_name2 = club_name2;
    }

    public String getClub_image1() {
        return club_image1;
    }

    public String getClub_image2() {
        return club_image2;
    }

    public String getClub_name1() {
        return club_name1;
    }

    public String getClub_name2() {
        return club_name2;
    }

    public void settime(String s) {
        time=s;

    }

    public void setGoal1(int goal1) {
        this.goal1 = goal1;
    }

    public void setGoal2(int goal2) {
        this.goal2 = goal2;
    }

    public int getGoal1() {
        return goal1;
    }

    public int getGoal2() {
        return goal2;
    }

    public String getTime() {
        return time;
    }
    private String t;

    public void setT(String t) {
        this.t = t;
    }

    public String getT() {
        return t;
    }
}
