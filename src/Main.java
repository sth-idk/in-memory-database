
import db.Database;
import example.Document;
import example.Human;
import db.exception.InvalidEnitityException;
import example.HumanValidator;
import todo.entity.Task;
import todo.service.StepService;
import todo.service.TaskService;

import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InvalidEnitityException, CloneNotSupportedException {

        //test code of fifth step
         Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Database.registerValidator(Task.HUMAN_ENTITY_CODE, new TaskValidator());
        Database.registerValidator(0, new TaskValidator()); // code 0 for Tasks
        Database.registerValidator(1, new StepValidator()); // code 1 for Steps

        while (true) {
            try {
                switch (command.toLowerCase()) {

                    case "add task": {
                        System.out.print("title: ");
                        String title = scanner.nextLine();
                        System.out.print("description: ");
                        String description = scanner.nextLine();
                        System.out.print("due date (yyyy-mm-dd): ");
                        
                        System.out.println("Task saved successfully.");
                        break;
                    }

                    case "add step": {
                        System.out.print("task ID: ");
                        int id = scanner.nextInt();
                        System.out.print("step title: ");
                        String title = scanner.nextLine();
                        System.out.println("Step saved successfully.");
                        break;
                    }

                    case "delete": {
                        System.out.print("Enter entity ID to delete: ");
                        int id = scanner.nextInt();
                        Database.callDelete(id);
                        System.out.println("Entity with ID=" + id + " successfully deleted.");
                        break;
                    }

                    case "update task": {
                        System.out.print("task ID: ");
                        int id = scanner.nextInt();
                        Task task = (Task) Database.callGet(id);
                        System.out.print("field: ");
                        String field = scanner.nextLine();
                        System.out.print("new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("new due date (yyyy-mm-dd): ");
                        String newDueDate = scanner.nextLine();

                        String oldTitle = task.title;
                        task.title = newTitle;
                        task.description = newDescription;
                        

                        Database.callUpdate(task);

                        System.out.println("Successfully updated the task.");
                        System.out.println("field: " + field);
                        System.out.println("old value: " + oldTitle);
                        System.out.println("new value: " + newTitle);
                        System.out.println("modification date: " + task.getLastModificationDate());
                        break;
                    }

                    case "update step": {
                        System.out.print("step ID: ");
                        int id = scanner.nextInt();
                        Step step = (Step) Database.callGet(id);
                        System.out.print("field: ");
                        String field = scanner.nextLine();
                        System.out.print("new title: ");
                        String newTitle = scanner.nextLine();
                        String oldTitle = step.title;
                        step.title = newTitle;

                        Database.callUpdate(step);

                        System.out.println("Successfully updated the step.");
                        System.out.println("field: " + field);
                        System.out.println("old value: " + oldTitle);
                        System.out.println("new value: " + newTitle);
                        break;


                    }

                    case "get task-by-id": {
                        System.out.print("task ID: ");
                        int id = scanner.nextInt();
                        Task task = (Task) Database.callGet(id);

                        System.out.println("ID: " + task.id);
                        System.out.println("title: " + task.title);
                        System.out.println("due date: " + task.dueDate);
                        System.out.println("status: " + task.status);
                        System.out.println("steps:");
                        for (Entity entity : Database.getAll(0)) {
                            if (entity instanceof Step) {
                                Step step = (Step) entity;
                                if (step.taskRef == task.id) {
                                    System.out.println("    + " + step.title + ":");
                                    System.out.println("ID: " + step.id);
                                    System.out.println("status: " + step.status);
                                }
                            }
                        }
                        break;
                    }

                    case "get all-tasks": {
                        for (Entity entity : Database.getAll(0)) {
                                Task task = (Task) entity;
                                System.out.println();
                                System.out.println("ID: " + task.id);
                                System.out.println("title: " + task.title);
                                System.out.println("due date: " + task.dueDate);
                                System.out.println("status: " + task.status);
                                System.out.println("steps:");
                                for (Entity stepEntity : Database.getAll(0)) {
                                    Step step = null;
                                    System.out.println("    + " + step.title + " ID: " + step.id + " Status: " + step.status);
                                }
                        }
                        break;
                    }

                    case "get incomplete-tasks": {
                        for (Entity entity : Database.getAll(0)) {
                            Task task = null;
                            if (task.status != Task.Status.Completed) {
                                System.out.println("ID: " + task.id);
                                System.out.println("Title: " + task.title);
                                System.out.println("Due Date: " + task.dueDate);
                                System.out.println("Status: " + task.status);
                            }
                        }
                        break;
                    }

                    case "exit": {
                        break;
                    }
                }
                }catch(InvalidEnitityException | EntityNotFoundException e){
                    System.out.println("Cannot process command.");
                    System.out.println("Error: " + e.getMessage());
                }


      
      
        //test code of fourth step
        /*Document doc = new Document("Eid Eid Eid");
        doc = (Document) Database.callAdd(doc);

        System.out.println("Document added");
        System.out.println("id: " + doc.id);
        System.out.println("content: " + doc.content);
        System.out.println("creation date: " + doc.getCreationDate());
        System.out.println("last modification date: " + doc.getLastModificationDate());
        System.out.println();

        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }


        doc.content = "This is the new content";

        Database.callUpdate(doc);
        Document updated = (Document) Database.callGet(doc.id);

        System.out.println("Document updated");
        System.out.println("id: " + updated.id);
        System.out.println("content: " + updated.content);
        System.out.println("creation date: " + updated.getCreationDate());
        System.out.println("last modification date: " + updated.getLastModificationDate());*/
      
      
      
//test code of the third step
        /*Database.registerValidator(Human.HUMAN_ENTITY_CODE, new HumanValidator());

        Human ali = new Human("Ali", -10);
        Database.callAdd(ali);*/

    
      
      
/////////////////////////////
//test code of the second step
/*public static void main(String[] args) throws CloneNotSupportedException {
    Human ali = new Human("Ali");
    Database.callAdd(ali);

    ali.name = "Ali Hosseini";

    Human aliFromTheDatabase = (Human) Database.callGet(ali.id);

    System.out.println("ali's name in the database: " + aliFromTheDatabase.name);*/
      
      
/////////////////////////////
//test code of the first step
/*public class Main {
    public static void main(String[] args) {
        Human[] humans = {
                new Human("Gholi"),
                new Human("Jamshid"),
                new Human("Akbar"),
        };

        System.out.println("#### Test add method ####");

        for (Human h : humans) {
            System.out.println("Adding " + h.name + " to the database.");
            Database.callAdd(h);
        }

        for (Human h : humans) {
            System.out.println("Id of \"" + h.name + "\" is " + h.id + ".");
        }

        System.out.println();
        System.out.println("#### Test get method ####");

        int gholiId = humans[0].id;
        Human gholi = (Human) Database.callGet(gholiId);

        System.out.println("successfully got " + gholi.name + " from the database.");

        System.out.println();
        System.out.println("#### Test update method ####");

        gholi.name = "Gholi Mohammadi";
        Database.callUpdate(gholi);

        Human gholiAgain = (Human) Database.callGet(gholiId);
        System.out.println("Updated name: \"" + gholiAgain.name + "\".");

        System.out.println();
        System.out.println("#### Test delete method ####");


        int akbarId = humans[2].id;
        Database.callDelete(akbarId);

        try {
            Human akbar = (Human) Database.callGet(akbarId);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }*/
    }
}

