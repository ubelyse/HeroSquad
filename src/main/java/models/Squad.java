package models;


import java.util.ArrayList;

public class Squad {
    private String myname;
    private int mysize;
    private String mycause;
    private int sqid;
    private ArrayList<Hero>  squadHero = new ArrayList<>();
    private static ArrayList<Squad> mysquad = new ArrayList<>();

    public Squad(String myname, int mysize, String mycause) {
        this.myname = myname;
        this.mysize = mysize;
        this.mycause = mycause;

        this.squadHero = new ArrayList<>();
        mysquad.add(this);
        this.sqid = mysquad.size();
    }

    public String getMyname() {
        return myname;
    }

    public int getMysize() {
        return mysize;
    }

    public String getMycause() {
        return mycause;
    }

    public int getSquadId() {
        return sqid;
    }

    public static Squad findBySquadId(int id) {
        return mysquad.get(id - 1);
    }

    public static ArrayList<Squad> getInstances() {
        return mysquad;
    }

    public ArrayList<Hero> getSquadHero() {
        return squadHero;
    }

    public void setSquadHero(Hero newMember) {
        squadHero.add(newMember);
    }

    public static void clearAllSquads() {
        mysquad.clear();
    }

    public void clearAllSquadHero() {
        getSquadHero().clear();
    }

}
