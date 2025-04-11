
import db.Database;
import example.Document;
import example.Human;
import db.exception.InvalidEnitityException;
import example.HumanValidator;


public class Main {

    public static void main(String[] args) throws InvalidEnitityException, CloneNotSupportedException {
      
      
        //test code of fourth step
        Document doc = new Document("Eid Eid Eid");
        doc = (Document) Database.callAdd(doc);

        System.out.println("Document added");
        System.out.println("id: " + doc.id);
        System.out.println("content: " + doc.content);
        System.out.println("creation date: " + doc.getCreationDate());
        System.out.println("last modification date: " + doc.getLastModificationDate());
        System.out.println();

        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }


        doc.content = "This is the new content";

        Database.callUpdate(doc);
        Document updated = (Document) Database.callGet(doc.id);

        System.out.println("Document updated");
        System.out.println("id: " + updated.id);
        System.out.println("content: " + updated.content);
        System.out.println("creation date: " + updated.getCreationDate());
        System.out.println("last modification date: " + updated.getLastModificationDate());
      
      
      
//test code of the third step
        /*Database.registerValidator(Human.HUMAN_ENTITY_CODE, new HumanValidator());

        Human ali = new Human("Ali", -10);
        Database.callAdd(ali);*/

    
      
      
/////////////////////////////
//test code of the second step
/*public static void main(String[] args) throws CloneNotSupportedException {
    Human ali = new Human("Ali");
    Database.callAdd(ali);

    ali.name = "Ali Hosseini";

    Human aliFromTheDatabase = (Human) Database.callGet(ali.id);

    System.out.println("ali's name in the database: " + aliFromTheDatabase.name);*/
      
      
/////////////////////////////
//test code of the first step
/*public class Main {
    public static void main(String[] args) {
        Human[] humans = {
                new Human("Gholi"),
                new Human("Jamshid"),
                new Human("Akbar"),
        };

        System.out.println("#### Test add method ####");

        for (Human h : humans) {
            System.out.println("Adding " + h.name + " to the database.");
            Database.callAdd(h);
        }

        for (Human h : humans) {
            System.out.println("Id of \"" + h.name + "\" is " + h.id + ".");
        }

        System.out.println();
        System.out.println("#### Test get method ####");

        int gholiId = humans[0].id;
        Human gholi = (Human) Database.callGet(gholiId);

        System.out.println("successfully got " + gholi.name + " from the database.");

        System.out.println();
        System.out.println("#### Test update method ####");

        gholi.name = "Gholi Mohammadi";
        Database.callUpdate(gholi);

        Human gholiAgain = (Human) Database.callGet(gholiId);
        System.out.println("Updated name: \"" + gholiAgain.name + "\".");

        System.out.println();
        System.out.println("#### Test delete method ####");


        int akbarId = humans[2].id;
        Database.callDelete(akbarId);

        try {
            Human akbar = (Human) Database.callGet(akbarId);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }*/
    }
}

