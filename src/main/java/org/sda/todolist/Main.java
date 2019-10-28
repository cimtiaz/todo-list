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

        Scanner input = new Scanner(System.in);

        Messages.showMessage("Welcome to ToDoList", false);

        while (!menuChoice.equals("4")) {
            Messages.mainMenu(5, 2);
            menuChoice = input.nextLine();

            switch (menuChoice) {
                case "1":
                    Messages.listAllTasksMenu();
                    //todoList.listAllTasks(input.nextLine());
                    break;
                case "2":
                    //todoList.readTaskFromUser();
                    break;
                case "3":
                    //todoList.editTask();
                    break;
                case "4":
                    break;

                default:
                    Messages.unknownMessage();
            }
        }

        Messages.byeMessage();

    }
}