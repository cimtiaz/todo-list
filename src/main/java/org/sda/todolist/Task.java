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
    private boolean status;
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
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public boolean toggleStatus() {
        status=!status;
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String printTask() {
        return ("\nTitle: "+title+"\nProject: "+project+"\nStatus: "+status+"\nDue Date: "+dueDate+"\n");
    }
}
