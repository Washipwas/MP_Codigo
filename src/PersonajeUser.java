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
    public PersonajeUser(Personaje personaje) {
        this.personaje = personaje;
        this.oro = 500;
        this.armaDer = null;
        this.armaIzq = null;
        this.armadura = null;
    }

    public int sumarPotencialAtaque() {
        int auxpotencialpersonaje=this.personaje.sumarPotencialAtaque();
        int suma_armas=0;
        int suma_armadura=0;
        if (this.armaDer!=null){
                suma_armas+=this.armaDer.getModificadorDeAtaque();
        }
        else if(this.armaIzq!=null){
            suma_armas+=this.armaIzq.getModificadorDeAtaque();
        }
        if(this.armadura!=null){
            suma_armadura+=this.armadura.getModificadorDeAtaque();
        }
        return auxpotencialpersonaje+suma_armas+suma_armadura; /*retorna este valor a combate */
    }

    public int sumarPotencialDefensa() {
        int auxpotencialpersonaje=this.personaje.sumarPotencialDefensa();
        int suma_armas=0;
        int suma_armadura=0;
        if (this.armaDer!=null){
            suma_armas+=this.armaDer.generarPotencialDefensa();
        }
        else if(this.armaIzq!=null){
            suma_armas+=this.armaIzq.getModificadorDeDefensa();
        }
        if(this.armadura!=null){
            suma_armadura+=this.armadura.getModificadorDeDefensa();
        }
        return auxpotencialpersonaje+suma_armas+suma_armadura; /*retorna este valor a combate */
    }

    public boolean estaVivo() {
        return this.salud>0;
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
                System.out.println("Mano derecha: " + armaDer.getId());
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

    public void restarVida() {
        this.salud=this.salud-1;
    }

    public Object getArmaduraActiva() {
        return this.armadura;
    }

    public Object getArmaActiva() {
        return this.armaIzq;
    }

    public void setVida(int valorvida) {
        this.salud=valorvida;
    }

    public int getVida() {
        return salud;
    }

    public void sumarOro(int oroApostado) {
        this.oro+=oroApostado;
    }

    public int getOro() {
        return this.oro;
    }
}