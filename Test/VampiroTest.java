import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class VampiroTest {


    @Test
    public void testConstructor() {
        TextTerminal terminal = new TextTerminal();

        // Crear un vampiro para probar
        Vampiro vampiro = new Vampiro("Drácula",2,4,6,1000,terminal);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Drácula", vampiro.getNombre());
        assertEquals(4, vampiro.getPoder());
        assertEquals(2, vampiro.getSalud());
        assertEquals(6, vampiro.getPuntoSangre());
        assertEquals(1000, vampiro.getEdad());
    }

    @Test
    void crearHabilidadEspecial(){
        TextTerminal terminal = new TextTerminal();
        Disciplina disciplina =  new Disciplina("Oscuridad total", 1,3,2);
        Vampiro vampiro = new Vampiro("Drácula",2,4,6,1000,terminal);

        assertEquals(disciplina.getNombre(),vampiro.getHabilidad().getNombre());
    }

    @Test
    void sumarPotencialAtaque() {
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 6, 1000, terminal);
        Disciplina disciplina = new Disciplina("Oscuridad total", 1, 3, 2);
        vampiro.setHabilidad(disciplina); // Establecer la disciplina
        Fortaleza fortaleza1 = new Fortaleza("Inmortalidad", 5);
        vampiro.setFortalezaActiva(fortaleza1);
        int valor = vampiro.sumarPotencialAtaque();
        assertEquals(21, valor);
    }

    @Test
    void sumarPotencialDefensa() {
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 6, 1000, terminal);
        Disciplina disciplina = new Disciplina("Oscuridad total", 1, 3, 2);
        vampiro.setHabilidad(disciplina); // Establecer la disciplina
        Debilidad debilidad1 =  new Debilidad("Luz solar", 4);
        vampiro.setDebilidadActiva(debilidad1);
        int valor = vampiro.sumarPotencialDefensa();
        assertEquals(12, valor);
    }

    @Test
    void sumarPuntosSangre() {
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 1, 1000, terminal);
        vampiro.sumarPuntosSangre();
        assertEquals(5,vampiro.getPuntoSangre());
    }

    @Test
    void crearArmas() {
        Arma arma3 = new Arma("Catana",2,2, 2, 0);
        Arma arma2 = null;
        Arma arma1 = new Arma("Pump", 1,1, 3, 0);
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 1, 1000, terminal);
        assertEquals(false,vampiro.getArmas().containsKey(arma3.getId()));
    }

    @Test
    void crearArmaduras() {
        Armadura armadura2 = new Armadura("Armadura de papel",2,0, 1);
        Armadura armadura3 = null;
        Armadura armadura1 = new Armadura("Armadura de dioses",1, 1, 3);
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 1, 1000, terminal);
        assertEquals(false,vampiro.getArmaduras().containsKey(armadura2.getId()));
    }

    @Test
    void crearDebilidades() {
        Debilidad debilidad3 = new Debilidad("Agua Bendita", 3);
        Debilidad debilidad2 = null;
        Debilidad debilidad1 = new Debilidad("Luz solar", 4);
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 1, 1000, terminal);
        assertEquals(false,vampiro.getDebilidades().containsKey(debilidad3.getNombre()));
    }

    @Test
    void crearFortalezas() {
        Fortaleza fortaleza3 = new Fortaleza("Sentidos Agudizados", 2);
        Fortaleza fortaleza2 = null;
        Fortaleza fortaleza1 = new Fortaleza("Inmortalidad", 5);
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula", 2, 4, 1, 1000, terminal);
        assertEquals(true,vampiro.getFortalezas().containsKey(fortaleza1.getNombre()));
    }

    @Test
    void mostrarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula",4,2,6,1000,terminal);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        vampiro.mostrarAtributosExtras();
        String expectedOutput = "Puntos de sangre: " + 6 + "    " + "Edad: " + 1000;

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void editarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        Vampiro vampiro = new Vampiro("Drácula",4,2,6,1000,terminal);
        ByteArrayInputStream in = new ByteArrayInputStream("No\nNo".getBytes());
        System.setIn(in);

        vampiro.editarAtributosExtras();

        assertEquals(6,vampiro.getPuntoSangre());
        assertEquals(1000, vampiro.getEdad());
    }
}