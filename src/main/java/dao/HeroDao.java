package dao;

import models.Hero;

import java.util.List;

public interface HeroDao {


    // LIST
    List<Hero> getAll();


    // CREATE

    // READ
    Hero findById(int id);

    void add(Hero hero);

    // READ
    /*static Hero findById(int id);*/


    //UPDATE
    void update(int id, String name,int age,String power,String weakness, int categoryId);

    //DELETE
    void deleteById(int id);
    void clearAllTasks();

}
