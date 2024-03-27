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
        crearDebilidades();
        crearFortalezas();
    }

    @Override
    public int sumarPotencialAtaque() {
        int valor = super.getPoder() + talento.getValorAtaque() + this.voluntad + getValorAtaqueArmaActiva();
        return valor;
    }
    private void crearDebilidades(){
        Debilidad debilidad1 = new Debilidad("Dependencia emocional", 3);
        getDebilidades().put(debilidad1.getNombre(), debilidad1);
        Debilidad debilidad2 = new Debilidad("Sirenas", 4);
        getDebilidades().put(debilidad2.getNombre(), debilidad2);

    }

    private void crearFortalezas(){
        Fortaleza fortaleza1 = new Fortaleza("Valentia", 5);
        getDebilidades().put(fortaleza1.getNombre(), fortaleza1);
        Fortaleza fortaleza2 = new Fortaleza("Conocimiento", 3);
        getDebilidades().put(fortaleza2.getNombre(), fortaleza2);
    }




}