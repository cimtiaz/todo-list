package org.sda.todolist;

/**
 * This is main contains various display messages
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-17
 **/

public class Messages {
    //A public constant field to hold code to RESET the text font color
    public static final String RESET_TEXT = "\u001B[0m";
    //A public constant field to hold code to change the text font color to RED
    public static final String RED_TEXT = "\u001B[31m";
    //A public constant field to hold code to change the text font color to GREEN
    public static final String GREEN_TEXT = "\u001B[32m";

    /**
     * This method will display the main menu (top level menu) on standard output (terminal)
     * to display all options for user selection.
     * @param incompleteTaskCount takes the number of incomplete tasks (int) to show in main menu
     * @param completedTaskCount takes the number of complete tasks (int) to show in main menu
     */
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

    /**
     * This method displays the menu to standard output (terminal) to show the options to display all tasks
     * for user selection
     */
    public static void listAllTasksMenu() {
        System.out.println("\nDisplay All Tasks");
        System.out.println("===================\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List by date" +
                Messages.RED_TEXT + " [default choice, just press ENTER key]" + Messages.RESET_TEXT);
        System.out.println("(2) Show Task List by project");
        System.out.print("\nPlease enter your choice [1-2]: ");
    }

    /**
     * This method will display a prompt to user for typing the task number to EDIT
     */
    public static void editTaskSelection() {
        System.out.println(GREEN_TEXT);
        System.out.print(">>> Type a task number to EDIT and press ENTER key: ");
        System.out.print(RESET_TEXT);
    }

    /**
     * This method will display the Edit menu options on standard output (terminal)
     * for user selection
     */
    public static void editTaskMenu() {
        System.out.println("\nTask Edit Options");
        System.out.println("======================\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Modify selected task");
        System.out.println("(2) Mark selected task as COMPLETED");
        System.out.println("(3) Delete selected task");
        System.out.println("(4) Return to main menu "
                + Messages.RED_TEXT + " [default choice, just press ENTER]"+Messages.RESET_TEXT);
        System.out.print("\nPlease enter your choice [1-4]: ");
    }

    /**
     * This method will display the bye message while ending the program
     */
    public static void  byeMessage() {
        System.out.println(GREEN_TEXT);
        System.out.println(">>> All tasks are saved to data file");
        System.out.println(">>> Good Bye");
        System.out.println(RESET_TEXT);
    }

    /**
     * This method will display the error message if a user input an option which is not
     * from the choices given in main menu
     */
    public static void unknownMessage() {
        System.out.println(RED_TEXT);
        System.out.println(">>> Incorrect choice: Please type a number from given choices ");
        System.out.print(RESET_TEXT);
    }

    /**
     * This message will display any given message in RED or GREEN text on standard output (terminal)
     * @param message a text message as String
     * @param warning a boolean value, true for printing warning with RED text, and false
     *                for printing message in GREEN text on standard output (terminal)
     */
    public static void showMessage(String message, boolean warning) {
        System.out.println(warning?RED_TEXT:GREEN_TEXT);
        System.out.println(">>> " + message);
        System.out.println(RESET_TEXT);
    }

    /**
     * This message will print the given character on standard output (terminal) to given number of times
     * @param charToPrint a character given in single quote to print, i.e., '='
     * @param times an integer to repeat printing the given character
     */
    public static void separator (char charToPrint, int times) {
        for (int index=0; index<times; index++) System.out.print(charToPrint);
        System.out.println("");
    }

}
