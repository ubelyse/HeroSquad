import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String myname;
    private int myage;
    private String mypower;
    private String myweakness;
    private int Id;

    private static List<Hero> myHero =new ArrayList<>();

    public Hero(String name,int age,String power,String weakness ) {
        myname = name;
        myage = age;
        mypower = power;
        myweakness = weakness;
        myHero.add(this);
        Id = myHero.size();
    }

    public String getName() {
        return myname;
    }

    public int getAge() {
        return myage;
    }

    public String getWeakness() {
        return myweakness;
    }

    public String getPower() {
        return mypower;
    }
}
