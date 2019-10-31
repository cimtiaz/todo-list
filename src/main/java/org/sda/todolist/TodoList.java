package org.sda.todolist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class represents ToDoList which contains the ArrayList of Tasks
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-11
 **/

public class TodoList {
    private ArrayList<Task> taskList;

    public TodoList() {
        taskList = new ArrayList<>();
    }

    public void addTask(String title, String project, LocalDate dueDate) {
        this.taskList.add(new Task(title,project,dueDate));
    }

    public boolean readTaskFromUser() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println(Messages.GREEN_TEXT + "Please enter the following details to add a task:" + Messages.RESET_TEXT);
            System.out.print(">>> Task Title  : ");
            String title = scan.nextLine();
            System.out.print(">>> Project Name: ");
            String project = scan.nextLine();
            System.out.print(">>> Due Date [example: 2019-12-31] : ");
            LocalDate dueDate = LocalDate.parse(scan.nextLine());

            this.taskList.add(new Task(title,project,dueDate));
            Messages.showMessage("Task is added successfully", false);

            return true;
        } catch (Exception e) {
            Messages.showMessage(e.getMessage(),true);
            return false;
        }

    }

    public boolean readTaskFromUserToUpdate(Task task) {
        Scanner scan = new Scanner(System.in);
        boolean isTaskUpdated = false;

        try {
            System.out.println(Messages.GREEN_TEXT + "Please enter the following details to update a task:"
                    + "\nIf you do not want to change any field, just press ENTER key!" + Messages.RESET_TEXT);
            System.out.print(">>> Task Title  : ");
            String title = scan.nextLine();
            if (!(title.trim().equals("") || title == null)) {
                task.setTitle(title);
                isTaskUpdated = true;
            }

            System.out.print(">>> Project Name: ");
            String project = scan.nextLine();
            if (!(project.trim().equals("") || project == null)) {
                task.setProject(project);
                isTaskUpdated = true;
            }

            System.out.print(">>> Due Date [example: 2019-12-31] : ");
            String dueDate = scan.nextLine();
            if (!(dueDate.trim().equals("") || dueDate == null)) {
                task.setDueDate(LocalDate.parse(dueDate));
                isTaskUpdated = true;
            }

            Messages.showMessage("Task is " + (isTaskUpdated ? "updated successfully" : "NOT modified") + ": Returning to Main Menu", false);

            return true;
        } catch (Exception e) {
            Messages.showMessage(e.getMessage(), true);
            return false;
        }
    }

    public void listAllTasksWithIndex() {
        String displayFormat = "%-4s%-35s %-20s %-10s %-10s";

        if (taskList.size()>0) {
            System.out.println(String.format(displayFormat,"NUM","TITLE","PROJECT","DUE DATE","COMPLETED"));
            System.out.println(String.format(displayFormat,"===","=====","=======","========","========="));
        } else {
            System.out.println(Messages.RED_TEXT + "No tasks to show" + Messages.RESET_TEXT);
        }

        taskList.stream()
                .forEach(task -> System.out.println(String.format(displayFormat,
                        taskList.indexOf(task)+1,
                        task.getTitle(),
                        task.getProject(),
                        task.getDueDate(),
                        (task.isComplete()?"YES":"NO")
                )));
    }

    public void listAllTasks(String sortBy) {
        Messages.separator('=',75);
        System.out.println(
                "Total Tasks = " + taskList.size() +
                        "\t\t (Completed = " + completedCount() + "\t\t" +
                        Messages.RED_TEXT + " Not Compeleted = " + notCompletedCount() + Messages.RESET_TEXT +
                        " )");
        Messages.separator('=',75);

        if (sortBy.equals("2")) {
            String displayFormat = "%-20s %-35s %-10s %-10s";

            if (taskList.size()>0) {
                System.out.println(String.format(displayFormat,"PROJECT","TITLE","DUE DATE","COMPLETED"));
                System.out.println(String.format(displayFormat,"=======","=====","========","========="));
            } else {
                System.out.println(Messages.RED_TEXT + "No tasks to show" + Messages.RESET_TEXT);
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                            task.getTitle(),
                            task.getDueDate(),
                            (task.isComplete()?"YES":"NO")
                    )));
        } else {
            String displayFormat = "%-10s %-35s %-20s %-10s";

            if (taskList.size() > 0) {
                System.out.println(String.format(displayFormat,"DUE DATE","TITLE","PROJECT" , "COMPLETED"));
                System.out.println(String.format(displayFormat,"========","=====","=======" , "========="));
            } else {
                System.out.println(Messages.RED_TEXT + "No tasks to show" + Messages.RESET_TEXT);
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getDueDate))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDueDate(),
                            task.getTitle(),
                            task.getProject(),
                            (task.isComplete() ? "YES" : "NO")
                    )));
        }
    }

    public void editTask(String selectedTask) {
        try {
            if (selectedTask.trim().equals("") || selectedTask == null) {
                throw new NullPointerException("INVALID TASK NUM: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new NullPointerException("INVALID TASK NUM: Returning to Main Menu");
            }

            Task task = taskList.get(taskIndex);

            Messages.showMessage("Task Num " + selectedTask + "  is selected:" + task.formattedStringOfTask(), false);

            Messages.editTaskMenu();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    readTaskFromUserToUpdate(task);
                    break;
                case "2":
                    task.Completed();
                    Messages.showMessage("Task Num " + selectedTask + " is marked as Completed: Returning to Main Menu", false);
                    break;
                case "3":
                    taskList.remove(task);
                    Messages.showMessage("Task Num " + selectedTask + " is Deleted: Returning to Main Menu", true);
                    break;
                default:
                    Messages.showMessage("Returning to Main Menu", true);
            }
        } catch (Exception e) {
            Messages.showMessage(e.getMessage(),true);
        }
    }


    public int completedCount() {
        return (int) taskList.stream()
                .filter(Task::isComplete)
                .count();
    }

    public int notCompletedCount() {
        return (int) taskList.stream()
                .filter(task -> !task.isComplete())
                .count();
    }

    public void readFromFile(String filename) {
        try {

            if (!Files.isReadable(Paths.get(filename))) {
                Messages.showMessage("The data file, i.e., " + filename + " does not exists", true);
                return;
            }

            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ArrayList<Task>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            Messages.showMessage(e.getMessage(),true);
        }
    }

    public void saveToFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            Messages.showMessage(e.getMessage(),true);
        }
    }
}
