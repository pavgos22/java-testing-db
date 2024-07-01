package com.crud.service;

import com.crud.client.TrelloClient;
import com.crud.tasks.domain.*;
import com.crud.tasks.service.TrelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {

    @Mock
    private TrelloClient trelloClient;

    @InjectMocks
    private TrelloService trelloService;

    private final Trello trello = new Trello(1,1);
    private final AttachmentsByType attachmentsByType = new AttachmentsByType(trello);

    @Test
    void testFetchTrelloBoards() {
        TrelloBoardDto boardDto = new TrelloBoardDto("1", "Test", new ArrayList<>());
        when(trelloClient.getTrelloBoards()).thenReturn(List.of(boardDto));

        List<TrelloBoardDto> boards = trelloService.fetchTrelloBoards();
        assertEquals(1, boards.size());
        assertEquals("Test", boards.get(0).getName());
    }

    @Test
    void shouldCreateTrelloCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Task", "Description", "top", "listId");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Task", "http://test.com", new Badges(10, attachmentsByType));

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        // When
        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);

        // Then
        assertNotNull(newCard);
        assertEquals("1", newCard.getId());
        assertEquals("Task", newCard.getName());
    }
}

