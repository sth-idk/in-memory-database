package db;
import example.Human;

import java.util.ArrayList;

public class Database implements Cloneable {
    private static ArrayList<Entity> entities = new ArrayList<Entity>();
    private static boolean toCheck = true;


    private static void add(Entity e){
        entities.add(e);
        e.id = entities.size();
    }
    public static void callAdd(Human e){
        Database.add(e);
    }


    private static Entity get(int id){
        for(Entity entity : entities){
            if(entity.id == id) {
                toCheck = false;
                return entity;
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


    private static void update(Entity e) throws CloneNotSupportedException {
            for (int i=0 ; i<entities.size() ; i++) {
                if (entities.get(i).id == e.id) {
                    entities.set(i, e);
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
