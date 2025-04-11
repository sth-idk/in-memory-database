import db.Database;
import example.Document;
import example.Human;
import db.exception.InvalidEnitityException;
import example.HumanValidator;

public class Main {
    public static void main(String[] args) throws InvalidEnitityException, CloneNotSupportedException {

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
    }
}

