package com.app.mytextprocessor;

public class Main {
    public static void main(String[] args) {

        String originalString = "Hello";
        String multiLineString = "Line 1\nLine 2\nLine 3";

        // String repetition
        String repeatedString = TextProcessor.repeatString(originalString, 3);
        System.out.println("Repeated String: " + repeatedString);

        // Checking if a string is blank
        String blankString = "   ";
        System.out.println("Is Blank String: " + TextProcessor.isStringBlank(blankString));

        // Extracting lines from a multi-line string
        System.out.println("Lines from Multi-line String:");
        TextProcessor.extractLines(multiLineString);

        // String formatting
        String formattedString = TextProcessor.formatString("Hello %s", "World");
        System.out.println("Formatted String: " + formattedString);

        // String transformation
        String transformedString = TextProcessor.transformString(originalString, String::toUpperCase);
        System.out.println("Transformed String: " + transformedString);

        // String indentation
        String indentedString = TextProcessor.indentString(multiLineString, 2);
        System.out.println("Indented String:\n" + indentedString);





    }
}