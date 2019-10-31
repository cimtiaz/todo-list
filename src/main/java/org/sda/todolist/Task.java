package org.sda.todolist;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * This class represents a Task and contains necessary fields and methods
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-11
 **/


public class Task implements Serializable {
    private String title;
    private String project;
    private boolean complete;
    private LocalDate dueDate;


    public Task(String title, String project, LocalDate dueDate) {

        this.setTitle(title);
        this.setProject(project);
        this.complete = false;
        this.setDueDate(dueDate);
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
        this.project = project.trim();
    }

    public boolean isComplete() {
        return complete;
    }

    public boolean toggleStatus() {
        complete = !complete;
        return complete;
    }

    public void Completed() {
        this.complete = true;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        // Throw DateTimeException if past date is given
        if (dueDate.compareTo(LocalDate.now())<0) {
            throw new DateTimeException("Past Date not allowed");
        }

        //Ensure dueDate is saved as yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
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
