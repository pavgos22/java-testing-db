package com.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() throws CloneNotSupportedException {
        Library library = new Library("Main Library");
        Book book1 = new Book("Title1", "Author1", LocalDate.of(2001, 1, 1));
        Book book2 = new Book("Title2", "Author2", LocalDate.of(2002, 2, 2));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        Library shallowClonedLibrary = library.shallowCopy();
        shallowClonedLibrary.setName("Shallow Cloned Library");

        Library deepClonedLibrary = library.deepCopy();
        deepClonedLibrary.setName("Deep Cloned Library");

        library.getBooks().add(new Book("Title3", "Author3", LocalDate.of(2003, 3, 3)));


        assertEquals(3, library.getBooks().size());
        assertEquals(3, shallowClonedLibrary.getBooks().size());
        assertEquals(2, deepClonedLibrary.getBooks().size());

        assertNotEquals(library.getName(), shallowClonedLibrary.getName());
        assertNotEquals(library.getName(), deepClonedLibrary.getName());

        assertSame(library.getBooks(), shallowClonedLibrary.getBooks());
        assertNotSame(library.getBooks(), deepClonedLibrary.getBooks());

    }
}
