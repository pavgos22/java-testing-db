package com.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShoppingTask() {
        TaskFactory factory = new TaskFactory();

        Task shopping = factory.makeTask(TaskFactory.TaskType.SHOPPING, "Buy milk", "milk", "2");

        assertNotNull(shopping);
        assertEquals("Buy milk", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());
        shopping.executeTask();
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        TaskFactory factory = new TaskFactory();

        Task painting = factory.makeTask(TaskFactory.TaskType.PAINTING, "Paint bedroom", "blue", "0");

        assertNotNull(painting);
        assertEquals("Paint bedroom", painting.getTaskName());
        assertFalse(painting.isTaskExecuted());
        painting.executeTask();
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask() {
        TaskFactory factory = new TaskFactory();

        Task driving = factory.makeTask(TaskFactory.TaskType.DRIVING, "Drive to work", "office", "car");

        assertNotNull(driving);
        assertEquals("Drive to work", driving.getTaskName());
        assertFalse(driving.isTaskExecuted());
        driving.executeTask();
        assertTrue(driving.isTaskExecuted());
    }
}
