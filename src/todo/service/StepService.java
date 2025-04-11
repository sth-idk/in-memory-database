package todo.service;

import db.Database;
import db.Entity;
import todo.entity.Step;

public class StepService {

    public static void saveStep(int taskRef, String title) {
        Step step = new Step();
        step.title = title;
        step.status = Step.Status.NotStarted;
        step.taskRef = taskRef;

        Entity added = Database.callAdd(step);
    }

    public static Step getStep(int id) {
        Entity entity = Database.callGet(id);
        return (Step) entity;
    }

    public static void updateStep(Step updatedStep) {
        Database.callUpdate(updatedStep);
    }

    public static void deleteStep(int id) {
        Database.callDelete(id);
    }
}
