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
    public void getSize_squadInstantiatesWithSize_int() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals(5, squad.getMySize());
    }
}