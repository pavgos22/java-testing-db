package com.functional.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String s, PoemDecorator decorator) {
        System.out.println(decorator.decorate(s));
    }
}
