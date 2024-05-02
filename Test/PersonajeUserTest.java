import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeUserTest {

    @Test
    void sumarPotencialAtaque() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,0,2);
        personajeuser1.setArmaIzq(armaaux);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,5,3);
        personajeuser1.setArmadura(armaduraaux);
        //ya tiene tanto armadura como arma
        //Debilidad debilidad1= new Debilidad("DebilidaLeve",2);
       // Fortaleza fortaleza1=new Fortaleza("FortalezaNasty",4);

       System.out.println( personajeuser1.sumarPotencialAtaque()); // es la suma de su poder con la de sus debilidades y fortalezas
//el primer elemento esta mal porque no hay ni debilidades ni fortalezas= solo da el poder =3
        //2
        ///1

    }

    @Test
    void sumarPotencialDefensa() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        System.out.println(personajeuser1.sumarPotencialDefensa());
    }

    @Test
    void estaVivo() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        System.out.println(licantropo1.getSalud());
        System.out.println(personajeuser1.getPersonaje().getSalud());
    }

    @Test
    void oroSufiencte() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        System.out.println(personajeuser1.oroSufiencte(-700));
    }

    @Test
    void mostrarArmas() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        personajeuser1.mostrarArmas();
    }

    @Test
    void mostrarArmadura() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        personajeuser1.mostrarArmadura();
    }

    @Test
    void notieneArmadura() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        System.out.println(personajeuser1.notieneArmadura());
    }

    @Test
    void mostrarTodasArmas() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        personajeuser1.mostrarTodasArmas();
    }

    @Test
    void existeEquipo() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        System.out.println(personajeuser1.existeEquipo(null));
    }

    @Test
    void manosSuficientes() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        System.out.println(personajeuser1.manosSuficientes("Catana"));
    }

    @Test
    void mostrarTodasArmaduras() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        personajeuser1.mostrarTodasArmaduras();
    }

    @Test
    void existeEquipoArmadura() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        System.out.println(personajeuser1.existeEquipoArmadura(null));
    }

    @Test
    void restarVida() {

        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        personajeuser1.restarVida();
        System.out.println(personajeuser1.getPersonaje().getSalud());
        System.out.println(personajeuser1.getVida());
    }

    @Test
    void sumarOro() {
        TextTerminal terminal = new TextTerminal();
        Licantropo licantropo1 = new Licantropo("titan",5,3,2,terminal);
        PersonajeUser personajeuser1=new PersonajeUser(licantropo1);
        Arma armaaux=new Arma("DestrozaNoobs",1,1,1,0);
        personajeuser1.setArmaIzq(armaaux);
        Arma armaaux1=new Arma("Destrozadioses",1,1,1,0);
        personajeuser1.setArmaDer(armaaux1);
        Armadura armaduraaux=new Armadura("ProtectorDeDioses",1,3,4);
        personajeuser1.setArmadura(armaduraaux);
        personajeuser1.sumarOro(100);
        System.out.println(personajeuser1.getOro());
    }
}