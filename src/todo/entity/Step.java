package todo.entity;

import db.Entity;

public class Step extends Entity {
    String title;
    enum Status{
        NotStarted,
        Completed
    }
}
