package dao;

import models.Hero;
import models.Squad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class sql2oSquaddaoTest {

    private sql2oSquaddao squadDao;
    private sql2oHerodao heroDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        squadDao = new sql2oSquaddao(sql2o);
        heroDao = new sql2oHerodao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingSquadSetsId() throws Exception {
        Squad squad = setupNewSquad();
        int originalSquadId = squad.getMyId();
        squadDao.add(squad);
        assertNotEquals(originalSquadId, squad.getMyId());
    }

    @Test
    public void existingSquadCanBeFoundById() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        Squad foundSquad = squadDao.findById(squad.getMyId());
        assertEquals(squad, foundSquad);
    }

    @Test
    public void addedSquadAreReturnedFromGetAll() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        assertEquals(1, squadDao.getAll().size());
    }

    @Test
    public void noSquadReturnsEmptyList() throws Exception {
        assertEquals(0, squadDao.getAll().size());
    }

   /* @Test
    public void updateChangesCategoryContent() throws Exception {
        Squad squad = new Squad("club",5,"passive-aggressive post-it notes");
        squadDao.add(squad);
        squadDao.update(squad.getId(),"");
        Squad updatedCategory = squadDao.findById(squad.getId());
        assertNotEquals(squad, updatedCategory.getName());
    }*/

    @Test
    public void deleteByIdDeletesCorrectCategory() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        squadDao.deleteById(squad.getMyId());
        assertEquals(0, squadDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllSquad() throws Exception {
        Squad squad = setupNewSquad();
        Squad othersquad = new Squad("club",5,"passive-aggressive post-it notes");
        squadDao.add(squad);
        squadDao.add(othersquad);
        int daoSize = squadDao.getAll().size();
        squadDao.clearAllSquad();
        assertTrue(daoSize > 0 && daoSize > squadDao.getAll().size());
    }

    @Test
    public void getAllTasksByCategoryReturnsTasksCorrectly() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        int categoryId = squad.getMyId();
        Hero newHero = new Hero("belyse",20,"high","high", squadId);
        Hero otherHero = new Hero("inema",21,"high","high", squadId);
        Hero thirdHero = new Hero("bebe",22,"high","high", squadId);
        heroDao.add(newHero);
        heroDao.add(otherHero); //we are not adding task 3 so we can test things precisely.
        assertEquals(2, squadDao.getAllHerobySquad(squadId).size());
        assertTrue(squadDao.getAllHerobySquad(squadId).contains(newHero));
        assertTrue(squadDao.getAllHerobySquad(squadId).contains(otherHero));
        assertFalse(squadDao.getAllHerobySquad(squadId).contains(thirdHero)); //things are accurate!
    }

    // helper method
    public Squad setupNewSquad(){
        return new Squad("club",5,"passive-aggressive post-it notes");
    }
}