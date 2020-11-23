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

    //get Id
    @Test
    public void getId_SquadObject_1() {
        Squad.clear();
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals(1, squad.getMyId());
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

    //testing squad with same id
    @Test
    public void sameId_SquadWithSameId_secondSquad() {
        Squad.clear();
        Squad firstsquad = new Squad("club",5,"passive-aggressive post-it notes");
        Squad secondsquad = new Squad("Geeks", 4, "computer literacy");
        assertEquals(Squad.find(secondsquad.getMyId()), secondsquad);
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
    public void clear_squadObject_0() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }


}