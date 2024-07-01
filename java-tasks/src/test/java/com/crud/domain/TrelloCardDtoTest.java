package com.crud.domain;

import com.crud.tasks.domain.TrelloCardDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrelloCardDtoTest {

    @Test
    void testCardDtoFields() {
        TrelloCardDto trelloCardDto = new TrelloCardDto("Task 1", "Description", "top", "10");

        assertAll(
                () -> assertEquals("Task 1", trelloCardDto.getName()),
                () -> assertEquals("Description", trelloCardDto.getDescription()),
                () -> assertEquals("top", trelloCardDto.getPos()),
                () -> assertEquals("10", trelloCardDto.getListId())
        );
    }
}
