package com.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {

    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());
        Path path = Paths.get("tego-pliku-nie-ma.txt");

        try {
            Stream<String> fileLines = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        }

        System.out.println(file.getPath());
    }
}