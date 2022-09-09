package Players_show_data;

import Classes.Player;
import javafx.scene.control.Label;

public class Country_wise_player_count_controller {

    public Label Countryid;
    public Label count;

    public void set_data(String country, int count_player)
   {
       Countryid.setText(country);
       count.setText(String.valueOf(count_player));

   }
}
