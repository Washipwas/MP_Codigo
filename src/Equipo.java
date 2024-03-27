/**
 * 
 */
public abstract class Equipo{

    /**
     * Default constructor
     */


    public Equipo(String nombre, int modificadorAtaque, int modificadorDefensa) {
        this.nombre = nombre;
        this.modificadorDeAtaque =  modificadorAtaque;
        this.modificadorDeDefensa =  modificadorDefensa;
    }

    private String nombre;


    public int getModificadorDeAtaque() {
        return modificadorDeAtaque;
    }

    public int getModificadorDeDefensa() {
        return modificadorDeDefensa;
    }

    private int modificadorDeAtaque;


    private int modificadorDeDefensa;


    public int generarPotencialAtaque() {
        // TODO implement here
        return 0;
    }


    public int generarPotencialDefensa() {
        // TODO implement here
        return 0;
    }

    public String getId() {
        return this.nombre;
    }
}