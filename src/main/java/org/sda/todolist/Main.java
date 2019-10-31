package org.sda.todolist;

import java.util.Scanner;

/**
 * This is main class of the project
 *
 * @author Imtiaz
 * @version 1.0
 * @since 2019-10-11
 **/


public class Main {
    public static String filename = "tasks.obj";

    public static void main(String args[]) {
        TodoList todoList = new TodoList();
        String menuChoice = "-17";

        try {
            Scanner input = new Scanner(System.in);

            todoList.readFromFile(filename);

            Messages.showMessage("Welcome to ToDoList", false);

            while (!menuChoice.equals("4")) {
                Messages.mainMenu(todoList.notCompletedCount(), todoList.completedCount());
                menuChoice = input.nextLine();

                switch (menuChoice) {
                    case "1":
                        Messages.listAllTasksMenu();
                        todoList.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        todoList.readTaskFromUser();
                        break;
                    case "3":
                        todoList.listAllTasksWithIndex();
                        Messages.editTaskSelection();
                        todoList.editTask(input.nextLine());
                        break;
                    case "4":
                        break;

                    default:
                        Messages.unknownMessage();
                }
            }

            todoList.saveToFile(filename);
            Messages.byeMessage();

        } catch (Exception e) {
            Messages.showMessage("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to save the unsaved tasks in data file");
            //todoList.saveToFile(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}