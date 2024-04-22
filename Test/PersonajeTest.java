import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    @Test
    void sumarPotencialAtaque() {
        // Arrange: Preparar los datos de prueba
        int poder = 10;
        int habilidad = 5;
        int fortaleza = 8;
        int debilidad = 3;

        Personaje personaje = new Personaje(poder, habilidad, fortaleza, debilidad);
        int resultado = personaje.sumarPotencialAtaque();
        int resultadoEsperado = poder + habilidad + fortaleza - debilidad;
        assertEquals(resultadoEsperado, resultado, "La suma del potencial de ataque no es la esperada");
    }

    @Test
    void sumarPotencialDefensa() {
    }

    @Test
    void editar() {
    }

    @Test
    void crearArmas() {
    }

    @Test
    void crearArmaduras() {
    }

    @Test
    void editarModificadores() {
    }

    @Test
    void aniadir() {
    }

    @Test
    void aniadirArmas() {
    }

    @Test
    void existeEquipo() {
    }

    @Test
    void manosSuficientes() {
    }

    @Test
    void existeEquipoArmadura() {
    }

    @Test
    void editarEquipo() {
    }

    @Test
    void editarEsbirros() {
    }

    @Test
    void editarHabilidad() {
    }

    @Test
    void hayHabilidad() {
    }
}