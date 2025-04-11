package todo.validator;

import db.Entity;
import db.Validator;
import db.exception.InvalidEnitityException;
import example.Human;
import todo.entity.Task;

public class TaskValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEnitityException {
        if (!(entity instanceof Task))
            throw new IllegalArgumentException();
        else {
            Task task = (Task) entity;
            if (((Task) entity).title == null) {
                throw new InvalidEnitityException("title cannot be null.");
            }
        }
    }
}
