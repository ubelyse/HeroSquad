package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {


    //Testing the whole Class
    @Test
    public void Hero_instantiatesCorrectly()  {
        Hero hero = new Hero("belyse",30,"flying","fire");
        assertEquals(true, hero instanceof Hero);
    }

    //Testing the Name
    @Test
    public void Hero_getName_String() {
        Hero hero = new Hero("belyse",30,"flying","fire");
        assertEquals("belyse",hero.getMyname());
    }

    //Testing the Age
    @Test
    public void Hero_getAge_Int() {
        Hero hero = new Hero("belyse",30,"flying","fire");
        assertEquals(30,hero.getMyage());
    }

    //Testing Power
    @Test
    public void Hero_getPower_String() {
        Hero hero = new Hero("belyse",30,"flying","fire");
        assertEquals("flying",hero.getMypower());
    }

    //Testing Weakness
    @Test
    public void Hero_getWeakness_String() {
        Hero hero = new Hero("belyse",30,"flying","fire");
        assertEquals("fire",hero.getMyweakness());
    }

    //Testing all instances
    @Test
    public void Hero_getAllHeroes_true() {
        Hero hero = new Hero("belyse",30,"flying","fire");
        Hero anotherhero = new Hero("inema",25,"cook","low");
        assertTrue(Hero.getAllHeroes().contains(hero));
        assertTrue(Hero.getAllHeroes().contains(anotherhero));
    }

    //getting Id
    @Test
    public void Hero_getId_Int() {
        Hero.clearAllHeroes();
        Hero hero = new Hero("belyse",30,"flying","fire");
        Hero anotherhero = new Hero("inema",25,"cook","low");
        Hero thirdhero = new Hero("bebe",20,"buy","water");
        assertEquals(3,thirdhero.getId());
    }

    //Testing getting things by Id
    @Test
    public void Hero_findById_id() {
        Hero.clearAllHeroes();
        Hero hero = new Hero("belyse",30,"flying","fire");
        Hero anotherhero = new Hero("inema",25,"cook","low");
        assertEquals(2,Hero.findById(anotherhero.getId()).getId());
    }
}