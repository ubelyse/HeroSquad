package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hero {


    private String myname;
    private int myage;
    private String mypower;
    private String myweakness;

    public Hero(String myname, int myage, String mypower, String myweakness) {
        this.myname = myname;
        this.myage = myage;
        this.mypower = mypower;
        this.myweakness = myweakness;
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
}
