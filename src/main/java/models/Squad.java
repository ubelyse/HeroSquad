package models;


import java.util.Objects;

public class Squad {
    private String squadName;
    private String cause;
    private int id;
    private int max_size;

    public Squad(String squadName, String cause, int max_size){
        this.squadName = squadName;
        this.cause = cause;
        this.max_size = max_size;
    }

    public String getSquadName(){
        return squadName;
    }

    public String getCause(){
        return cause;
    }

    public int getMax_size() {return max_size;}

    public int getId(){
        return id;
    }

    public void setSquadName(String squadName){
        this.squadName = squadName;
    }

    public void setMax_size(int max_size){
        this.max_size = max_size;
    }

    public void setCause(String cause){
        this.cause = cause;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Squad squad = (Squad) o;

        if (id != squad.id) return false;
        if (max_size != squad.max_size) return false;
        if (!Objects.equals(squadName, squad.squadName)) return false;
        return Objects.equals(cause, squad.cause);
    }

    @Override
    public int hashCode() {
        int result = squadName != null ? squadName.hashCode() : 0;
        result = 31 * result + (cause != null ? cause.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + max_size;
        return result;
    }

}
