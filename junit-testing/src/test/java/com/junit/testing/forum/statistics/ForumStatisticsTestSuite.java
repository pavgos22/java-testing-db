package com.junit.testing.forum.statistics;

import com.junit.testing.forum.statistics.ForumStatistics;
import com.junit.testing.forum.statistics.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        forumStatistics = new ForumStatistics();
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("User" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(30);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getAvgPostsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(30);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(10, forumStatistics.getAvgPostsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWithLessCommentsThanPosts() {
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double expectedAvgCommentsPerPost = 50.0 / 100;
        assertEquals(expectedAvgCommentsPerPost, forumStatistics.getAvgCommentsPerPost());
    }


    @Test
    void testCalculateAdvStatisticsWithMoreCommentsThanPosts() {
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        double expectedAvgCommentsPerPost = 100.0 / 50;
        assertEquals(expectedAvgCommentsPerPost, forumStatistics.getAvgCommentsPerPost());
    }


    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getAvgPostsPerUser());
        assertEquals(0, forumStatistics.getAvgCommentsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWithHundredUsers() {
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("User" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(1, forumStatistics.getAvgPostsPerUser());
        assertEquals(2, forumStatistics.getAvgCommentsPerUser());
    }

}

