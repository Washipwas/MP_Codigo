import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CazadorTest {


    @Test
    public void testConstructor() {
        TextTerminal terminal = new TextTerminal();
        // Crear un caz para probar
        Cazador caz = new Cazador("Mortis",2,3,3,terminal);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Mortis", caz.getNombre());
        assertEquals(3, caz.getPoder());
        assertEquals(2, caz.getSalud());
        assertEquals(3, caz.getVoluntad());
    }

    @Test
    void crearHabilidadEspecial(){
        TextTerminal terminal = new TextTerminal();
        Talento talento =  new Talento("Precisión", 3,1);
        Cazador caz = new Cazador("Mortis",3,3,3,terminal);
        assertEquals(talento.getNombre(),caz.getHabilidad().getNombre());
    }

    @Test
    void sumarPotencialAtaque() {
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",2,3,3,terminal);
        Talento talento =  new Talento("Precisión", 3,1);
        caz.setHabilidad(talento); // Establecer la disciplina
        Fortaleza fortaleza1 = new Fortaleza("Valentia", 5);
        caz.setFortalezaActiva(fortaleza1);
        int valor = caz.sumarPotencialAtaque();
        assertEquals(14, valor);
    }

    @Test
    void sumarPotencialDefensa() {
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",2,3,3,terminal);
        Talento talento =  new Talento("Precisión", 3,1);
        caz.setHabilidad(talento); // Establecer la disciplina
        Debilidad debilidad1 =  new Debilidad("Dependencia emocional", 3);
        caz.setDebilidadActiva(debilidad1);
        int valor = caz.sumarPotencialDefensa();
        assertEquals(4, valor);
    }

    @Test
    void crearArmas() {
        Arma arma3 = new Arma("Catana",2,2, 2, 0);
        Arma arma2 = null;
        Arma arma1 = new Arma("Pump", 1,1, 3, 0);
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",3,3,3,terminal);
        assertEquals(false,caz.getArmas().containsKey(arma3.getId()));
    }

    @Test
    void crearArmaduras() {
        Armadura armadura2 = new Armadura("Armadura de papel",2,0, 1);
        Armadura armadura3 = null;
        Armadura armadura1 = new Armadura("Armadura de dioses",1, 1, 3);
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",3,3,3,terminal);
        assertEquals(false,caz.getArmaduras().containsKey(armadura2.getId()));
    }

    @Test
    void crearDebilidades() {
        Debilidad debilidad3 = new Debilidad("Agua Bendita", 3);
        Debilidad debilidad2 = null;
        Debilidad debilidad1 = new Debilidad("Dependencia emocional", 3);
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",3,3,3,terminal);
        assertEquals(false,caz.getDebilidades().containsKey(debilidad3.getNombre()));
    }

    @Test
    void crearFortalezas() {
        Fortaleza fortaleza3 = new Fortaleza("Sentidos Agudizados", 2);
        Fortaleza fortaleza2 = null;
        Fortaleza fortaleza1 = new Fortaleza("Conocimiento", 3);
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",3,3,3,terminal);
        assertEquals(true,caz.getFortalezas().containsKey(fortaleza1.getNombre()));
    }

    @Test
    void mostrarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        Cazador cazador = new Cazador("Mortis",2,3,3,terminal);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cazador.mostrarAtributosExtras();
        String expectedOutput = "Voluntad: " + 3;

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void editarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        Cazador caz = new Cazador("Mortis",3,3,3,terminal);
        ByteArrayInputStream in = new ByteArrayInputStream("Si\n2".getBytes());
        System.setIn(in);

        caz.editarAtributosExtras();

        assertEquals(2, caz.getVoluntad());
    }
}