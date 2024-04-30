import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


class MenuInicialTest {


    @Test
     void iniciarsesionCorrecto() {

        // Configurar la entrada simulada
        ByteArrayInputStream in = new ByteArrayInputStream("gabi\ngabi123123\n".getBytes());
        System.setIn(in);

        // Ejecutar
        MenuInicial menu = new MenuInicial();
        menu.iniciarSesion();
        // Capturar la salida de la consola
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        // Verificar resultado
        assertEquals(UtilConstants.ANSI_GREEN + "Acceso correcto" + UtilConstants.ANSI_RESET, outContent.toString().trim());

        // Restaurar la entrada y salida estándar
        System.setOut(System.out);
        System.setIn(System.in);
        }



    @Test
    public void testMenuInicial_LeeArchivoUsuariosSiExiste() {
        // Ruta del archivo de usuarios
        String rutaArchivo = UtilConstants.FILE_USERS + "usuarios.ser";

        // Crear un archivo de usuarios de prueba
        Manager manager = new Manager();
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            objetoSalida.writeObject(manager);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear una instancia de la clase bajo prueba (MenuInicial)
        MenuInicial menuInicial = new MenuInicial();

        // Verificar que se lee el archivo de usuarios
        assertNotNull(menuInicial.getManager());
    }

    @Test
    void iniciarSesion() {}




   @Test
    void registrar() {
    }

    @Test
    void seleccionarOpcion() {
    }
}
