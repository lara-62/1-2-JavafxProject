package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Club implements Serializable {
    private String club_name;
    private int Player_no=0;
    public List<Player>obj;
    public Club()
    {
        obj=new ArrayList<>();
    }
   public void addplayer(Player ob)
   {
    obj.add(ob);
    Player_no++;
   }
   public String getClub_name()
   {
       return club_name;
   }

   public void setClub_name(String name)
   {
       club_name=name;
   }
   public int getPlayer_no()
   {
       return Player_no;
   }
   public List<Player> get_Playerlist()
   {
       return obj;
   }
   public void removeplayer(Player player)
   {

        for (Iterator<Player> iterator = obj.iterator(); iterator.hasNext();)
   {
       Player o=iterator.next();
       if(o.getName().equalsIgnoreCase(player.getName()))
       {
           iterator.remove();
           System.out.println("Removed");
       }
   }
        for (Player object:get_Playerlist())
        {
            System.out.println(object.getName());
        }

   }

}
