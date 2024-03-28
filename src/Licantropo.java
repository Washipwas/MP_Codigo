/**
 * 
 */
public class Licantropo extends Personaje {

    private int rabia;
    private Don don;
    public Licantropo(String nombre, int salud, int poder) {
        super(nombre, poder , salud);
        this.rabia = 0;
        don = new Don("Don",3, 1);

    }



}