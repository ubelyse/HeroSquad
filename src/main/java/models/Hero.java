package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Hero {

    private String name;
    private String weakness;
    private int squadId;
    private String power;
    private LocalDateTime createdAt;
    private int age;
    private int id;

    public Hero(String name, String weakness, String power, int age, int squadId){
        this.name = name;
        this.weakness = weakness;
        this.power = power;
        this.age = age;
        this.squadId = squadId;
        this.createdAt = LocalDateTime.now();
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public void setWeakness(String weakness){
        this.weakness = weakness;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setSpecialPower(String specialPower){
        this.power = specialPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getPower(){
        return power;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public  String getWeakness(){
        return weakness;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;

        Hero hero = (Hero) o;

        if (squadId != hero.squadId) return false;
        if (age != hero.age) return false;
        if (id != hero.id) return false;
        if (name != null ? !name.equals(hero.name) : hero.name != null) return false;
        if (weakness != null ? !weakness.equals(hero.weakness) : hero.weakness != null) return false;
        if (power != null ? !power.equals(hero.power) : hero.power != null) return false;
        return createdAt != null ? createdAt.equals(hero.createdAt) : hero.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (weakness != null ? weakness.hashCode() : 0);
        result = 31 * result + squadId;
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + id;
        return result;
    }
}
