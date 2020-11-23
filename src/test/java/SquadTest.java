import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    //Instializing new Squad Object
    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true()
    {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals(true, squad instanceof Squad);
    }

    //get the name expected
    @Test
    public void getName_SquadObject_String() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals("club", squad.getMyName());
    }

    //get the size
    @Test
    public void getSize_SquadObject_int() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals(5, squad.getMySize());
    }

    //get cause
    @Test
    public void getCause_SquadObject_String() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals("passive-aggressive post-it notes", squad.getmCause());
    }

    //return all squad
    @Test
    public void all_returnsAllSquadObject_true() {
        Squad firstsquad = new Squad("club",5,"passive-aggressive post-it notes");
        Squad secondsquad = new Squad("Geeks", 4, "computer literacy");
        assertEquals(true, Squad.all().contains(firstsquad));
        assertEquals(true, Squad.all().contains(secondsquad));
    }

    //clear
    @Test
    public void clear_emptiesAllSquadsFromList_0() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }
}