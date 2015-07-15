package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;

    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    @Before
    public void setup() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);

        library = new Library(books, printStream, dateTimeFormatter);

        time = new DateTime();
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        library.listBooks();
        verify(printStream).println("Book Title");

        // add a verify statement here that shows that the book title was printed by to the printStream
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library.listBooks();
        verify(printStream, never()).println();
        // implement me
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        String t1 = "Catch-22";
        String t2 = "Freakonomics";

        books.add(t1);
        books.add(t2);

        library.listBooks();
        verify(printStream).println("Catch-22");
        verify(printStream).println("Freakonomics");
        // implement me
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        when(dateTimeFormatter.print(time)).thenReturn("2015-07-13 17:31:01");

        library.welcome(time);

        verify(printStream).println(contains("2015-07-13 17:31:01"));

        // implement me
        // then move common test variables into a setup method
    }
}