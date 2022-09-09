package Classes;

import java.util.ArrayList;
import java.util.List;

public class add_club {

    static public void add_club_from_database(List<Club>clubs,List<Player>playerList)
    {
        List<String>clublist=new ArrayList<>();
        for(Player ob:playerList)
        {
            if(!clublist.contains(ob.getClub_name()))
            {
                clublist.add(ob.getClub_name());
            }
        }
        for(String ob:clublist)
        {
            Club object=new Club();
            object.setClub_name(ob);
            clubs.add(object);
        }
        for(Player ob:playerList)
        {
           for (Club ob2:clubs)
           {
               if(ob.getClub_name().equalsIgnoreCase(ob2.getClub_name()))
               {
                   ob2.addplayer(ob);
               }
           }
        }
    }
}
