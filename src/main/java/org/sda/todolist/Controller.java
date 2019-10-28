package org.sda.todolist;

import java.util.Scanner;

/**
 * This is main class of the project
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-11
 **/


public class Controller {
    private static void showMenu() {
        System.out.println("\n\nWelcome to ToDoLy");
        System.out.println("=====================\n");
        System.out.println("You have X tasks todo and Y tasks are done!\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit\n");
    }

    public static void main(String args[]) {
        TodoList todoList = new TodoList();
        String menuChoice="-17";
        Scanner input = new Scanner(System.in);

        while (!menuChoice.equals("4")) {
            showMenu();
            System.out.print("Please enter your choice [1-4]: ");
            menuChoice = input.nextLine();

            switch(menuChoice) {
                case "1":
                    System.out.println("\n===============");
                    System.out.println("SHOW TASK LIST");
                    System.out.println("==============");
                    todoList.listTaskList();
                    break;
                case "2":
                    System.out.println("\n========");
                    System.out.println("ADD TASK");
                    System.out.println("========");
                    todoList.addTask();
                    System.out.println("A task is added");

                    break;
                case "3":
                    System.out.println("\n=========");
                    System.out.println("EDIT TASK");
                    System.out.println("=========");
                    break;
                case "4":
                    System.out.println("\n===========");
                    System.out.println("SAVE & EXIT");
                    System.out.println("===========\n");
                    System.out.print("Are you sure? [press any key for NO or press y for YES] ");
                    menuChoice = input.nextLine();
                    menuChoice = menuChoice.equals("y")? "4": "-17";
                    System.out.println("You typed " + menuChoice);
                    break;

                default:
                    System.out.println("\n===========================================");
                    System.out.println("I did not understand, why you type:  " + menuChoice + "?");
                    System.out.println("===========================================\n");
            }
        }

    }
}