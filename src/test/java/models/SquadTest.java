package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    //Testing the whole Class
    @Test
    public void Instance(){
        Squad mySquad = new Squad("keepers",5,"protect");
        assertEquals(true,mySquad instanceof Squad);
    }
    @Test
    public void correct_size(){
        Squad mySquad=new Squad("keepers",5,"protect");
        assertEquals(5,mySquad .getMysize());
    }
    @Test
    public void  squad_Is_Correct(){
        Squad mySquad = new Squad("keepers",5,"protect");
        assertEquals("keepers",mySquad.getMysquadname());
    }
    @Test
    public void mission_Is_Correct(){
        Squad mySquad=new Squad("keepers",5,"protect");
        assertEquals("protect",mySquad.getMycause());
    }
    @Test
    public void get_All_List(){
        Squad mySquad = new Squad("keepers",5,"protect");
        Squad secondSquad= new Squad("keepers",5,"protect");
        assertTrue(Squad.getAll().contains(mySquad));
        assertTrue(Squad.getAll().contains(secondSquad));
    }
    @Test
    public void  finding_The_Id(){
        Squad.clear();
        Squad mySquad = new Squad("keepers",5,"protect");
        assertEquals(1,mySquad.findid());
    }
    @Test
    public void clear_All(){
        Squad.clear();
    }
}