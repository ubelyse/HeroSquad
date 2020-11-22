import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    //Instializing new Hero Object
    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true()
    {
        Hero hero = new Hero("belyse",20,"high","high");
        assertEquals(true, hero instanceof Hero);
    }
}