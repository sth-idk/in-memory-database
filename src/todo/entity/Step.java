package todo.entity;

import db.Entity;

public class Step extends Entity {
    String title;
    Status status;
    int taskRef;
    enum Status{
        NotStarted,
        Completed
    }
}
