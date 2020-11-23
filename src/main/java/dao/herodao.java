package dao;

import models.Hero;

import java.util.List;

public interface herodao {

    List<Hero> getAll();

    // CREATE
    void add(Hero hero);

    // READ
    Hero findById(int id);

    //DELETE
    void deleteById(int id);
    void clearAllHero();
}
