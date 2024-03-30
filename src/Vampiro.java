/**
 * 
 */
public class Vampiro extends Personaje {


    public Vampiro(String nombre, int salud, int poder,int puntoSangre,int edad) {
        super(nombre,poder,salud);
        this.puntoSangre = puntoSangre;
        this.edad = edad;
        disciplina = new Disciplina("Disciplina",3,2,4);
        crearDebilidades();
        crearFortalezas();

    }


    public int sumarPotencialAtaque() {
        int sangre = getPuntoSangre();
        int valorDisciplina = disciplina.getCoste();
        int potencial = getPuntoSangre() + super.getPoder() + getValorAtaqueArmaActiva()+ getValorAtaqueArmaduraActiva() + getFortalezaActiva().getValor() ;
        if (sangre > 5){
            potencial+= 2;
        }
        if (sangre > valorDisciplina){
            sangre -= valorDisciplina;
            potencial += sangre;
        }

        return potencial;
    }

    @Override
    public int sumarPotencialDefensa() {
        int sangre = getPuntoSangre();
        int valorDisciplina = disciplina.getCoste();
        int potencial = getPuntoSangre() + super.getPoder() + getValorDefensaArmaActiva()+ getValorDefensaArmaduraActiva() - getDebilidadActiva().getValor() ;
        if (sangre > 5){
            potencial+= 2;
        }
        if (sangre > valorDisciplina){
            sangre -= valorDisciplina;
            potencial += sangre;
        }


        // aqui queda un if de sumar 4 si el ataque tiene exito

        return potencial;
    }



    public int getPuntoSangre() {
        return this.puntoSangre;
    }

    private void crearDebilidades(){
        Debilidad debilidad1 =  new Debilidad("Luz solar", 4);
        getDebilidades().put(debilidad1.getNombre(),debilidad1);
        Debilidad debilidad2 =  new Debilidad("Lluvia de ajos", 2);
        getDebilidades().put(debilidad2.getNombre(), debilidad2);

    }

    private void crearFortalezas(){
        Fortaleza fortaleza1 = new Fortaleza("Inmortalidad", 5);
        getFortalezas().put(fortaleza1.getNombre(), fortaleza1);
        Fortaleza fortaleza2 = new Fortaleza("Fuerza sobrenatural", 4);
        getFortalezas().put(fortaleza2.getNombre(), fortaleza2);
    }

    private int puntoSangre;
    private int edad;
    private Disciplina disciplina;

    public void mostrarAtributosExtras() {
        System.out.print("Puntos de sangre: " + String.valueOf(puntoSangre) + "    ");
        System.out.println("Edad: " + String.valueOf(edad));
    }




}