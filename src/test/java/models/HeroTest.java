package models;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {

    //Testing the Whole Class
    @Test
    public void HeroCorrectlyCreated_true() throws Exception {
        Hero hero = setUpNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroProperties_true() throws Exception {
        Hero hero = setUpNewHero();
        assertEquals("belyse", hero.getName());
        assertEquals("vision", hero.getWeakness());
        assertEquals("cooking", hero.getPower());
        assertEquals(20, hero.getAge());
        assertEquals(1, hero.getSquadId());
    }

    //Time created
    @Test
    public void HeroWithCurrentTimeToday() throws Exception{
        Hero hero = setUpNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), hero.getCreatedAt().getDayOfWeek());
    }

    //helper method
    public Hero setUpNewHero(){
        return new Hero("belyse", "vision", "cooking", 20, 1);
    }
}