package Classes;

import java.util.List;
import java.util.ArrayList;

public class Search {
    public int searchbyname(String name, List<Player> playerList) {
        int index = -1;
        for (int i = 0; i < playerList.size(); i++) {
            if (name.equalsIgnoreCase(playerList.get(i).getName())) {
                index = i;
                break;
            }

        }
        return index;
    }

    public boolean searchbycountry(String country, List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getCountry().equalsIgnoreCase(country)) {
                return true;
            }
        }

        return false;
    }

    public boolean searchbyclub(String club, List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getClub_name().equalsIgnoreCase(club)) {
                return true;
            }
        }

        return false;
    }

    public List<Player> searchbyclubandcountry(String country, String club, List<Player> playerList) {
        List<Player>test = new ArrayList();
        //System.out.println(test.size());
        if (searchbycountry(country, playerList)) {
            if (club.equalsIgnoreCase("ANY")) {
                for (Player ob : playerList) {
                    if (ob.getCountry().equalsIgnoreCase(country)) {
                        test.add(ob);
                    }
                }
            } else if (searchbyclub(club, playerList)) {
                for (Player ob : playerList) {
                    if (ob.getClub_name().equalsIgnoreCase(club) && ob.getCountry().equalsIgnoreCase(country)) {
                        test.add(ob);
                    }
                }
            }
//            else
//            {
//                for (Player ob : playerList) {
//                    if (ob.getCountry().equalsIgnoreCase(country)) {
//                        test.add(ob);
//                    }
//                }
//            }
       } //else if (searchbyclub(club, playerList)) {
//            for (Player ob : playerList) {
//                if (ob.getClub_name().equalsIgnoreCase(club)) {
//                    test.add(ob);
//                }
//            }
//            return test;
//        }

        return test;
    }
    public List<Player> searchbyposition(String position,List<Player>playerList)
    {
        List<Player> pos=new ArrayList();
        for(Player ob:playerList)
        {
            if(ob.getPosition().equalsIgnoreCase(position))
            {
                pos.add(ob);
            }
        }
        return pos;
    }
    public List<Player>search_by_salary_with_range(double first,double last, List<Player>playerList)
    {
        List<Player>salary=new ArrayList();
        for(int i=0;i< playerList.size();i++)
        {
            if(playerList.get(i).getWeekly_salary()>first&&playerList.get(i).getWeekly_salary()<last)
            {
                salary.add(playerList.get(i));
            }
        }
        return salary;
    }
    public List<String> country_wise_countforplayers(List<Player>playerList)
    {
List<String>Countrylist=new ArrayList<String>();
        for(Player ob:playerList)
        {
            if(!Countrylist.contains(ob.getCountry()))
            {
                Countrylist.add(ob.getCountry());
            }
        }
      /*  int count;
        for(String s:Countrylist)
        {
           count=0;
           for(Player ob:playerList)
           {
               if(ob.getCountry().equalsIgnoreCase(s))
               {
                   count++;
               }
           }
            //System.out.println("In Country "+s.toUpperCase()+" there are "+count+" players");

        }*/
        return Countrylist;

    }
    public void club_search(List<Player>playerList,String club_names)
    {      List<Player>list_ofplayers=new ArrayList<>();
        String[] token=club_names.split(",");
        for(int i=0;i< token.length;i++)
        {
            for (Player ob:playerList)
            {
                if(token[i].equalsIgnoreCase(ob.getClub_name()))
                {
                    list_ofplayers.add(ob);
                }
            }
        }
        for(Player ob:list_ofplayers)
        {
            ob.show_information();
        }
    }
}
