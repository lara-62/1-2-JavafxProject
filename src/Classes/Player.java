package Classes;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String country;
    private String club_name;
    private String position;
    private int age,number;
    private double height,weekly_salary;
    private boolean sell;
    private boolean buy=true;
    private String image;
   public void setName(String name)
    {
        this.name=name;

    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public boolean isBuy() {
        return buy;
    }

    public boolean isSell() {
        return sell;
    }


    public void setCountry(String country)
    {
        this.country=country;
    }
    public void setClub_name(String club_name)
    {
        this.club_name=club_name;
    }
    public void setPosition(String position)
    {
        this.position=position;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void setNumber(int number)
    {
        this.number=number;
    }
    public void setHeight(double height)
    {
       this.height=height;
    }
    public void setWeekly_salary(double weekly_salary)
    {
        this.weekly_salary=weekly_salary;
    }
    public String getName()
    {
        return name;
    }
    public String getCountry()
    {
        return country;
    }
    public String getClub_name()
    {
        return club_name;
    }
    public String getPosition()
    {
        return position;
    }
    public int getAge()
    {
       return age;
    }
    public int getNumber()
    {
        return number;
    }
    public double getHeight()
    {
      return height;
    }
    public double getWeekly_salary()
    {
        return weekly_salary;
    }
    void show_information()
    {
        System.out.println("NAME: "+getName()+"\nCOUNTRY: "+getCountry()+"\nAGE:"+getAge()+"\nHEIGHT: "+getHeight()+" meters"+"\nCLUB: "+getClub_name()+
                "\nPOSITION: "+getPosition()+"\nNUMBER: "+getNumber()+"\nWEEKLY_SALARY: "+getWeekly_salary());
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
