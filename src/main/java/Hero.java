import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String myname;
    private int myage;
    private String power;
    private String weakness;
    private int Id;

    private static List<Hero> myHero =new ArrayList<>();

    public Hero(String name,int age,String power,String weakness ) {
        myname = name;
        myage = age;
        power = power;
        weakness = weakness;
        myHero.add(this);
        Id = myHero.size();
    }

    public String getName() {
        return myname;
    }

    public int getAge() {
        return myage;
    }

}
