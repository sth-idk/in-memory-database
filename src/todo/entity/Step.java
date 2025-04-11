package todo.entity;

import db.Entity;

public class Step extends Entity {
    String title;
    Status status;
    int taskRef;

    @Override
    public int getEntityCode() {
        return 0;
    }

    @Override
    public Entity copy() {
        return null;
    }

    enum Status{
        NotStarted,
        Completed
    }
}
