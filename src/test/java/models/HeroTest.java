package models;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = setUpNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithProperties_true() throws Exception {
        Hero hero = setUpNewHero();
        assertEquals("super man", hero.getName());
        assertEquals("kryptonite", hero.getWeakness());
        assertEquals("x-ray vision", hero.getPower());
        assertEquals(30, hero.getAge());
        assertEquals(1, hero.getSquadId());
    }

    @Test
    public void getCreatedAtInstantiatesWithCurrentTimeToday() throws Exception{
        Hero hero = setUpNewHero();
        assertEquals(LocalDateTime.now().getDayOfWeek(), hero.getCreatedAt().getDayOfWeek());
    }

    //helper method
    public Hero setUpNewHero(){
        return new Hero("super man", "kryptonite", "x-ray vision", 30, 1);
    }

}