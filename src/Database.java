import db.Entity;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Entity> entities = new ArrayList<Entity>();

    private static void add(Entity e){
        entities.add(e);
        e.id = entities.size();
    }
    public static void callAdd(Entity e){
        Database.add(e);
    }

    private static Entity get(int id){
        for(Entity entity : entities){
            if(entity.id == id)
                return entity;
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
        }
    }
    public static void callDelete(int id){
        Database.delete(id);
    }

    private static void update(Entity e){
        boolean toCheck = true;
        for(Entity entity : entities){
            if(entity.id == e.id){
                int index = entities.indexOf(entity);
                entities.set(index , e);
                toCheck = false;
            }
        }
    }
    public static void callUpdate(Entity e){
        Database.update(e);
    }


}
