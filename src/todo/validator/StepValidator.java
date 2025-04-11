package todo.validator;

import db.Database;
import db.Entity;
import db.Validator;
import db.exception.EntityNotFoundException;
import db.exception.InvalidEnitityException;
import todo.entity.Step;
import todo.entity.Task;

public class StepValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEnitityException {
        if (!(entity instanceof Step))
            throw new IllegalArgumentException();
        else {
            Step step = (Step) entity;
            if (((Step) entity).title == null) {
                throw new InvalidEnitityException("title cannot be null.");
            }
            try {
                Entity theRefTask = Database.callGet(step.taskRef);
            }catch (EntityNotFoundException e){
                throw new InvalidEnitityException("found no task with id : "+step.taskRef);
            }

        }
    }
}
