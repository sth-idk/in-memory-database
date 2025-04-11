package todo.entity;

import db.Entity;
import db.Trackable;
import java.util.Date;
import example.Document;

public class Task extends Entity implements Trackable {

    public String title;
    public String description;
    public Date dueDate;
    public Status status;
    private Date creationDate;
    private Date LastModificationDate;

    public enum Status{
        NotStarted,
        InProgress,
        Completed
    }

    @Override
    public int getEntityCode() {
        return 14;
    }

    @Override
    public Entity copy() {
        Task copy = new Task();
        copy.id = this.id;
        copy.title = this.title;
        copy.description = this.description;
        copy.dueDate = new Date(this.dueDate.getTime());
        copy.status = this.status;
        return copy;
    }

    @Override
    public void setCreationDate(Date date) {
        this.creationDate = new Date(date.getTime());
    }

    @Override
    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    @Override
    public void setLastModificationDate(Date date) {
        this.LastModificationDate = new Date (date.getTime());
    }

    @Override
    public Date getLastModificationDate() {
        return new Date(LastModificationDate.getTime());
    }


}
