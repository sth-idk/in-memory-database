package todo.entity;

import db.Entity;

public class Step extends Entity {
    public String title;
    public Status status;
    public int taskRef;

    @Override
    public int getEntityCode() {
        return 14;
    }

    @Override
    public Entity copy() {
        Step copy = new Step();
        copy.id = this.id;
        copy.title = this.title;
        copy.status = this.status;
        copy.taskRef = this.taskRef;
        return copy;
    }

    public enum Status{
        NotStarted,
        Completed
    }
}
