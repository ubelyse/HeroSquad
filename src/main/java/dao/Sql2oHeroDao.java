package dao;

import models.Hero;
import org.sql2o.*;

import java.util.List;

public class Sql2oHeroDao implements HeroDao {

    private final Sql2o sql2o;

    public Sql2oHeroDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Hero hero) {
        String sql = "INSERT INTO hero (name,age,power,weakness, squadId) VALUES (:name,:age,:power,:weakness,:squadId)"; //raw sql
        try(Connection con = sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(hero)
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            hero.setId(id); //update object to set id now from database

        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }

    @Override
    public List<Hero> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM hero") //raw sql
                    .executeAndFetch(Hero.class); //fetch a list
        }
    }

    @Override
    public Hero findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM hero WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Hero.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String newName,int newAge,String newPower,String newWeakness, int newSquadId){
        String sql = "UPDATE hero SET (name,age,power,weakness, squadId) = (:name,:age,:power,:weakness,:squadId) WHERE id=:id";   //raw sql
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("squadId", newSquadId)
                    .addParameter("age", newAge)
                    .addParameter("power", newPower)
                    .addParameter("weakness", newWeakness)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from hero WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllTasks() {
        String sql = "DELETE from hero";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }




}
