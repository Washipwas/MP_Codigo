import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuUsuarioTest {

    @Test
    void mostrarMenu() {

        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Manager manager = new Manager();
        Manager manager1 = new Manager();
        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Gabi","Gabi123","Gabi123123");
        Operador operador = new Operador("Paquillo","Pacus","Paco3333");

        manager.aniadir(usuarioEstandar,"Ficheros/");
        manager.aniadir(operador,"Ficheros/" );

        MenuUsuarioEstandar menuUsuarioEstandar = new MenuUsuarioEstandar("Gabi12",manager);
        MenuOperador menuOperador = new MenuOperador("Pacus",manager1);

        assertEquals(false,menuUsuarioEstandar.mostrarMenu());

       // assertEquals();




    }

    @Test
    void seleccionarOpcion() {

        //le hacen override las clases hijas
    }

    @Test
    void darmeBaja() {
        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Redirigir la entrada estándar para simular la entrada del usuario
        ByteArrayInputStream in = new ByteArrayInputStream("@\n".getBytes());
        System.setIn(in);

        // Crear un nuevo Manager para la prueba
        Manager manager = new Manager();

        // Crear un nuevo MenuUsuarioEstandar para la prueba
        MenuUsuarioEstandar menuUsuarioEstandar = new MenuUsuarioEstandar("usuarioPrueba", manager);

        // Verificar que la salida esperada sea correcta
        assertEquals( false,menuUsuarioEstandar.darmeBaja());
    }


    @Test
    void comprobarDesafio() {

        //lo implementan las clases hijas
    }
}