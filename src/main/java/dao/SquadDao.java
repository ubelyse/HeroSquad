package dao;

import models.Squad;
import models.Hero;
import java.util.List;

public interface SquadDao {

    //LIST
    List<Squad> getAll();

    //CREATE
    void add(Squad squad);

    //READ
    Squad findById(int id);
    List<Hero> getAllHeroesBySquad(int squadId);

    //UPDATE
    void update(int id, String squadName, String cause, int max_size);

    //DELETE
    void deleteById(int id);
    void clearAllSquads();
}
