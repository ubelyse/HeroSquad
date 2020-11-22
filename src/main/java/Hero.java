import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int age;
    private String power;
    private String weakness;
    private int Id;

    private static List<Hero> myHero =new ArrayList<>();

    public Hero(String name,int age,String power,String weakness ) {
        name = name;
        age = age;
        power = power;
        weakness = weakness;
        myHero.add(this);
        Id = myHero.size();
    }

}
