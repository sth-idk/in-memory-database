package todo.entity;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Task extends Entity implements Trackable {

    public String title;
    String description;
    Date dueDate;
    Status status;

    enum Status{
        NotStarted,
        InProgress,
        Completed
    }

    @Override
    public int getEntityCode() {
        return 0;
    }

    @Override
    public Entity copy() {
        return null;
    }

    @Override
    public void setCreationDate(Date date) {

    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public void setLastModificationDate(Date date) {

    }

    @Override
    public Date getLastModificationDate() {
        return null;
    }


}
