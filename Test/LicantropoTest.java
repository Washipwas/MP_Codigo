import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LicantropoTest {

    @Test
    public void testConstructor() {
        TextTerminal terminal = new TextTerminal();
        // Crear un licantropo para probar
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        // Verificar que los valores se inicialicen correctamente
        assertEquals("Siervo de la luna", licantropo.getNombre());
        assertEquals(3, licantropo.getPoder());
        assertEquals(2, licantropo.getSalud());
        assertEquals(3, licantropo.getRabia());
    }

    @Test
    void crearHabilidadEspecial(){
        TextTerminal terminal = new TextTerminal();
        Don don =  new Don("Aullido", 2,1,2);
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        assertEquals(don.getNombre(),licantropo.getHabilidad().getNombre());
    }

    @Test
    void sumarPotencialAtaque() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        Don don =  new Don("Aullido", 2,1,2);
        licantropo.setHabilidad(don);
        Fortaleza fortaleza1 = new Fortaleza("Sentidos Agudizados", 2);
        licantropo.setFortalezaActiva(fortaleza1);
        int valor = licantropo.sumarPotencialAtaque();
        assertEquals(10, valor);
    }

    @Test
    void sumarPotencialDefensa() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        Don don =  new Don("Aullido", 2,1,2);
        licantropo.setHabilidad(don);
        Debilidad debilidad1 =  new Debilidad("Agua Bendita", 3);
        licantropo.setDebilidadActiva(debilidad1);
        int valor = licantropo.sumarPotencialDefensa();
        assertEquals(5, valor);
    }

    @Test
    void crearArmas() {
        Arma arma1 = new Arma("Catana",2,2, 2, 0);
        Arma arma2 = null;
        Arma arma3 = new Arma("Pump", 1,1, 3, 0);
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        assertEquals(false,licantropo.getArmas().containsKey(arma3.getId()));
    }

    @Test
    void crearArmaduras() {
        Armadura armadura1 = new Armadura("Armadura de papel",2,0, 1);
        Armadura armadura2 = null;
        Armadura armadura3 = new Armadura("Armadura de dioses",1, 1, 3);
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        assertEquals(false,licantropo.getArmaduras().containsKey(armadura3.getId()));
    }

    @Test
    void crearDebilidades() {
        Debilidad debilidad1 = new Debilidad("Agua Bendita", 3);
        Debilidad debilidad2 = null;
        Debilidad debilidad3 = new Debilidad("Dependencia emocional", 3);
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        assertEquals(false,licantropo.getDebilidades().containsKey(debilidad3.getNombre()));
    }

    @Test
    void crearFortalezas() {
        Fortaleza fortaleza1 = new Fortaleza("Sentidos Agudizados", 2);
        Fortaleza fortaleza2 = null;
        Fortaleza fortaleza3 = new Fortaleza("Conocimiento", 3);
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        assertEquals(true,licantropo.getFortalezas().containsKey(fortaleza1.getNombre()));
    }

    @Test
    void mostrarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        licantropo.mostrarAtributosExtras();
        String expectedOutput = "Rabia: " + 3;

        String actualOutput = outContent.toString().trim(); // Elimina espacios en blanco al inicio y al final

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void editarAtributosExtras() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo = new Licantropo("Siervo de la luna",2,3,3,terminal);
        ByteArrayInputStream in = new ByteArrayInputStream("Si\n2".getBytes());
        System.setIn(in);

        licantropo.editarAtributosExtras();

        assertEquals(2, licantropo.getRabia());
    }
}