import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ArmaduraTest {

    @Test
    void Armadura(){
        Armadura armadura = new Armadura("Armadura", -1, 1, -4); // Supongamos que tienes un atributo 'manos'
        assertEquals(1, armadura.getModificadorDeAtaque());
        assertEquals(4, armadura.getModificadorDeDefensa());
        assertEquals("Armadura de prueba", armadura.getId());


    }
    @Test
    void mostrar(){
        Armadura armadura = new Armadura(null, 1, 1, 4); // Supongamos que tienes un atributo 'manos'
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        armadura.mostrar();

        //String expectedOutput = "* Nombre: Armadura de prueba    Modificador de Ataque: 1    Modificador de Defensa: 4\n";
        //assertEquals(expectedOutput, outContent.toString());
        assertEquals(null, armadura.getId());

    }
    @Test
    void editar() {
        Armadura armadura = new Armadura("Armadura vieja", 1, 2, 3);
        // Redirigir la entrada estándar para simular la entrada del usuario
        ByteArrayInputStream in = new ByteArrayInputStream("si\nNuevo Nombre\nSi\n8\nSi\n1".getBytes());
        System.setIn(in);

        armadura.editar();

        assertEquals("Nuevo Nombre", armadura.getId());
        assertEquals(3, armadura.getModificadorDeAtaque());
        assertEquals(1, armadura.getModificadorDeDefensa());
    }
}