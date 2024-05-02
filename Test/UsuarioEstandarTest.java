import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioEstandarTest {
    @Test
    void UsuarioEstandar(){
        UsuarioEstandar usuario = new UsuarioEstandar(null, null, "password");
        assertEquals("gabi", usuario.getNick());
    }
    @Test
    void generarNumeroDeRegistro() {
        String contenidoArchivo = "0 A";
        InputStream in = new ByteArrayInputStream(contenidoArchivo.getBytes());
        System.setIn(in);

        // Creamos una instancia de UsuarioEstandar
        UsuarioEstandar usuario = new UsuarioEstandar("nombre", "nick", "password");
        UsuarioEstandar usuario2 = new UsuarioEstandar("pedro", "juan", "password");
        // Ejecutamos el método generarNumeroDeRegistro()
        String numeroRegistro = usuario.generarNumeroDeRegistro();
        String numeroRegistro2 = usuario2.generarNumeroDeRegistro();

        // Verificamos si el número de registro generado es el esperado
        assertNotEquals(numeroRegistro,numeroRegistro2);
    }
}