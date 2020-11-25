package dao;

import models.Hero;
import models.Squad;
import org.sql2o.*;
import java.util.List;

public class Sql2oHeroDao implements HeroDao {  //implementing our interface
    private final Sql2o sql2o;

    public Sql2oHeroDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Hero hero) {
        String sql = "INSERT INTO heroes (name, weakness, specialPower, age, squadId) VALUES (:name, :weakness, :specialPower, :age, :squadId)";    //raw sql
        try (Connection con = sql2o.open()) {    //opening a connection
            int id = (int) con.createQuery(sql, true)   //make new variable
                    .bind(hero)
                    .executeUpdate()    //run it all
                    .getKey();   //int id is now the row number (row "key") of db
            hero.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);    //oops we got an error
        }
    }

    @Override
    public int getHeroesInSquad(int searchSquadId) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM heroes WHERE squadId = :searchSquadId";
            return con.createQuery(sql)
                    .addParameter("searchSquadId", searchSquadId)
                    .executeAndFetch(Hero.class).size();
        }
    }

    @Override
    public List<Hero> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM heroes") //raw sql
                    .executeAndFetch(Hero.class);   //fetch a list
        }
    }

    @Override
    public Hero findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM heroes WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Hero.class);  //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newName, String newWeakness, String newSpecialPower, int newAge, int newSquadId) {
        String sql = "UPDATE heroes SET (name, weakness, specialPower, age, squadId) = (:name, :weakness, :specialPower, :age, :squadId) WHERE id =:id";    //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("weakness", newWeakness)
                    .addParameter("specialPower", newSpecialPower)
                    .addParameter("age", newAge)
                    .addParameter("squadId", newSquadId)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id){
        String sql = "DELETE from heroes WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllHeroes(){
        String sql = "DELETE from heroes";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }



}
