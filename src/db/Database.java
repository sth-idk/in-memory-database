package db;
import db.exception.EntityNotFoundException;
import example.Document;
import example.Human;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Database implements Cloneable {
    private static ArrayList<Entity> entities = new ArrayList<Entity>();
    private static boolean toCheck = true;
    private static HashMap<Integer, Validator> validators = new HashMap<>();


    //with the clone() method
    private static void add(Entity e) throws CloneNotSupportedException{
        if(validators != null) {
            Validator validator = validators.get(e.getEntityCode());

            if (validator != null)
                validator.validate(e);
        }


            Entity entityCopy = e.clone();


        if(entityCopy instanceof Trackable) {
            Date now = new Date();
            ((Trackable) e).setCreationDate(now);
            ((Trackable) e).setLastModificationDate(now);
        }


            e.id = entities.size();
            entities.add(entityCopy);
    }
    public static void callAdd(Entity e) throws CloneNotSupportedException {
        Database.add(e);
    }


    private static Entity get(int id) throws CloneNotSupportedException {
        for(Entity entity : entities){
            if(entity.id == id) {
                toCheck = false;
                return entity.clone();
            }
        }
        if(toCheck){
            throw new EntityNotFoundException(id);
        }
        return null;
    }

    public static Entity callGet(int id) throws CloneNotSupportedException {
        return Database.get(id);
    }


    private static void delete(int id){
        for(Entity entity : entities){
            if(entity.id == id)
                entities.remove(entity);
            else
                throw new EntityNotFoundException(id);

        }
    }

    public static void callDelete(int id){
        Database.delete(id);
    }


    private static void update(Entity e) throws CloneNotSupportedException {

        if (validators != null) {
            Validator validator = validators.get(e.getEntityCode());

            if (validator != null)
                validator.validate(e);
        }

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                Entity entityCopy = e.clone();

                if (e instanceof Trackable) {
                    ((Trackable) e).setLastModificationDate(new Date());
                }

                entities.set(i, e.clone());
                toCheck = false;
                break;
            }

            if (toCheck)
                throw new EntityNotFoundException();
        }
    }

    public static void callUpdate(Entity e) throws CloneNotSupportedException {
        Database.update(e);
    }


    public static void registerValidator(int entityCode, Validator validator) {

        if (validators.containsKey(entityCode))
            throw new IllegalArgumentException("Validator for entityCode " + entityCode + " is already registered.");
        else {
            validators.put(entityCode, validator);
        }

    }




    //with the copy() method
    /*private static void add(Entity e){
        entities.add(e.copy());
        e.copy().id = entities.size();
    }
    public static void callAdd(Human e){
        Database.add(e);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Database copy = (Database) super.clone();
        copy.entities = (ArrayList<Entity>) this.entities.clone();
        return copy;
    }
    private static Entity get(int id){
        for(Entity entity : entities){
            if(entity.id == id) {
                toCheck = false;
                return entity.copy();
            }
        }
        if(toCheck){
            throw new EntityNotFoundException(id);
        }
        return null;
    }

    public static Entity callGet(int id){
        return Database.get(id);
    }


    private static void delete(int id){
        for(Entity entity : entities){
            if(entity.id == id)
                entities.remove(entity);
            else
                throw new EntityNotFoundException(id);

        }
    }

    public static void callDelete(int id){
        Database.delete(id);
    }


    private static void update(Entity e){
        for(Entity entity : entities){
            if(entity.id == e.id){
                int index = entities.indexOf(entity);
                entities.set(index , e.copy());
                toCheck = false;
            }
        }
        if(toCheck)
            throw new EntityNotFoundException();
    }

    public static void callUpdate(Entity e){
        Database.update(e);
    }
}*/
}


