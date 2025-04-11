package todo.entity;

import db.Entity;
import db.Trackable;

import java.util.Date;

public class Task extends Entity implements Trackable {
    String title;
    String description;
    Date dueDate;
    Status status;
    enum Status{
        NotStarted,
        InProgress,
        Completed
    }
}
