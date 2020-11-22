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

    //get the name expected
    @Test
    public void getName_HeroObject_String() {
        Hero hero = new Hero("belyse",20,"high","high");
        String mname = "Vick";
        assertEquals(mname, hero.getName());
    }

}