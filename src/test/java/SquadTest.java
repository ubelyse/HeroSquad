import models.Hero;
import models.Squad;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    //Instializing new models.Squad Object
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

    //hero exist
    @Test
    public void heroExists_HeroExistsinSquads_true() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        Hero hero = new Hero("belyse",20,"high","high");
        squad.addHero(hero);
        assertTrue(squad.heroexist(hero));


    }

    //return all squad
    @Test
    public void all_returnsAllSquadObject_true() {
        Squad firstsquad = new Squad("club",5,"passive-aggressive post-it notes");
        Squad secondsquad = new Squad("Geeks", 4, "computer literacy");
        assertEquals(true, Squad.all().contains(firstsquad));
        assertEquals(true, Squad.all().contains(secondsquad));
    }

    //empty list
    @Test
    public void getHeroes_initiallyReturnsEmptyList_ArrayList() {
        Squad.clear();
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        assertEquals(0, squad.getHero().size());
    }

    //clear
    @Test
    public void clear_squadObject_0() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }

    //add new hero
    @Test
    public void addHero_addNewHero_true() {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        Hero hero = new Hero("belyse",20,"high","high");
        squad.addHero(hero);
        assertTrue(squad.getHero().contains(hero));
    }

}