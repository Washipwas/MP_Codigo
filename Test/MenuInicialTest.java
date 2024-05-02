import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


class MenuInicialTest {


    @Test
    void iniciarSesion() {

        //da muchos problemas



    }

    @Test
    void mostrarMenu(){

        // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        MenuInicial menuInicial = new MenuInicial();
        menuInicial.mostrarMenu();

        // Definir el resultado esperado
        String expectedOutput = UtilConstants.ANSI_BLUE + "Seleccione una opción escribiendo el número correspondiente" + UtilConstants.ANSI_RESET + System.lineSeparator() +
                "1.Iniciar sesion" + System.lineSeparator() +
                "2.Registrarse como Usuario" + System.lineSeparator() +
                "3.Registrarse como Operador" + System.lineSeparator() +
                "4.Salir" + System.lineSeparator();

        // Verificar si la salida capturada coincide con el resultado esperado
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }


   @Test
    void registrar() {





       // Preparar la entrada simulada del usuario
       ByteArrayInputStream inputStream = new ByteArrayInputStream("javierete\njavi123\njavi123123\nsi".getBytes());
       System.setIn(inputStream);

       // Redirigir la salida estándar para capturarla en un ByteArrayOutputStream
       ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outputStreamCaptor));

       MenuInicial menuInicial = new MenuInicial();
       // Llamar al método seleccionarOpcion()
       menuInicial.registrar(2);
       Manager manager = new Manager();

       // Verificar si la salida capturada coincide con el resultado esperado
       assertEquals(true, manager.existe("javi123",1));
    }

    @Test
    void seleccionarOpcion() {

        // Problemas pq no puedo verificar la salida


    }
}
