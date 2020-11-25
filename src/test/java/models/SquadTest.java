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
        assertEquals("keepers",mySquad.getMyname());
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
        assertTrue(Squad.getInstances().contains(mySquad));
        assertTrue(Squad.getInstances().contains(secondSquad));
    }
    @Test
    public void  finding_The_Id(){
        Squad.clearAllSquads();
        Squad mySquad = new Squad("keepers",5,"protect");
        assertEquals(1,mySquad.findBySquadId(1));
    }
    @Test
    public void clear_All(){
        Squad.clearAllSquads();
    }
}