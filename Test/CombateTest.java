import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CombateTest {

    @Test
    void hayGanador() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);

        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,2);

        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,2);

        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);

        personajeuser1.setArmadura(armaduraaux); //licantropo1

        UsuarioEstandar usuarioestandar1=new UsuarioEstandar("Juan","danger","pedrito12");
        usuarioestandar1.setPersonajeUserFinal(personajeuser1);

        TextTerminal terminal2 = new TextTerminal();
        Licantropo licantropo2 = new Licantropo("Destroyer",3,2,1,terminal2);

        PersonajeUser personajeuser2=new PersonajeUser(licantropo2);
        Arma armaaux3=new Arma("DestrozaNoobs",1,1,1,1);

       // personajeuser1.setArmaIzq(armaaux3);
        Arma armaaux2=new Arma("Destrozadioses",1,1,1,1);

        personajeuser1.setArmaDer(armaaux2);
        Armadura armaduraaux3=new Armadura("ProtectorDeDioses",1,3,3);

        personajeuser2.setArmadura(armaduraaux3);

        UsuarioEstandar usuarioEstandar2= new UsuarioEstandar("Sebas","Silver","sebastian123");
        usuarioEstandar2.setPersonajeUserFinal(personajeuser2);

        //tenemos a los 2 personajes con los 2 usuarios

        Combate combat=new Combate(usuarioestandar1,usuarioEstandar2,200,"DangerSilv");


        ByteArrayInputStream in = new ByteArrayInputStream("Si\nSi\n2".getBytes());
        System.setIn(in);
        combat.asociarHabilidades();

        System.out.println(combat.getGanador());
        //System.out.println(combat.getGanador());
    }

    @Test
    void calcularPotencialAtaque() {

    }

    @Test
    void generPotencial() {
    }

    @Test
    void calcularPotencialDef() {
    }

    @Test
    void asociarDesafio() {
    }

    @Test
    void empezar() {
    }

    @Test
    void mostrarResumen() {
    }

    @Test
    void combateCancelar() {
    }

    @Test
    void asociarHabilidades() {
    }

    @Test
    void combateCancelarPorciento() {
    }
}