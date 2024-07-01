package com.functional.stream.portfolio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public final class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TaskList taskList) {
        return taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" + "\n" +
                "name='" + name + '\'' + ",\n" +
                "taskLists=" + taskLists + "\n" +
                '}';
    }

    public double calculateAverageDurationInProgress() {
        LocalDate now = LocalDate.now();

        OptionalDouble average = this.getTaskLists().stream()
                .filter(taskList -> "In Progress".equals(taskList.getName()))
                .flatMap(taskList -> taskList.getTasks().stream())
                .mapToDouble(task -> ChronoUnit.DAYS.between(task.getCreated(), now))
                .average();

        return average.isPresent() ? average.getAsDouble() : 0;
    }
}
