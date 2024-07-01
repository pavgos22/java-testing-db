package com.crud.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.crud.tasks.mapper.TrelloMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrelloMapperTest {

    private TrelloMapper trelloMapper;

    @BeforeEach
    public void init() {
        trelloMapper = new TrelloMapper();
    }

    @Test
    public void testMapToBoards() {
        // Given
        TrelloListDto listDto = new TrelloListDto("1", "ToDo", false);
        TrelloBoardDto boardDto = new TrelloBoardDto("1", "Test Board", List.of(listDto));

        // When
        List<TrelloBoard> mappedBoards = trelloMapper.mapToBoards(List.of(boardDto));

        // Then
        assertEquals(1, mappedBoards.size());
        assertEquals("Test Board", mappedBoards.get(0).getName());
        assertEquals("ToDo", mappedBoards.get(0).getLists().get(0).getName());
    }

    @Test
    public void testMapToBoardsDto() {
        // Given
        TrelloList list = new TrelloList("1", "Done", true);
        TrelloBoard board = new TrelloBoard("1", "Test Board", List.of(list));

        // When
        List<TrelloBoardDto> mappedBoardDtos = trelloMapper.mapToBoardsDto(List.of(board));

        // Then
        assertEquals(1, mappedBoardDtos.size());
        assertEquals("Test Board", mappedBoardDtos.get(0).getName());
        assertTrue(mappedBoardDtos.get(0).getLists().get(0).isClosed());
    }

    // Additional tests for the other public methods

    @Test
    public void testMapToList() {
        // Given
        TrelloListDto listDto = new TrelloListDto("1", "List One", true);

        // When
        List<TrelloList> mappedLists = trelloMapper.mapToList(List.of(listDto));

        // Then
        assertEquals(1, mappedLists.size());
        assertEquals("List One", mappedLists.get(0).getName());
        assertTrue(mappedLists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        // Given
        TrelloList list = new TrelloList("1", "List One", true);

        // When
        List<TrelloListDto> mappedListDtos = trelloMapper.mapToListDto(List.of(list));

        // Then
        assertEquals(1, mappedListDtos.size());
        assertEquals("List One", mappedListDtos.get(0).getName());
        assertTrue(mappedListDtos.get(0).isClosed());
    }

    @Test
    public void testMapToCard() {
        // Given
        TrelloCardDto cardDto = new TrelloCardDto("Task 1", "Description", "top", "10");

        // When
        TrelloCard mappedCard = trelloMapper.mapToCard(cardDto);

        // Then
        assertEquals("Task 1", mappedCard.getName());
        assertEquals("Description", mappedCard.getDescription());
        assertEquals("top", mappedCard.getPos());
        assertEquals("10", mappedCard.getListId());
    }

    @Test
    public void testMapToCardDto() {
        // Given
        TrelloCard card = new TrelloCard("Task 1", "Description", "top", "10");

        // When
        TrelloCardDto mappedCardDto = trelloMapper.mapToCardDto(card);

        // Then
        assertEquals("Task 1", mappedCardDto.getName());
        assertEquals("Description", mappedCardDto.getDescription());
        assertEquals("top", mappedCardDto.getPos());
        assertEquals("10", mappedCardDto.getListId());
    }

    @Test
    void testMapToBoardEmptyList() {
        List<TrelloBoardDto> emptyList = Collections.emptyList();
        assertTrue(trelloMapper.mapToBoards(emptyList).isEmpty());
    }

    @Test
    void testMapToBoardNonEmptyList() {
        TrelloListDto listDto = new TrelloListDto("1", "ToDo", false);
        TrelloBoardDto boardDto = new TrelloBoardDto("1", "Test Board", List.of(listDto));
        List<TrelloBoard> boards = trelloMapper.mapToBoards(List.of(boardDto));

        assertAll(
                () -> assertEquals(1, boards.size()),
                () -> assertEquals("Test Board", boards.get(0).getName()),
                () -> assertEquals("ToDo", boards.get(0).getLists().get(0).getName())
        );
    }

    @Test
    void testMapToCardAndCardDto() {
        // Map to Card
        TrelloCardDto trelloCardDto = new TrelloCardDto("Task 1", "Description", "top", "listId");
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        assertAll(
                () -> assertEquals("Task 1", trelloCard.getName()),
                () -> assertEquals("Description", trelloCard.getDescription()),
                () -> assertEquals("top", trelloCard.getPos()),
                () -> assertEquals("listId", trelloCard.getListId())
        );

        // Map to CardDto
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        assertAll(
                () -> assertEquals("Task 1", mappedTrelloCardDto.getName()),
                () -> assertEquals("Description", mappedTrelloCardDto.getDescription()),
                () -> assertEquals("top", mappedTrelloCardDto.getPos()),
                () -> assertEquals("listId", mappedTrelloCardDto.getListId())
        );
    }

    @Test
    void testMapToBoardAndBoardDtoWithEmptyLists() {
        // Map to Board with empty list
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "Test Board", new ArrayList<>());
        List<TrelloBoard> mappedBoards = trelloMapper.mapToBoards(List.of(trelloBoardDto));

        assertAll(
                () -> assertEquals(1, mappedBoards.size()),
                () -> assertEquals("Test Board", mappedBoards.get(0).getName()),
                () -> assertTrue(mappedBoards.get(0).getLists().isEmpty())
        );

        // Map to BoardDto with empty list
        TrelloBoard trelloBoard = new TrelloBoard("1", "Test Board", new ArrayList<>());
        List<TrelloBoardDto> mappedBoardDtos = trelloMapper.mapToBoardsDto(List.of(trelloBoard));

        assertAll(
                () -> assertEquals(1, mappedBoardDtos.size()),
                () -> assertEquals("Test Board", mappedBoardDtos.get(0).getName()),
                () -> assertTrue(mappedBoardDtos.get(0).getLists().isEmpty())
        );
    }
}
