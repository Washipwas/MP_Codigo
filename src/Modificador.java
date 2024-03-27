/**
 * 
 */
public abstract class Modificador {


    public Modificador(String nombre, int valor) {

        this.nombre = nombre;
        this.valor = valor;
    }


    public String getNombre(){
        return this.nombre;
    }

    public int getValor() {
        return this.valor;
    }


    private String nombre;

    /**
     *
     */
    private int valor;

}



    // generar potencial ataque y defensa no deberian de ir aquí
    /**
    public int generarPotencialAtaque() {
        // TODO implement here
        return 0;
    }


     *

    public int generarPotencialDefensa() {
        // TODO implement here
        return 0;
    }
     */

}
