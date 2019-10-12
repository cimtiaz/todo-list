import java.util.ArrayList;

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

    public void listTaskList() {
        for (Task task : taskList) {
            System.out.println(task.printTask());
        }
    }
}
