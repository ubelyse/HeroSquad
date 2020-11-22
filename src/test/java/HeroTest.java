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
        String name = "belyse";
        assertEquals(name, hero.getName());
    }

    //get expected output of the age
    @Test
    public void getAge_HeroObject_String() {
        Hero hero = new Hero("belyse",20,"high","high");
        int mage = 20;
        assertEquals(mage, hero.getAge());
    }

    //get expected weakness
    @Test
    public void getWeakness_HeroObject_String() {
        Hero hero = new Hero("belyse",20,"high","high");
        String mweakness = "high";
        assertEquals(mweakness, hero.getWeakness());
    }

    //get expected power
    @Test
    public void getPower_HeroObject_String() {
        Hero hero = new Hero("belyse",20,"high","high");
        String mpower = "high";
        assertEquals(mpower, hero.getPower());
    }
}