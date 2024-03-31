import java.io.Serializable;

/**
 * 
 */
public class PersonajeUser implements Serializable {

    private Personaje personaje;
    private int oro;
    private int salud;
    private Arma armaIzq;
    private Arma armaDer;
    private Armadura armadura;

    private boolean cuentaAtras;
    public PersonajeUser(Personaje personaje) {
        this.personaje = personaje;
        this.oro = 500;
        this.armaDer = null;
        this.armaIzq = null;
        this.armadura = null;
    }

    public int sumarPotencialAtaque() {
        // TODO implement here
        return 0;
    }

    public int sumarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

    public boolean estaVivo() {
        // TODO implement here
        return false;
    }
    public boolean oroSufiencte(int dinero) {
        return dinero <= this.oro;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Personaje getPersonaje() {
        return this.personaje;
    }


    public void setArmaIzq(Arma arma) {
        this.armaIzq = arma;
    }

    public void setArmaDer(Arma arma) {
        this.armaDer = arma;
    }

    public int getManosLibres() {
        if (armaIzq == null){
            return 2;
        } else if (armaDer == null){
            return 2 - armaIzq.getManos();
        } else{
            return 0;
        }
    }

    public void mostrarArmas() {
        boolean bool = false;
        if (armaIzq != null){
            if (armaIzq.getManos() == 1){
                System.out.println("Mano izquierda: " + armaIzq.getId());
            } else{
                System.out.println("Ambas manos: " + armaIzq.getId());
                bool = true;
            }
        } else {
            System.out.println("Mano izquierda: Vacía");
        }
        if (!bool){
            if (armaDer != null){
                System.out.println("Mano derecha: " + armaIzq.getId());
            } else {
                System.out.println("Mano derecha: Vacía");
            }
        }

    }

    public void mostrarArmadura() {
        if (armadura == null){
            System.out.println("Armadura: Vacía");
        } else {
            System.out.println("Armadura: " + armadura.getId());
        }
    }

    public boolean notieneArmadura() {
        return this.armadura == null;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public void mostrarTodasArmas() {
        this.personaje.mostrarTodasArmas();
    }

    public Object getArma(String opcion) {
        return this.personaje.getArma(opcion);
    }

    public boolean existeEquipo(String opcion) {
        return this.personaje.existeEquipo(opcion);
    }

    public int manosSuficientes(String opcion) {
        return  personaje.manosSuficientes(opcion);
    }

    public void mostrarTodasArmaduras() {
        this.personaje.mostrarTodasArmaduras();
    }

    public boolean existeEquipoArmadura(String opcion) {
        return this.personaje.existeEquipoArmadura(opcion);
    }

    public Object getArmadura(String opcion) {
        return this.personaje.getAmadura(opcion);
    }
}