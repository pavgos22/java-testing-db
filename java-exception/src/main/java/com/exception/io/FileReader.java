package com.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("names.txt").getFile());
        Path path = Paths.get("tego-pliku-nie-ma.txt");

        try {
            Stream<String> fileLines = Files.lines(path);
        } catch (IOException e) {
            throw new FileReaderException();
        }
        finally {
            System.out.println("finally");
        }

        System.out.println(file.getPath());
    }
}