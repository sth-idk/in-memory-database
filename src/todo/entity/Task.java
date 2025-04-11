package todo.entity;

import db.Entity;
import db.Trackable;

public class Task extends Entity implements Trackable {
    String title;
    enum Status{
        NotStarted,
        InProgress,
        Completed
    }
}
