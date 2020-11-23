import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    //Instializing new Squad Object
    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true()
    {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals(true, squad instanceof Hero);
    }

}