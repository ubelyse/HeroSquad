package models;

import java.util.ArrayList;

public class Hero {



    private String myname;
    private int myage;
    private String mypower;
    private String myweakness;
    private int id;
    private static ArrayList<Hero> myhero = new ArrayList<>();

    private int squadId;

    public Hero(String myname, int myage, String mypower, String myweakness) {
        this.myname = myname;
        this.myage = myage;
        this.mypower = mypower;
        this.myweakness = myweakness;


        myhero.add(this);
        this.id = myhero.size();

    }

    public int getSquadId() {
        return squadId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyname() {
        return myname;
    }

    public int getMyage() {
        return myage;
    }

    public String getMypower() {
        return mypower;
    }

    public String getMyweakness() {
        return myweakness;
    }

    public static ArrayList<Hero> getAllHeroes() {
        return myhero;
    }

    public static void clearAllHeroes(){myhero.clear();
    }
    public int getId(){
        return id;
    }

    public static Hero findById(int id) {
        return myhero.get(id-1);
    }

}
