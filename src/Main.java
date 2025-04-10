import db.Database;
import example.Human;
import db.exception.InvalidEnitityException;
import example.HumanValidator;

public class Main {
    public static void main(String[] args) throws InvalidEnitityException, CloneNotSupportedException {
        Database.registerValidator(Human.HUMAN_ENTITY_CODE, new HumanValidator());

        Human ali = new Human("Ali", -10);
        Database.callAdd(ali);
    }
}