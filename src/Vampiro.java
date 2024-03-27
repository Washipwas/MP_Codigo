/**
 * 
 */
public class Vampiro extends Personaje {


    public Vampiro(String nombre, int salud, int poder,int puntoSangre,int edad) {
        super(nombre,poder,salud);
        this.puntoSangre = puntoSangre;
        this.edad = edad;
        this.disciplina = disciplina;
        crearDebilidades();
        crearFortalezas();

    }


    public int sumarPotencialAtaque() {
        int potencial;
        int sangre = getPuntoSangre();
        potencial = sangre + disciplina.getValorAtaque() + super.getPoder();
        if (sangre > 5){
            potencial+= 2;
        }
        return potencial;
    }

    public int getPuntoSangre() {
        return this.puntoSangre;
    }

    public void crearDebilidades(){
        Debilidad debilidad1 =  new Debilidad("Luz solar", 4);
        getDebilidades().put(debilidad1.getNombre(),debilidad1);
        Debilidad debilidad2 =  new Debilidad("Lluvia de ajos", 2);
        getDebilidades().put(debilidad2.getNombre(), debilidad2);

    }

    public void crearFortalezas(){
        Fortaleza fortaleza1 = new Fortaleza("Inmortalidad", 5);
        getFortalezas().put(fortaleza1.getNombre(), fortaleza1);
        Fortaleza fortaleza2 = new Fortaleza("Fuerza sobrenatural", 4);
        getFortalezas().put(fortaleza2.getNombre(), fortaleza2);
    }



    private int puntoSangre;
    private int edad;
    private Disciplina disciplina;




}