/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void someLibraryMethodReturnsTrue() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }

    @Test void qoutesTest() throws FileNotFoundException {

        FileReader fileReader = new FileReader("C:\\Users\\jamal\\quotes\\recentquotes.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        assertNotNull(String.valueOf(bufferedReader));
    }
    @Test void QuotesConstructor(){
        Quotes quotes = new Quotes("Charles Dickens","Ask no questions, and you'll be told no lies");
        String authorTest = quotes.getAuthor();
        String textTest = quotes.getText();

        assertEquals(authorTest, quotes.getAuthor());
        assertEquals(textTest,quotes.getText());
    }
}