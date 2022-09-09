package Client;


import Classes.Player;
import javafx.scene.control.Label;

public class PlayerDetail_controller {
    public Label nameid;
    public Label countryid;
    public Label ageid;
    public Label heightid;
    public Label clubid;
    public Label positionid;
    public Label numberid;
    public Label salaryid;
    public void Set_data(Player player)
    {
        nameid.setText(player.getName());
        countryid.setText(player.getCountry());
        ageid.setText(String.valueOf(player.getAge()));
        heightid.setText(String.valueOf(player.getHeight()));
        clubid.setText(player.getClub_name());
        positionid.setText(player.getPosition());
        numberid.setText(String.valueOf(player.getNumber()));
        salaryid.setText(String.valueOf(player.getWeekly_salary()));
    }
}
