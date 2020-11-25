package models;



import java.util.ArrayList;




public class Squad {

    private String mysquadname;
    private int mysize;
    private String mycause;
    private int sqid;
    private static ArrayList<Squad> squads =new ArrayList<>();

    public Squad(String mysquadname, int mysize, String mycause) {
        this.mysquadname = mysquadname;
        this.mysize = mysize;
        this.mycause = mycause;

        squads.add(this);
        this.sqid = squads.size();
    }

    public int getMysize(){
        return mysize;
    }
    public String getMysquadname(){
        return mysquadname;
    }
    public String getMycause(){
        return mycause;
    }
    public static ArrayList<Squad>getAll(){
        return squads;
    }
    public static void clear() {
        squads.clear();
    }
    public int findid(){
        return sqid;
    }

}
