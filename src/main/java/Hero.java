import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String myname;
    private int myage;
    private String mypower;
    private String myweakness;
    private int myId;

    private static List<Hero> myHero =new ArrayList<>();

    public Hero(String name,int age,String power,String weakness ) {
        myname = name;
        myage = age;
        mypower = power;
        myweakness = weakness;
        myHero.add(this);
        myId = myHero.size();
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

    public int getId() {
        return myId;
    }

    public static void clear() {
        myHero.clear();
    }

    public static List<Hero> all() {
        return myHero;
    }


    public static Hero find(int id) {
        return myHero.get(id - 1);
    }
}
