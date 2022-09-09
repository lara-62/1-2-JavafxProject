package news_forum;

import Classes.news_portal;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class News2 {
    public ImageView image1;
    public Label name1;
    public Label name2;
    public ImageView image2;
    public Label time;
    public Label goal1;
    public Label goal2;

    public void setPlayer(news_portal news_portal) {
        name2.setText(news_portal.getClub_name2());
        name1.setText(news_portal.getClub_name1());
        image1.setImage(new Image(getClass().getResourceAsStream(news_portal.getClub_image1())));
        image2.setImage(new Image(getClass().getResourceAsStream(news_portal.getClub_image2())));
        time.setText(news_portal.getTime());
        goal1.setText(String.valueOf(news_portal.getGoal1()));
        goal2.setText(String.valueOf(news_portal.getGoal2()));
    }
}
