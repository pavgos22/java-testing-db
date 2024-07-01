package com.patterns.factory.tasks;

public class TaskFactory {
    public enum TaskType {
        SHOPPING,
        PAINTING,
        DRIVING
    }

    public Task makeTask(TaskType taskType, String taskName, String parameter1, String parameter2) {
        switch (taskType) {
            case SHOPPING:
                double quantity = Double.parseDouble(parameter2);
                return new ShoppingTask(taskName, parameter1, quantity);
            case PAINTING:
                return new PaintingTask(taskName, parameter1, parameter2);
            case DRIVING:
                return new DrivingTask(taskName, parameter1, parameter2);
            default:
                return null;
        }
    }
}

