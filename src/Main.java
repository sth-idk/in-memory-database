import db.Database;
import db.Entity;
import db.EntityNotFoundException;
import example.Human;

public class Main {
    public static void main(String[] args) {

                Human ali = new Human("Ali");
                Database.callAdd(ali);

                ali.name = "Ali Hosseini";

                Human aliFromTheDatabase = (Human) Database.callGet(ali.id);

                System.out.println("ali's name in the database: " + aliFromTheDatabase.name);
    }
}