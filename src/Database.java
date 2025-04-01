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



}
