package dao;

import models.Hero;
import models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oSquaddao implements squaddao  {

    private final Sql2o sql2o;

    public sql2oSquaddao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Squad squad) {
        String sql = "INSERT INTO squad (name,max_size,cause) VALUES (:name,:max_size,:cause)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(squad)
                    .executeUpdate()
                    .getKey();
            squad.setMyId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Squad> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM squad")
                    .executeAndFetch(Squad.class);
        }
    }

    @Override
    public Squad findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM squad WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Squad.class);
        }
    }

    /*@Override
    public void update(int id, String newName){
        String sql = "UPDATE categories SET name = :name WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }*/

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from squad WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllSquad() {
        String sql = "DELETE from categories"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Hero> getAllHerobySquad(int squadId) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM hero WHERE squadId = :squadId")
                    .addParameter("squadId", squadId)
                    .executeAndFetch(Hero.class);
        }
    }

}