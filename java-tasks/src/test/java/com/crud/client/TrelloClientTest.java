package com.crud.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.crud.tasks.domain.AttachmentsByType;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    private Trello trello = new Trello(1,1);
    private AttachmentsByType attachmentsByType = new AttachmentsByType(trello);
    Badges badges = new Badges(10, attachmentsByType);

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
        // Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(trelloConfig.getTrelloUser()).thenReturn("test");

        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_id", "my board", new ArrayList<>());

        URI uri = new URI("http://test.com/members/test/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(trelloBoards);
        // When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloClient.getTrelloBoards();
        // Then
        assertEquals(1, fetchedTrelloBoards.size());
        assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
        assertEquals("my board", fetchedTrelloBoards.get(0).getName());
        assertEquals(new ArrayList<>(), fetchedTrelloBoards.get(0).getLists());
    }

    @Test
    public void shouldCreateCard() throws URISyntaxException {
        // Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );
        URI uri = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20Description&pos=top&idList=test_id");

        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto(
                "1",
                "test task",
                "http://test.com",
                badges
        );

        when(restTemplate.postForObject(uri, null, CreatedTrelloCardDto.class)).thenReturn(createdTrelloCardDto);
        // When
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        // Then
        assertEquals("1", newCard.getId());
        assertEquals("test task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());
    }

    @Test
    public void shouldReturnEmptyList() throws URISyntaxException {
        // Given
        URI expectedUri = new URI("http://test.com/members/test/boards?key=test&token=test&fields=name,id&lists=all");
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(trelloConfig.getTrelloUser()).thenReturn("test");

        when(restTemplate.getForObject(expectedUri, TrelloBoardDto[].class)).thenReturn(null);

        // When
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        // Then
        assertTrue(trelloBoards.isEmpty(), "The returned list should be empty");
    }

    @Test
    void shouldHandleRestClientException() {
        // Given
        URI uri = URI.create("http://fake-url.com");
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://fake-url.com");
        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenThrow(new RestClientException("Failed"));

        // When
        Exception exception = assertThrows(RestClientException.class, () -> trelloClient.getTrelloBoards());

        // Then
        assertEquals("Failed", exception.getMessage());
    }

    @Test
    void shouldReturnEmptyListOnBadRequest() {
        // Given
        URI uri = URI.create("http://fake-url.com");
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://fake-url.com");
        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(null);

        // When
        List<TrelloBoardDto> result = trelloClient.getTrelloBoards();

        // Then
        assertTrue(result.isEmpty());
    }

}