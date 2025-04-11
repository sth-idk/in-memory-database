package todo.service;

import db.Database;
import db.Entity;
import todo.entity.Task;

import java.util.Date;

public class TaskService {

    public static Task createTask(String title, String description, Date dueDate) {
        Task task = new Task();
        task.title = title;
        task.description = description;
        task.dueDate = dueDate;
        task.status = Task.Status.NotStarted;

        Entity added = Database.callAdd(task);
        return (Task) added;
    }
        public static void setAsCompleted(int taskId) {
            Entity entity = Database.callGet(taskId);

            Task task = (Task) entity;
            task.status = Task.Status.Completed;

            Database.callUpdate(task);

    }

    public static void setAsInProgress(int taskId) {
        Entity entity = Database.callGet(taskId);

        Task task = (Task) entity;
        task.status = Task.Status.InProgress;

        Database.callUpdate(task);

    }

    public static void updateTask(Task updatedTask) {
        Database.callUpdate(updatedTask);
    }

    public static Task getTask(int id) {
        Entity entity = Database.callGet(id);
        return (Task) entity;
    }

    public static void deleteTask(int id) {
        Database.callDelete(id);
    }
}
