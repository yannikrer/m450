import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main_runsThroughAllMenuOptions() {
        String simulatedInput = String.join(System.lineSeparator(),
                "1", "TestTodo",
                "3", "1",
                "2",
                "4"
        ) + System.lineSeparator();

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);

        System.setIn(in);
        System.setOut(printStream);

        Main.main(new String[]{});

        System.setIn(originalIn);
        System.setOut(originalOut);

        String result = outContent.toString();

        assertTrue(result.contains("==== TODO APP ===="), "Titel fehlt");
        assertTrue(result.toLowerCase().contains("todo hinzugefügt"), "Hinzufügen-Ausgabe fehlt");
        assertTrue(result.toLowerCase().contains("aktuelle todos"), "Listen-Ausgabe fehlt");

        assertTrue(
                result.contains("erledigt=true") ||
                        result.contains("wurde als erledigt markiert"),
                "Markierung fehlt"
        );

        assertTrue(result.matches("(?s).*Beende Programm\\.*.*"), "Beende-Text fehlt");
    }

    @Test
    void main_handlesInvalidInputGracefully() {
        String simulatedInput = String.join(System.lineSeparator(),
                "x",
                "4"
        ) + System.lineSeparator();

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);

        System.setIn(in);
        System.setOut(printStream);

        Main.main(new String[]{});

        System.setIn(originalIn);
        System.setOut(originalOut);

        String result = outContent.toString();
        assertTrue(result.toLowerCase().contains("ungültige eingabe"), "Fehlerausgabe fehlt");
    }
}
