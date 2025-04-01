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


}
