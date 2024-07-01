package com.spring.javaspring.library;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public final class Library {

    private final List<String> books = new ArrayList<>();

    @Autowired
    private LibraryDbController libraryDbController;

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}