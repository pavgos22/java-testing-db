package com.spring.hibernate.tasklist.dao;

import com.spring.hibernate.tasklist.TaskList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskListDao extends CrudRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);
}