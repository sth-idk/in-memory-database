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


    //with the copy() method
    private static Entity add(Entity e) {
        if (validators != null) {
            Validator validator = validators.get(e.getEntityCode());
            if (validator != null)
                validator.validate(e);
        }


        e.id = entities.size() + 1;
        Entity copy = e.copy();

        if (copy instanceof Trackable) {
            Date now = new Date();
            ((Trackable) copy).setCreationDate(now);
            ((Trackable) copy).setLastModificationDate(now);
        }

        entities.add(copy);

        return copy;
    }


    public static Entity callAdd(Entity e) {
        return Database.add(e);
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



    private static void update(Entity e) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                Entity copy = e.copy();

                if (copy instanceof Trackable) {
                    ((Trackable) copy).setLastModificationDate(new Date());
                    ((Trackable) copy).setCreationDate(((Trackable) entities.get(i)).getCreationDate());
                }

                entities.set(i, copy);
                toCheck = false;
                break;
            }
        }
        if (toCheck)
            throw new EntityNotFoundException();
    }

    public static void callUpdate(Entity e){
        Database.update(e);
    }




    //with the clone() method
    /*private static void add(Entity e) throws CloneNotSupportedException{
        if (validators != null) {
            Validator validator = validators.get(e.getEntityCode());
            if (validator != null)
                validator.validate(e);
        }

        e.id = entities.size();

        Entity entityCopy = e.clone();

        if (entityCopy instanceof Trackable) {
            Date now = new Date();
            ((Trackable) entityCopy).setCreationDate(now);
            ((Trackable) entityCopy).setLastModificationDate(now);
        }

        entities.add(entityCopy);


    }


    public static Entity callAdd(Entity e) throws CloneNotSupportedException {
        Database.add(e);
        return Database.callGet(e.id);
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
        if(validators != null) {
            Validator validator = validators.get(e.getEntityCode());

            if (validator != null)
                validator.validate(e);
        }

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                Entity entityCopy = e.clone();

                if (entityCopy instanceof Trackable) {
                    ((Trackable) entityCopy).setLastModificationDate(new Date());
                }

                entities.set(i, entityCopy);
                toCheck = false;
                return;
            }
        }

        if (toCheck)
            throw new EntityNotFoundException();
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

    }*/
}
