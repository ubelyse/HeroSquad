import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String myName;
    private int mySize;
    private String mCause;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int myId;
    private List<Hero> myHero;

    public Squad(String name,int size, String cause) {
        this.mCause=cause;
        this.myName=name;
        this.mySize=size;
        instances.add(this);
        myId=instances.size();
        myHero= new ArrayList<Hero>();
    }
}
