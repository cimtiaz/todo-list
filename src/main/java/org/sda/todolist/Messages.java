package org.sda.todolist;

import java.util.Scanner;

/**
 * This is main contains various display messages
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-17
 **/

public class Messages {
    public static final String RESET_TEXT = "\u001B[0m";
    public static final String RED_TEXT = "\u001B[31m";
    public static final String GREEN_TEXT = "\u001B[32m";

    public static void mainMenu(int incompleteTaskCount, int completedTaskCount) {
        System.out.println("\nMAIN MENU");
        System.out.println("===========\n");
        System.out.println("You have " + Messages.RED_TEXT
                + incompleteTaskCount + " task(s) todo "
                + Messages.RESET_TEXT + " and " + Messages.GREEN_TEXT
                + completedTaskCount + " completed task(s)\n" + Messages.RESET_TEXT);
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit\n");
        System.out.print("Please enter your choice [1-4]: ");
    }

    public static void  byeMessage() {
        System.out.println(GREEN_TEXT);
        System.out.println(">>> All tasks are saved to data file");
        System.out.println(">>> Good Bye");
        System.out.println(RESET_TEXT);
    }

    public static void unknownMessage() {
        System.out.println(RED_TEXT);
        System.out.println(">>> Incorrect choice: Please type a number from given choices ");
        System.out.print(RESET_TEXT);
    }

    public static void showMessage(String message, boolean warning) {
        System.out.println(warning?RED_TEXT:GREEN_TEXT);
        System.out.println(">>> " + message);
        System.out.println(RESET_TEXT);
    }

    public static void separator (char charToPrint, int times) {
        for (int index=0; index<times; index++) System.out.print(charToPrint);
        System.out.println("");
    }

}
