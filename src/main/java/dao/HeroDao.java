package dao;

import models.Hero;

import java.util.List;
public interface HeroDao {


    //LIST
    List<Hero> getAll();

    //LIST
    int getHeroesInSquad(int searchSquadId);

    //CREATE
    void add(Hero hero);

    //READ
    Hero findById(int id);

    //UPDATE
    void update(int id, String name, String weakness, String specialPower, int age, int squadId);

    //DELETE
    void deleteById(int id);
    void clearAllHeroes();

}
