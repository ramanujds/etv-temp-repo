package com.app.mytextprocessor;

import java.util.function.Function;

public class TextProcessor {

    // Functionality: String repetition
    public static String repeatString(String str, int count) {
        // Todo: Implement string repetition using String::repeat(int count)
        return str.repeat(count);
    }

    // Functionality: Checking if a string is blank
    public static boolean isStringBlank(String str) {
        // Todo: Implement checking if a string is blank using String::isBlank()
        return str.isBlank();
    }

    // Functionality: Extracting lines from a multi-line string
    public static void extractLines(String multiLineStr) {
        // Todo: Implement extracting lines from a multi-line string using String::lines()
       multiLineStr.lines().forEach(System.out::println);
    }

    // Functionality: String formatting
    public static String formatString(String format, Object... args) {
        // Todo: Implement string formatting using String::format(String format, Object... args)
        return format.formatted(args);
    }

    // Functionality: String transformation
    public static String transformString(String str, Function<? super String, ? extends String> f) {
        // Todo: Implement string transformation using String::transform(Function<? super String, ? extends String> f)
        return str.transform(f);
    }

    // Functionality: String indentation
    public static String indentString(String str, int n) {
        // Todo: Implement string indentation using String::indent(int n)
        return str.indent(n).transform(s->s.substring(0,s.length()-1));
    }

    // Todo: Add error handling for edge cases such as null inputs

    // Todo: Add more advanced functionalities utilizing other features of the Java String API

    // Todo: Expand the application to handle file I/O for processing text files
}

