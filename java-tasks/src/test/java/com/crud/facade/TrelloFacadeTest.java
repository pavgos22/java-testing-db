package com.crud.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.facade.TrelloFacade;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.validator.TrelloValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloFacadeTest {

    @InjectMocks
    private TrelloFacade trelloFacade;

    @Mock
    private TrelloService trelloService;

    @Mock
    private TrelloValidator trelloValidator;

    @Mock
    private TrelloMapper trelloMapper;

    private final Trello trello = new Trello(1,1);
    private final AttachmentsByType attachmentsByType = new AttachmentsByType(trello);

    @Test
    void shouldFetchTrelloBoards() {
        // Given
        List<TrelloListDto> trelloLists =
                List.of(new TrelloListDto("1", "test_list", false));

        List<TrelloBoardDto> trelloBoards =
                List.of(new TrelloBoardDto("1", "test", trelloLists));

        List<TrelloList> mappedTrelloLists =
                List.of(new TrelloList("1", "test_list", false));

        List<TrelloBoard> mappedTrelloBoards =
                List.of(new TrelloBoard("1", "test", mappedTrelloLists));

        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoards);
        when(trelloMapper.mapToBoards(trelloBoards)).thenReturn(mappedTrelloBoards);
        when(trelloMapper.mapToBoardsDto(anyList())).thenReturn(trelloBoards);
        when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(mappedTrelloBoards);

        // When
        List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();

        // Then
        assertNotNull(trelloBoardDtos);
        assertEquals(1, trelloBoardDtos.size());

        trelloBoardDtos.forEach(trelloBoardDto -> {

            assertEquals("1", trelloBoardDto.getId());
            assertEquals("test", trelloBoardDto.getName());

            trelloBoardDto.getLists().forEach(trelloListDto -> {
                assertEquals("1", trelloListDto.getId());
                assertEquals("test_list", trelloListDto.getName());
                assertFalse(trelloListDto.isClosed());
            });
        });
    }

    @Test
    void testFetchTrelloBoardsFiltered() {
        TrelloListDto listDto = new TrelloListDto("1", "Test List", false);
        TrelloBoardDto boardDto = new TrelloBoardDto("1", "Test Board", List.of(listDto));
        TrelloBoard board = new TrelloBoard("1", "Test Board", List.of(new TrelloList("1", "Test List", false)));

        when(trelloService.fetchTrelloBoards()).thenReturn(List.of(boardDto));
        when(trelloMapper.mapToBoards(List.of(boardDto))).thenReturn(List.of(board));
        when(trelloValidator.validateTrelloBoards(List.of(board))).thenReturn(List.of(board));
        when(trelloMapper.mapToBoardsDto(List.of(board))).thenReturn(List.of(boardDto));

        List<TrelloBoardDto> filteredBoards = trelloFacade.fetchTrelloBoards();
        assertAll(
                () -> assertEquals(1, filteredBoards.size()),
                () -> assertEquals("Test Board", filteredBoards.get(0).getName())
        );
    }

    @Test
    void shouldCreateCard() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Task", "Description", "top", "listId");
        TrelloCard trelloCard = new TrelloCard("Task", "Description", "top", "listId");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Task", "http://test.com", new Badges(10, attachmentsByType));

        when(trelloMapper.mapToCard(trelloCardDto)).thenReturn(trelloCard);
        when(trelloService.createTrelloCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        // When
        CreatedTrelloCardDto newCard = trelloFacade.createCard(trelloCardDto);

        // Then
        assertEquals("1", newCard.getId());
        assertEquals("Task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());
    }
}
