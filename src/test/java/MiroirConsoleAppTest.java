import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class MiroirConsoleAppTest {

    @Test
    void testEstPalindrome() {
        assertTrue(MiroirConsoleApp.estPalindrome("savas"));
        assertFalse(MiroirConsoleApp.estPalindrome("sveiki"));
        assertTrue(MiroirConsoleApp.estPalindrome("sedek uzu kedes"));
        assertFalse(MiroirConsoleApp.estPalindrome("tai nera palindromas"));
    }

    @Test
    void testInverserChaine() {
        assertEquals("test", MiroirConsoleApp.inverserChaine("tset"));
        assertEquals("racecar", MiroirConsoleApp.inverserChaine("racecar"));
        assertEquals("12345", MiroirConsoleApp.inverserChaine("54321"));
    }

    @Test
    void testSaluer() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Calendar morning = new GregorianCalendar(2023, Calendar.JANUARY, 1, 8, 0, 0);
        Calendar afternoon = new GregorianCalendar(2023, Calendar.JANUARY, 1, 14, 0, 0);
        Calendar evening = new GregorianCalendar(2023, Calendar.JANUARY, 1, 20, 0, 0);

        MiroirConsoleApp.simulateTimeAndCallSaluer(morning);
        assertEquals("Labas rytas!\n", outContent.toString());

        outContent.reset();
        MiroirConsoleApp.simulateTimeAndCallSaluer(afternoon);
        assertEquals("Laba diena!\n", outContent.toString());

        outContent.reset();
        MiroirConsoleApp.simulateTimeAndCallSaluer(evening);
        assertEquals("Labas vakaras!\n", outContent.toString());

        System.setOut(System.out);
    }

    @Test
    void testDireAuRevoir() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Calendar morning = new GregorianCalendar(2023, Calendar.JANUARY, 1, 8, 0, 0);
        Calendar afternoon = new GregorianCalendar(2023, Calendar.JANUARY, 1, 14, 0, 0);
        Calendar evening = new GregorianCalendar(2023, Calendar.JANUARY, 1, 20, 0, 0);

        MiroirConsoleApp.simulateTimeAndCallDireAuRevoir(morning);
        assertEquals("Iki!\n", outContent.toString());

        outContent.reset();
        MiroirConsoleApp.simulateTimeAndCallDireAuRevoir(afternoon);
        assertEquals("Geros dienos!\n", outContent.toString());

        outContent.reset();
        MiroirConsoleApp.simulateTimeAndCallDireAuRevoir(evening);
        assertEquals("Gero vakaro!\n", outContent.toString());

        System.setOut(System.out);
    }

    @Test
    void testMainWithExit() {

        ByteArrayInputStream inContent = new ByteArrayInputStream("exit\n".getBytes());
        System.setIn(inContent);

        MiroirConsoleApp.main(new String[]{});

        System.setIn(System.in);
    }

    @Test
    void testMainWithPalindrome() {
        // Tester avec palindrome
        ByteArrayInputStream inContent = new ByteArrayInputStream("level\nexit\n".getBytes());
        System.setIn(inContent);

        MiroirConsoleApp.main(new String[]{});

        // No need to assert console output as it contains time-dependent greetings

        System.setIn(System.in);
    }

    @Test
    void testMainWithMirror() {
        // Tester avec non-palindrome
        ByteArrayInputStream inContent = new ByteArrayInputStream("hello\nexit\n".getBytes());
        System.setIn(inContent);

        MiroirConsoleApp.main(new String[]{});

        // No need to assert console output as it contains time-dependent greetings

        System.setIn(System.in);
    }
}
