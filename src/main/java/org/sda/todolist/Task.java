package org.sda.todolist;

import java.time.LocalDate;
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
    private LocalDate dueDate;

    public Task(String title, String project) {
        this(title, project, false, LocalDate.now());
    }

    public Task(String title, String project, boolean status, LocalDate dueDate) {
        this.title = title;
        this.project = project;
        this.complete = status;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Title can not be empty.");
        }
        this.title = title.trim();
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String formattedStringOfTask() {
        return (
                "\nTitle     : " + title +
                        "\nProject   : " + project +
                        "\nStatus    : " + (complete?"Completed":"NOT COMPLETED") +
                        "\nDue Date  : " + dueDate +
                        "\n");
    }
}
