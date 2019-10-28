package org.sda.todolist;

import java.util.ArrayList;
import java.util.Comparator;

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

    public TodoList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void addTask() {
        int num = taskList.size()+1;
        this.taskList.add(new Task("Task "+num,"Project"));
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
}
