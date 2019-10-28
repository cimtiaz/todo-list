package org.sda.todolist;

import java.util.Date;

/**
 * This class represents a Task and contains necessary fields and methods
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-11
 **/


public class Task {
    private String title;
    private String project;
    private boolean complete;
    private Date dueDate;

    public Task() {
        this("Task 1", "Project 1", false, new Date());
    }

    public Task(String title) {
        this(title, "Project 1", false, new Date());
    }

    public Task(String title, String project) {
        this(title, project, false, new Date());
    }

    public Task(String title, String project, boolean status, Date dueDate) {
        this.title = title;
        this.project = project;
        this.complete = status;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public boolean isComplete() {
        return complete;
    }

    public boolean toggleStatus() {
        complete =!complete;
        return complete;
    }

    public void Completed() {
        this.complete = true;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String printTask() {
        return ("\nTitle: "+title+"\nProject: "+project+"\nStatus: "+ complete +"\nDue Date: "+dueDate+"\n");
    }
}
