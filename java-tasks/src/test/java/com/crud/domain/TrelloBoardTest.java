package com.crud.domain;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrelloBoardTest {

    @Test
    void testBoardFields() {
        TrelloList trelloList = new TrelloList("listId", "ToDo", false);
        List<TrelloList> lists = List.of(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("boardId", "Test Board", lists);

        assertAll(
                () -> assertEquals("boardId", trelloBoard.getId()),
                () -> assertEquals("Test Board", trelloBoard.getName()),
                () -> assertEquals(lists, trelloBoard.getLists())
        );
    }
}
