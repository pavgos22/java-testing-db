package com.crud.validator;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.OutputStreamAppender;
import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.validator.TrelloValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;



import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class TrelloValidatorTest {

    private TrelloValidator trelloValidator;

    @BeforeEach
    void setUp() {
        trelloValidator = new TrelloValidator();
    }

    @Test
    void shouldValidateCardWithTestInName() {
        TrelloCard trelloCard = new TrelloCard("test card", "description", "pos", "listId");
        Logger logger = (Logger) LoggerFactory.getLogger(TrelloValidator.class);
        logger.setLevel(Level.INFO);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder ple = new PatternLayoutEncoder();
        ple.setPattern("%msg%n");
        ple.setContext(lc);
        ple.start();
        OutputStreamAppender<ILoggingEvent> streamAppender = new OutputStreamAppender<>();
        streamAppender.setEncoder(ple);
        streamAppender.setOutputStream(out);
        streamAppender.setContext(lc);
        streamAppender.start();
        logger.addAppender(streamAppender);

        trelloValidator.validateCard(trelloCard);

        String logMsg = out.toString();
        assertTrue(logMsg.contains("Someone is testing my application!"));
        streamAppender.stop();
    }

    @Test
    void shouldValidateProperCard() {
        TrelloCard trelloCard = new TrelloCard("normal card", "description", "pos", "listId");
        Logger logger = (Logger) LoggerFactory.getLogger(TrelloValidator.class);
        logger.setLevel(Level.INFO);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder ple = new PatternLayoutEncoder();
        ple.setPattern("%msg%n");
        ple.setContext(lc);
        ple.start();
        OutputStreamAppender<ILoggingEvent> streamAppender = new OutputStreamAppender<>();
        streamAppender.setEncoder(ple);
        streamAppender.setOutputStream(out);
        streamAppender.setContext(lc);
        streamAppender.start();
        logger.addAppender(streamAppender);

        trelloValidator.validateCard(trelloCard);

        String logMsg = out.toString();
        assertTrue(logMsg.contains("Seems that my application is used in proper way."));
        streamAppender.stop();
    }

    @Test
    void shouldFilterTrelloBoards() {
        List<TrelloBoard> boards = List.of(
                new TrelloBoard("1", "test", new ArrayList<>()),
                new TrelloBoard("2", "work", new ArrayList<>())
        );

        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(boards);

        assertEquals(1, filteredBoards.size());
        assertEquals("work", filteredBoards.get(0).getName());
    }
}
