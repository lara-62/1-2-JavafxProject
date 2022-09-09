package Server;

import Classes.Club;
import Classes.Player;
import Classes.add_club;
import Classes.news_portal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class server {
    private List<Player>playerList;
    private HashMap<String,Clientinfo> hashMap;
    private List<Player> buyplayer;
    private List<news_portal>news_portals;
    private List<news_portal>news_portals2;
    public static List<Player> Listofplayers() throws Exception
    {
        List<Player> playerList=new ArrayList();
        BufferedReader br= new BufferedReader(new FileReader("players.txt"));
        String line;
        while(true)
        {
            line=br.readLine();
            if(line==null)
            {
                break;
            }
            String[] token=line.split(",");
            Player ob=new Player();
            ob.setName(token[0]);
            ob.setCountry(token[1]);
            ob.setAge(Integer.parseInt(token[2]));
            ob.setHeight(Double.parseDouble(token[3]));
            ob.setClub_name(token[4]);
            ob.setPosition(token[5]);
            ob.setNumber(Integer.parseInt(token[6]));
            ob.setWeekly_salary(Double.parseDouble(token[7]));
            ob.setImage(token[8]);
            //System.out.println(ob.getName()+" "+ob.getCountry()+" "+ ob.getAge()+" "+ ob.getHeight()+" "+ob.getClub_name()+" "+ ob.getPosition()+" "+ob.getNumber()+" "+ ob.getWeekly_salary());
            playerList.add(ob);

        }
        return playerList;

    }
    public static List<news_portal> news_portalList() throws Exception
    {
        List<news_portal>newsPortalList=new ArrayList();
        BufferedReader br= new BufferedReader(new FileReader("club.txt"));
        String line;
        while(true)
        {
            line=br.readLine();
            if(line==null)
            {
                break;
            }
            String[] token=line.split(",");
          news_portal n=new news_portal();
          n.setClub_name1(token[0]);
          n.setClub_name2(token[1]);
          n.setClub_image1(token[2]);
          n.setClub_image2(token[3]);
          n.settime(token[4]);
          n.setT(token[5]);
            //System.out.println(ob.getName()+" "+ob.getCountry()+" "+ ob.getAge()+" "+ ob.getHeight()+" "+ob.getClub_name()+" "+ ob.getPosition()+" "+ob.getNumber()+" "+ ob.getWeekly_salary());
            newsPortalList.add(n);

        }
        return newsPortalList;

    }
    public static List<news_portal> news_portalList2() throws Exception
    {
        List<news_portal>newsPortalList=new ArrayList();
        BufferedReader br= new BufferedReader(new FileReader("result.txt"));
        String line;
        while(true)
        {
            line=br.readLine();
            if(line==null)
            {
                break;
            }
            String[] token=line.split(",");
            news_portal n=new news_portal();
            n.setClub_name1(token[0]);
            n.setClub_name2(token[1]);
            n.setClub_image1(token[2]);
            n.setClub_image2(token[3]);
            n.settime(token[4]);
            n.setGoal1(Integer.parseInt(token[5]));
            n.setGoal2(Integer.parseInt(token[6]));
            //System.out.println(ob.getName()+" "+ob.getCountry()+" "+ ob.getAge()+" "+ ob.getHeight()+" "+ob.getClub_name()+" "+ ob.getPosition()+" "+ob.getNumber()+" "+ ob.getWeekly_salary());
            newsPortalList.add(n);

        }
        return newsPortalList;

    }
    public server() throws Exception {
        playerList=Listofplayers();
        news_portals=news_portalList();
        news_portals2=news_portalList2();
        buyplayer=new ArrayList<>();
        hashMap=new HashMap<>();
        List<Club>clubs=new ArrayList<>();
        add_club.add_club_from_database(clubs,playerList);
        try {
            ServerSocket serverSocket=new ServerSocket(2222);
            while (true)
            {
                Socket socket=serverSocket.accept();
                new server_thread(playerList,socket,hashMap,clubs,buyplayer,news_portals,news_portals2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        new server();
    }
}
