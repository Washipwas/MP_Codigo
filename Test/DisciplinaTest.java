import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {

    @Test
    public void testConstructor() {
        Disciplina disciplina =  new Disciplina("Oscuridad total", 1,3,2);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Oscuridad total",disciplina.getNombre());
        assertEquals(1,disciplina.getValorAtaque());
        assertEquals(3,disciplina.getValorDefensa());
        assertEquals(2,disciplina.getCoste());
    }

    @Test
    void mostrarHabilidadExtra() {
        Disciplina disciplina =  new Disciplina("Oscuridad total", 1,3,2);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        disciplina.mostrarHabilidadExtra();
        String expectedOutput = "Coste: " + 2;

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void editarExtra() {
        Disciplina disciplina =  new Disciplina("Oscuridad total", 1,3,2);

        ByteArrayInputStream in = new ByteArrayInputStream("Si\n3".getBytes());
        System.setIn(in);

        disciplina.editarExtra();


        // Verificar que los valores se inicialicen correctamente
        assertEquals(3,disciplina.getCoste());
    }
}