package example;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Document extends Entity implements Trackable {
    public String content;

    public Document(String content){
        this.content = content;
    }


}
