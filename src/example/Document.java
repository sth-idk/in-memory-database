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
        this.creationDate = new Date(date.getTime());
    }

    @Override
    public Date getCreationDate() {
        return new Date(this.creationDate.getTime());
    }

    @Override
    public void setLastModificationDate(Date date) {
        this.lastModificationDate = new Date(date.getTime());
    }

    @Override
    public Date getLastModificationDate() {
        return new Date(this.lastModificationDate.getTime());
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
