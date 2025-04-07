package db;
import example.Human;

import java.util.ArrayList;

public class Database implements Cloneable {
    private static ArrayList<Entity> entities = new ArrayList<Entity>();
    private static boolean toCheck = true;


    private static void add(Entity e) throws CloneNotSupportedException{
        try {
            Entity entityCopy = e.clone();
            e.id = entities.size();
            entities.add(entityCopy);
        }catch(CloneNotSupportedException er){
            throw new AssertionError();
        }
    }
    public static void callAdd(Human e) throws CloneNotSupportedException {
        Database.add(e);
    }


    private static Entity get(int id) throws CloneNotSupportedException {
        for(Entity entity : entities){
            if(entity.id == id) {
                toCheck = false;
                try {
                    return entity.clone();
                }catch(CloneNotSupportedException e){
                    throw new AssertionError();
                }
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
            for (int i=0 ; i<entities.size() ; i++) {
                if (entities.get(i).id == e.id) {
                    entities.set(i, e.clone());
                    toCheck = false;
                    break;
                }
            }
            if (toCheck)
                throw new EntityNotFoundException();
    }

    public static void callUpdate(Entity e) throws CloneNotSupportedException {
        Database.update(e);
    }
}
