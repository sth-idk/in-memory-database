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
        this.creationDate = date;
    }

    @Override
    public Date getCreationDate() {
        return this.creationDate;
    }

    @Override
    public void setLastModificationDate(Date date) {
        this.lastModificationDate = date;
    }

    @Override
    public Date getLastModificationDate() {
        return this.lastModificationDate;
    }

    @Override
    public Document copy() {
        Document documentCopy = new Document(this.content);
        documentCopy.id = this.id;

        if (this.creationDate != null)
            documentCopy.creationDate = new Date(this.creationDate.getTime());

        if (this.lastModificationDate != null)
            documentCopy.lastModificationDate = new Date(this.lastModificationDate.getTime());

        return documentCopy;
    }
}
