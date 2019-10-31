package org.sda.todolist;

import org.junit.Before;
import org.junit.Test;

import java.net.StandardSocketOptions;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

/**
 * This class is created for unit testing for model class, i.e., Task (Task.java)
 *
 * @author  Imtiaz
 * @version 1.0
 * @since   2019-10-11
 **/


public class TaskTest {
    Task task;

    String validTitle="Test Title";
    String validProject="Test Project";
    LocalDate validDueDate=LocalDate.parse("2020-12-31");


    /**
     * This method will execute before executing any Test.
     * This method will initialize the task object with vaid test parameters.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        try {
            task = new Task(validTitle, validProject, validDueDate);
        } catch (Exception e) {
            System.out.println("There are few errors in the testing of Task class");
            System.out.println("Following message could be helpful to identify the cause:");
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method will validate the task.getTitle() method for valid parameter
     */
    @Test
    public void testValidTitle() {
        assertEquals(validTitle,task.getTitle());
    }

    /**
     * This method will validate the task.setTitle() method for an empty string "" as invalid parameter
     * which should result as NullPointerException
     */
    @Test
    public void testEmptyTitle() {
        boolean success=false;

        try {
            task.setTitle("");
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * This method will validate the task.setTitle() method for trimming an empty string "     " as invalid parameter
     * which should result as NullPointerException
     */
    @Test
    public void testTrimEmptyTitle() {
        boolean success=false;

        try {
            task.setTitle("           ");
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * This method will validate the task.setTitle() method for null as invalid parameter
     * which should result as NullPointerException
     */
    @Test
    public void testNullTitle() {
        boolean success=false;

        try {
            task.setTitle(null);
            fail("should have thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * This method will validate the task.getProject() method for valid parameter
     * Project title is allowed be empty
     */
    @Test
    public void testValidProject() {
        assertEquals(validProject,task.getProject());
    }

    /**
     * This method will validate the task.setProject() method for empty string "" as parameter
     * And it will also test the task.getProject
     * Project title is allowed be empty
     */
    @Test
    public void testEmptyProject() {
        task.setProject("");
        assertEquals("",task.getProject());
    }

    /**
     * This method will validate the task.getDueDate() method
     */
    @Test
    public void testvalidDueDate() {
        assertEquals(validDueDate,task.getDueDate());
    }

    /**
     * This method will validate the task.setDueDate() method with a wrong format date as parameter
     */
    @Test
    public void testIncorrectFormatDueDate() {
        boolean success=false;

        try {
            task.setDueDate(LocalDate.parse("2020-31-12"));
            fail("should have thrown a DateTimeParseException");
        } catch (DateTimeParseException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * This method will validate the task.setDueDate() method with a past due date
     * If a past due date is tried to set, it should throw DateTimeException
     */
    @Test
    public void testPastDueDate() {
        boolean success=false;

        try {
            task.setDueDate(LocalDate.parse("2017-08-17"));
            fail("should have thrown a DateTimeParseException");
        } catch (DateTimeException e) {
            success = true;
        }

        assertEquals(true,success);
    }
}