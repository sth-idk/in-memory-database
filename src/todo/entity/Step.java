package todo.entity;

import db.Entity;

public class Step extends Entity {
    String title;
    Status status;
    enum Status{
        NotStarted,
        Completed
    }
}
