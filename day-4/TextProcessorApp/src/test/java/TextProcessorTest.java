import com.app.mytextprocessor.TextProcessor;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    // Test case for String repetition
    @Test
    public void testRepeatString() {
        assertEquals("aaaaa", TextProcessor.repeatString("a", 5));
        assertEquals("", TextProcessor.repeatString("abc", 0));
    }

    // Test case for Checking if a string is blank
    @Test
    public void testIsStringBlank() {
        assertTrue(TextProcessor.isStringBlank(""));
        assertTrue(TextProcessor.isStringBlank("   "));
        assertFalse(TextProcessor.isStringBlank("abc"));
    }

    // Test case for Extracting lines from a multi-line string
    @Test
    public void testExtractLines() {
        String multiLineStr = "Line 1\nLine 2\nLine 3";
        // Redirect System.out to a String
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Call the method
        TextProcessor.extractLines(multiLineStr);
        // Check output
        assertEquals("Line 1\nLine 2\nLine 3\n", outputStream.toString());
    }

    // Test case for String formatting
    @Test
    public void testFormatString() {
        assertEquals("Hello World", TextProcessor.formatString("Hello %s", "World"));
    }

    // Test case for String transformation
    @Test
    public void testTransformString() {
        assertEquals("HELLO", TextProcessor.transformString("hello", String::toUpperCase));
    }

    // Test case for String indentation
    @Test
    public void testIndentString() {
        assertEquals("  Hello\n    World", TextProcessor.indentString("Hello\nWorld", 2));
    }
}

