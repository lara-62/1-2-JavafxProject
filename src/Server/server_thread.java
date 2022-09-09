package Server;

import Classes.Club;
import Classes.Player;
import Classes.news_portal;
import marketing.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class server_thread implements Runnable{
    private List<Player>playerList;
    private List<Player> buyplayer;
    private List<Club>clubs;
    private Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    private HashMap<String,Clientinfo>hashMap;
    private List<news_portal>news_portals;
    private List<news_portal>news_portals2;
    public server_thread(List<Player> playerList, Socket socket, HashMap<String, Clientinfo> hashMap, List<Club> clubs, List<Player> buyplayer, List<news_portal> news_portals, List<news_portal> news_portals2)
    {  this.buyplayer=buyplayer;
        this.news_portals=news_portals;
        this.news_portals2=news_portals2;
        this.hashMap=hashMap;
        this.clubs=clubs;
        this.playerList=playerList;
        this.socket=socket;
        Thread thread=new Thread(this);
        try {
            oos=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread.start();
    }

    @Override
    public void run() {

        while (true)
        {
            try {
                Object object=ois.readUnshared();
                if(object instanceof Signup)
                {
                    Signup signup=(Signup)object;
                    Clientinfo clientinfo=new Clientinfo();
                    clientinfo.setPassword(signup.getPassword());
                    clientinfo.setClub_name(signup.getClubname());
                    hashMap.put(signup.getClubname(),clientinfo);

                }
                if(object instanceof Login)
                {
                   Login login=(Login) object;

                       if (hashMap.containsKey(login.getClubname())) {
                           hashMap.get(login.getClubname()).setOis(ois);
                           hashMap.get(login.getClubname()).setOos(oos);
                           System.out.println((hashMap.get(login.getClubname())).getPassword());
                           login.setIs_status(((hashMap.get(login.getClubname())).getPassword()).equals(login.getPassword()));
                           for(Club club:clubs)
                           {
                               if(club.getClub_name().equalsIgnoreCase(login.getClubname()))
                               {
                                   login.setClub(club);

                               }
                           }
                            oos.writeUnshared(login);
                           oos.flush();
                           oos.reset();
                       }


                }
                if(object instanceof Sell)
                {
                    Sell sell=(Sell) object;
                    buyplayer.add(sell.getPlayer());
                    Refresh refresh=new Refresh();
                    Club club1=new Club();
                    Club club2=new Club();
                    for(Club club:clubs)
                    {
                        if(club.getClub_name().equalsIgnoreCase(sell.getPlayer().getClub_name()))
                        {
                            System.out.println("Yo");
                            club.removeplayer(sell.getPlayer());
                            for (Player player:club.get_Playerlist())
                            {
                                System.out.println(player.getName());
                            }
                            //club1=club;
                            refresh.setClub(club);

                        }
                    }
                    for (Player player:refresh.getClub().get_Playerlist())
                    {
                        System.out.println(player.getName()+"lara");
                    }
                    oos.writeUnshared(refresh);

                    oos.flush();
                    oos.reset();
                    //                    for (Player player:club1.get_Playerlist())
//                    {
//                        if(player.getName().equalsIgnoreCase(sell.getPlayer().getName()))
//                        {
//
//                        }
//                        else
//                        {
//                            club2.addplayer(player);
//                        }
//                    }
//                    refresh.setClub(club2);
//                    club2.setClub_name(club1.getClub_name());
                    for(Clientinfo clientinfo:hashMap.values()) {
                        givelist g = new givelist();
                        List<Player> list = new ArrayList<>();

                        for (int i = 0; i < buyplayer.size(); i++) {

                            if (clientinfo.getClub_name().equalsIgnoreCase(buyplayer.get(i).getClub_name())) {

                            } else {
                                list.add(buyplayer.get(i));
                            }


                        }

                        g.setBuy_playerlist(list);
                        clientinfo.getOos().writeUnshared(g);
                        clientinfo.getOos().flush();
                        clientinfo.getOos().reset();
                    }

                }
                if(object instanceof news)
                {
                    news n=new news();
                    n.setList(news_portals);
                    n.setList2(news_portals2);
                    oos.writeUnshared(n);
                    oos.flush();
                    oos.reset();
                }
                if(object instanceof Buy)
                {
                    Buy buy=(Buy) object;
                    //Refresh refresh=new Refresh();
//                    hashMap.get(buy.getClub_name()).getOos().writeUnshared(refresh1);
//                    for(Club club:clubs)
//                    {
//                        if(club.getClub_name().equalsIgnoreCase(buy.getClub_name()))
//                        {
//                            System.out.println("Yo");
//                            club.removeplayer(buy.getPlayer());
//                            for (Player player:club.get_Playerlist())
//                            {
//                                System.out.println(player.getName());
//                            }
//                        }
//                    }
                    String to=new String();
                    for(Clientinfo clientinfo:hashMap.values())
                    {
                        if(clientinfo.getOos().equals(oos))
                        {
                            System.out.println("Yo");
                            to=clientinfo.getClub_name();
                        }
                    }
                 for (Iterator<Player>iterator=buyplayer.iterator();iterator.hasNext();)
                 {
                     Player player=iterator.next();
                     if(player.getName().equalsIgnoreCase(buy.getPlayer().getName()))
                     {
                         iterator.remove();
                         System.out.println("Removed");
                     }
                 }

                    System.out.println("\n");
                    for (Player player:playerList)
                    {
                        if(player.getName().equalsIgnoreCase(buy.getPlayer().getName()))
                        {
                            System.out.println("yo");
                            player.setClub_name(to);
                        }
                    }

                   for (Club club:clubs)
                   {
                       if(club.getClub_name().equalsIgnoreCase(to))
                       {
                           System.out.println("yo");
                           buy.getPlayer().setClub_name(club.getClub_name());
                           club.addplayer(buy.getPlayer());
                          // refresh.setClub(club);
                           for (Player player:club.get_Playerlist())
                           {
                               System.out.println(player.getName());
                           }

                       }


//                       givelist g=new givelist();
//
//                       List<Player>list=new ArrayList<>();
//                       System.out.println("\n"+buyplayer.size()+hashMap.size()+"\n");
//                       for(int i=0;i<buyplayer.size();i++)
//                       {
//
//                           if(to.equalsIgnoreCase(buyplayer.get(i).getClub_name()))
//                           {
//
//                           }
//                           else {
//                               list.add(buyplayer.get(i));
//                           }
//
//
//                       }
//
//                       g.setBuy_playerlist(list);
//                       oos.writeUnshared(g);
//                       oos.flush();
//                       oos.reset();
                  // }
                       for(Clientinfo clientinfo:hashMap.values()) {
                           givelist g = new givelist();
                           List<Player> list = new ArrayList<>();

                           for (int i = 0; i < buyplayer.size(); i++) {

                               if (clientinfo.getClub_name().equalsIgnoreCase(buyplayer.get(i).getClub_name())) {

                               } else {
                                   list.add(buyplayer.get(i));
                               }


                           }

                           g.setBuy_playerlist(list);
                           clientinfo.getOos().writeUnshared(g);
                           clientinfo.getOos().flush();
                           clientinfo.getOos().reset();
                       }

                   }


                }
                if(object instanceof givelist)
                {

                    givelist g=(givelist) object;
                    System.out.println(g.getClub_name());
                    List<Player>list=new ArrayList<>();
                    System.out.println("\n"+buyplayer.size()+hashMap.size()+"\n");
                   for(int i=0;i<buyplayer.size();i++)
                   {

                        if(g.getClub_name().equalsIgnoreCase(buyplayer.get(i).getClub_name()))
                        {

                        }
                        else {
                            list.add(buyplayer.get(i));
                        }


                   }

                   g.setBuy_playerlist(list);
                    oos.writeUnshared(g);
                    oos.flush();
                    oos.reset();

                }
                if (object instanceof Refresh)
                {
                    Refresh refresh=(Refresh) object;
                    Club club1=new Club();
                    Club club2=new Club();
                    for (Club club:clubs)
                    {
                        if(club.getClub_name().equalsIgnoreCase(refresh.getClub().getClub_name()))
                        {
                            System.out.println("yo");

                            for (Player player:club.get_Playerlist())
                            {
                                System.out.println(player.getName());
                            }
                       club1=club;
                        }

                    }
                    for (Player player:club1.get_Playerlist())
                    {
                            club2.addplayer(player);

                    }
                    Refresh give=new Refresh();
                    club2.setClub_name(club1.getClub_name());
                    give.setClub(club2);
                    oos.writeUnshared(give);
                    oos.flush();
                    oos.reset();
                }
                if(object instanceof Logout)
                {
                    Logout l=new Logout();
                    l.setPlayerList(playerList);
                    oos.writeUnshared(l);
                    oos.flush();
                    oos.reset();
                }
                if(object instanceof givefullist)
                {
                    givefullist Givefulllist=(givefullist) object;
                    Givefulllist.setPlayerList(playerList);
                    oos.writeUnshared(Givefulllist);
                    oos.flush();
                    oos.reset();
                }
                if(object instanceof givefullist2)
                {
                    givefullist2 Givefulllist2=(givefullist2) object;
                    Givefulllist2.setPlayerList(playerList);
                    oos.writeUnshared(Givefulllist2);
                    oos.flush();
                    oos.reset();
                }
            }

            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
