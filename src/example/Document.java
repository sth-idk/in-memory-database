package example;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Document extends Entity implements Trackable {
    private Date creationDate;
    private Date lastModificationDate;
    public String content;

    public Document(String content){
        this.content = content;
    }

    @Override
    public int getEntityCode() {
        return 0;
    }

    @Override
    public void setCreationDate(Date date) {
        this.creationDate = creationDate;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setLastModificationDate(Date date) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public Date getLastModificationDate() {
        return lastModificationDate;
    }


}
