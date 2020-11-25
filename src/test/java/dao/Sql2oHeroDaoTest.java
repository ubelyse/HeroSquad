package dao;

import models.Squad;
import models.Hero;
import org.junit.*;
import org.sql2o.*;

import static junit.framework.TestCase.assertEquals;
import static  junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Sql2oHeroDaoTest {

    private Sql2oHeroDao heroDao;
    private  Connection conn;

    @Before
    public  void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:herosquad_test;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
       conn.close();
    }


    @Test
    public void addingHeroSetsId() throws Exception {
        Hero hero = setUpNewHero();
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void FindExistingHeroesbyId()throws Exception{
        Hero hero = setUpNewHero();
        heroDao.add(hero);  //add to dao to save it
        Hero foundHero = heroDao.findById(hero.getId());    //retrieve
        assertEquals(hero, foundHero);
    }

    @Test
    public void HeroesReturned()throws Exception{
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        assertEquals(1, heroDao.getAll().size());
    }

    @Test
    public void noHeroReturnsEmptyList()throws Exception{
        assertEquals(0, heroDao.getAll().size());
    }

    @Test
    public void updateChangesHeroContent()throws Exception{
        String initialName = "super man";
        Hero hero = setUpNewHero();
        heroDao.add(hero);

        heroDao.update(hero.getId(), "Belyse", "vision", "cooking", 20, 2);
        Hero updatedHero = heroDao.findById(hero.getId());
        assertNotEquals(initialName, updatedHero.getName());
    }

    @Test
    public void deleteByIdDeletesCorrectHero()throws Exception{
        Hero hero = setUpNewHero();
        heroDao.add(hero);
        heroDao.deleteById(hero.getId());
        assertEquals(0, heroDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllHeroes() throws Exception {
        Hero hero = setUpNewHero();
        Hero anotherHero = new Hero("inema", "busy", "money", 20, 2);
        heroDao.add(hero);
        heroDao.add(anotherHero);
        int heroDaoSize = heroDao.getAll().size();
        heroDao.clearAllHeroes();
        assertTrue(heroDaoSize > 0 && heroDaoSize >heroDao.getAll().size());
    }

    @Test
    public void squadIdIsReturnedCorrectly()throws Exception{
        Hero hero = setUpNewHero();
        int originalSquadId = hero.getSquadId();
        heroDao.add(hero);
        assertEquals(originalSquadId, heroDao.findById(hero.getId()).getSquadId());
    }

    @Test
    public void HeroeswithSameSquadIdIsReturnedCorrectly() throws Exception {
        Hero hero = setUpNewHero();
        Hero hero2 = setUpNewHero();
        Hero hero3 = setUpNewHero();
        Hero hero4 = new Hero("Bebe", "poverty", "cash", 25, 2);
        heroDao.add(hero);
        heroDao.add(hero2);
        heroDao.add(hero3);
        heroDao.add(hero4);
        int valueToSearchSquadIdUsing = heroDao.findById(hero.getId()).getSquadId();
        assertEquals(4, heroDao.getAll().size());
        assertEquals(3, heroDao.getHeroesInSquad(valueToSearchSquadIdUsing));
    }



    //helper method for tests
    public Hero setUpNewHero(){return new Hero("Belyse", "vision", "cook", 30, 1);}
}