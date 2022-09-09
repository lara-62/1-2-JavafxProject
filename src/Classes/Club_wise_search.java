package Classes;//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Club_wise_search {
    //private List<String>clublist=new ArrayList<>();

    public void clubsubmenu(List<Player>playerList)
    {
       // addclub(playerList);
        Scanner scanner=new Scanner(System.in);
        int option;
        String club_name;
        boolean exit=false;
        while (true) {
            System.out.println("CLUB SEARCHING OPTIONS:");
            System.out.println("\t(1) Player(s) with the maximum salary of a club\n" +
                    "\t(2) Player(s) with the maximum age of a club\n" +
                    "\t(3) Player(s) with the maximum height of a club\n" +
                    "\t(4) Total yearly salary of a club\n" +
                    "\t(5) Back to Main Menu");
            System.out.println("Select one option from above(1-5):");
            option=scanner.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("Input a club name:");
                    scanner.nextLine();
                    club_name=scanner.nextLine();
                    club_name=club_name.trim();
                    if(is_club(playerList,club_name))
                    {
                        search_by_maximum_salary(playerList,club_name);
                    }
                    else
                    {
                        System.out.println("No such club with this name!");
                    }
                    break;

                case 2:
                    System.out.println("Input a club name:");
                    scanner.nextLine();
                    club_name=scanner.nextLine();
                    club_name=club_name.trim();
                    if(is_club(playerList,club_name))
                    {
                        search_by_maximum_Age(playerList,club_name);
                    }
                    else
                    {
                        System.out.println("No such club with this name!");
                    }
                    break;
                case 3:
                    System.out.println("Input a club name:");
                    scanner.nextLine();
                    club_name=scanner.nextLine();
                    club_name=club_name.trim();
                    if(is_club(playerList,club_name))
                    {
                        search_by_maximum_Height(playerList,club_name);
                    }
                    else
                    {
                        System.out.println("No such club with this name!");
                    }
                    break;
                case 4:
                    System.out.println("Input a club name:");
                    scanner.nextLine();
                    club_name=scanner.nextLine();
                    club_name=club_name.trim();
                    if(is_club(playerList,club_name))
                    {
                        total_yearly_salary(playerList,club_name);
                    }
                    else
                    {
                        System.out.println("No such club with this name!");
                    }
                    break;
                case 5: exit=true;
                break;
                default:
                    System.out.println("You have chosen an invalid option.PLz choose from 1 to 5 to do the respective task.THANKS!");


            }
            if(exit)
            {
                break;
            }

        }

    }
    /*public void addclub(List<Player>playerList)
    {
        for(Player ob:playerList)
        {
            if(!clublist.contains(ob.getClub_name()))
            {
                clublist.add(ob.getClub_name());
            }
        }
    }*/
    public boolean is_club(List<Player>playerList,String name)
    {
        for(Player ob:playerList)
        {
            if(ob.getClub_name().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }
    public double  search_by_maximum_salary(List<Player>playerList,String club_name)
    {
      double max=-1;
      for(Player ob:playerList)
      {
          if(ob.getClub_name().equalsIgnoreCase(club_name))
          {
              if(ob.getWeekly_salary()>max)
              {
                  max=ob.getWeekly_salary();
              }
          }
      }
//        for(Player ob:playerList)
//        {
//            if(ob.getWeekly_salary()==max)
//            {
//               ob.show_information();
//                System.out.println();
//            }
//        }
        return max;

    }
    public int search_by_maximum_Age(List<Player>playerList,String club_name)
    {
      int max=-1;
        for(Player ob:playerList)
        {
            if(ob.getClub_name().equalsIgnoreCase(club_name))
            {
                if(ob.getAge()>max)
                {
                    max=ob.getAge();
                }
            }
        }
//        for(Player ob:playerList)
//        {
//            if(ob.getAge()==max)
//            {
//                ob.show_information();
//                System.out.println();
//            }
//        }
       return max;
    }
    public double search_by_maximum_Height(List<Player>playerList,String club_name)
    {
        double max=0;
        for(Player ob:playerList)
        {
            if(ob.getClub_name().equalsIgnoreCase(club_name))
            {
                if(ob.getHeight()>max)
                {
                    max=ob.getHeight();
                }
            }
        }
        return max;
//        for(Player ob:playerList)
//        {
//            if(ob.getHeight()==max)
//            {
//                ob.show_information();
//                System.out.println();
//            }
//        }

    }
    public double total_yearly_salary(List<Player>playerList,String club_name)
    {
        double total=0.0;
        for(Player ob:playerList)
        {
            if(ob.getClub_name().equalsIgnoreCase(club_name))
            {
                total+=(ob.getWeekly_salary()*52);
            }
        }
        return total;
//        System.out.printf("Total salary of club "+club_name.toUpperCase()+" is: "+"%10.02f\n",total);
    }
}
