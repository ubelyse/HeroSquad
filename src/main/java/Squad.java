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

    public String getMyName() {
        return myName;
    }

    public int getMyId() {
        return myId;
    }

    public int getMySize() {
        return mySize;
    }

    public String getmCause() {
        return mCause;
    }

    public static Squad find(int id) {
        return instances.get(id - 1);
    }

    public static List<Squad> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }
}
