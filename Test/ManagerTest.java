import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void aniadirPersonajes(){



    }

    @Test
    void aniadir() {

        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        UsuarioEstandar usuarioEstandar = new UsuarioEstandar("Alex", "Alex123", "Alex123123");


        Manager manager = new Manager();

        manager.aniadir(usuarioEstandar, "ficheros/");

        assertEquals(true, manager.existe("Alex123", 1));

    }

    @Test
    void eliminar() {
    }

    @Test
    void existe() {

        //hace lo mismo que añadir

    }

    @Test
    void mostrar() {
    }

    @Test
    void mostrarUsuariosBloqueados() {

    }

    @Test
    void mostrarUsuariosNoNormas() {
    }

    @Test
    void bloquear_desbloquear() {
    }

    @Test
    void mostrarRegistro() {
    }










}