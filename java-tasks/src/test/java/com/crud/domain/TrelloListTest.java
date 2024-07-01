package com.crud.domain;

import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloListTest {

    @Test
    void testListFields() {
        TrelloList trelloList = new TrelloList("listId", "ToDo", false);

        assertAll(
                () -> assertEquals("listId", trelloList.getId()),
                () -> assertEquals("ToDo", trelloList.getName()),
                () -> assertFalse(trelloList.isClosed())
        );
    }
}
