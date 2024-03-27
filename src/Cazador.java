/**
 * 
 */
public class Cazador extends Personaje {

    /**
     * Default constructor
     */
    private int voluntad;
    private Talento talento;

    public Cazador(String nombre, int salud, int poder,int puntoSangre,int edad, Talento talento) {
        super(nombre,poder,salud);
        this.voluntad = 3;
        this.talento = talento;
    }

    @Override
    public int sumarPotencialAtaque() {
        int valor = talento.getValorAtaque() + this.voluntad;
        return super.sumarPotencialAtaque();
    }


}