package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    //Testing the whole Class
    @Test
    public void Squad_instantiatesCorrectly()  {
        Squad squad = new Squad("instrumental",10,"piano");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void Squad_getName_String() {
        Squad squad = new Squad("instrumental",10,"piano");
        assertEquals("instrumental",squad.getMyname());
    }

    @Test
    public void Squad_getSize_Int() {
        Squad squad = new Squad("instrumental",10,"piano");
        assertEquals(10,squad.getMysize());
    }

    @Test
    public void Squad_getCause_String() {
        Squad squad = new Squad("instrumental",10,"piano");
        assertEquals("piano",squad.getMycause());
    }

    @Test
    public void Squad_getInstances_true() {
        Squad squad = new Squad("instrumental",10,"piano");
        Squad anothersquad = new Squad("Choir",50,"gospel");
        assertTrue(Squad.getInstances().contains(squad));
        assertTrue(Squad.getInstances().contains(anothersquad));
    }

    @Test
    public void Squad_getSquadHero_Array() {
        Squad squad = new Squad("instrumental",10,"piano");
        Hero hero = new Hero("belyse",30,"flying","fire", 1);
        Hero anotherhero = new Hero("inema",25,"cook","low", 2);
        squad.setSquadHero(hero);
        assertEquals("belyse",squad.getSquadHero().get(0).getMyname());
    }

    @Test
    public void Squad_allSquadHero_Array() {
        Hero hero = new Hero("belyse",30,"flying","fire", 1);
        Squad squad = new Squad("instrumental",10,"piano");
        squad.clearAllSquadHero();
        squad.getSquadHero().add(hero);
        squad.getSquadHero().add(hero);
        assertEquals("belyse",squad.getSquadHero().get(0).getMyname());
    }

    @Test
    public void Hero_addsHeroToSquad_Hero(){
        Hero hero = new Hero("belyse",30,"flying","fire", 1);
        Squad squad = new Squad("instrumental",10,"piano");
        Squad anothersquad = new Squad("Choir",50,"gospel");
        anothersquad.clearAllSquadHero();
        anothersquad.getSquadHero().add(hero);
        anothersquad.getSquadHero().add(hero);
        assertEquals(2,anothersquad.getSquadHero().size());
    }
}