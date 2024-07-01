//package com.crud.serialization;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import com.crud.tasks.domain.Trello;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
////JSON Deserialization
//class TrelloTest {
//
//    @Test
//    void shouldDeserializeJsonIntoTrelloObject() throws Exception {
//        // Given
//        String json = "{\"board\": 10, \"card\": 20}";
//        ObjectMapper mapper = new ObjectMapper();
//
//        // When
//        Trello trello = mapper.readValue(json, Trello.class);
//
//        // Then
//        assertEquals(10, trello.getBoard());
//        assertEquals(20, trello.getCard());
//    }
//}

