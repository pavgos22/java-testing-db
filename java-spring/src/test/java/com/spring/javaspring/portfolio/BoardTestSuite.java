package com.spring.javaspring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    public void testTaskAdd() {
        String toDoTask = "TODO Task";
        String inProgressTask = "InProgress Task";
        String doneTask = "Done Task";

        board.getToDoList().addTask(toDoTask);
        board.getInProgressList().addTask(inProgressTask);
        board.getDoneList().addTask(doneTask);

        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals(1, board.getInProgressList().getTasks().size());
        assertEquals(1, board.getDoneList().getTasks().size());

        assertTrue(board.getToDoList().getTasks().contains(toDoTask));
        assertTrue(board.getInProgressList().getTasks().contains(inProgressTask));
        assertTrue(board.getDoneList().getTasks().contains(doneTask));
    }
}
