package dao;

import models.Squad;
import models.Hero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Sql2oSquadDaoTest {

    private  Sql2oSquadDao squadDao;  //static so that they can manipulate whole class
    private  Sql2oHeroDao heroDao;
    private  Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        squadDao = new Sql2oSquadDao(sql2o);
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After                                              //run after every test
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingSquadSetsId()throws Exception{
        Squad squad = setupNewSquad();
        int originalSquadId = squad.getId();
        squadDao.add(squad);
        assertNotEquals(originalSquadId, squad.getId());
    }

    @Test
    public void existingSquadCanBeFoundById() throws Exception{
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        Squad foundSquad = squadDao.findById(squad.getId());
        assertEquals(squad, foundSquad);
    }

    @Test
    public void addedSquadsAreReturnedFromGetAll()throws Exception{
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        assertEquals(1, squadDao.getAll().size());
    }

    @Test
    public void noSquadReturnsEmptyList()throws Exception{
        assertEquals(0, squadDao.getAll().size());
    }

    @Test
    public void updateChangesSquadContent()throws Exception{
        String initialSquadName = "Belyse";
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        squadDao.update(squad.getId(), "Inema", "TP", 3);
        Squad updatedSquad = squadDao.findById(squad.getId());
        assertNotEquals(initialSquadName, updatedSquad.getSquadName());
    }

    @Test
    public void deleteByIdDeletesCorrectSquad()throws Exception{
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        squadDao.deleteById(squad.getId());
        assertEquals(0, squadDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllSquads()throws Exception{
        Squad squad = setupNewSquad();
        Squad anotherSquad = new Squad("Belyse", "TP", 5);
        squadDao.add(squad);
        squadDao.add(anotherSquad);
        int daoSize = squadDao.getAll().size();
        squadDao.clearAllSquads();
        assertTrue(daoSize > 0 && daoSize > squadDao.getAll().size());
    }

    @Test
    public void getAllHeroesBySquadReturnsAllHeroesCorrectly()throws Exception{
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        int squadId = squad.getId();
        Hero newHero = new Hero("blai", "none", "cash", 25, squadId);
        Hero newHero1 = new Hero("bel", "bon", "mo", 24, squadId);
        Hero newHero2 = new Hero("pri", "bi", "fa", 30, squadId);
        heroDao.add(newHero);
        heroDao.add(newHero1);
        assertEquals(2, squadDao.getAllHeroesBySquad(squadId).size());
        assertTrue(squadDao.getAllHeroesBySquad(squadId).contains(newHero));
        assertTrue(squadDao.getAllHeroesBySquad(squadId).contains(newHero1));
        assertFalse(squadDao.getAllHeroesBySquad(squadId).contains(newHero2));     //validation
    }

    //helper method
    public Squad setupNewSquad(){
        return new Squad("Belyse", "TP", 5);
    }
}