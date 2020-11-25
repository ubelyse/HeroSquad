import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Hero;
import models.Squad;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        //get: show all
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllHeroes(); //change
            model.put("heros", hero);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero_form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero_form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad_form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad_form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllHeroes();
            model.put("heroes",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getAllHeroes();
            model.put("heroes",members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadHero());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer size = Integer.parseInt(req.queryParams("size"));
            String cause = req.queryParams("cause");
            Squad newSquad = new Squad(squadName,size,cause);
            req.session().attribute("item",squadName);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.parseInt(req.queryParams("age"));
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness);
            req.session().attribute("item",name);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/member/:squadId",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            req.session().attribute("selectedSquad",req.params("squadId"));
            model.put("selectedSquad", req.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());

        get("/squad/new/:id",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(req.params(":id"));
            Hero newMember = Hero.findById(id);
            Squad newSquad = Squad.findBySquadId(1);
            newSquad.setSquadHero(newMember);
            model.put("item", newMember.getMyname());
            model.put("newHero",newSquad.getMyname());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}