import java.io.*;

/**
 * 
 */
public class UsuarioEstandar extends Usuario {


    public UsuarioEstandar(String nombre, String nick, String password) {
        super(nombre, nick, password);
        this.numeroDeRegistro = generarNumeroDeRegistro();
        this.bloqueado = false;
    }

    private String numeroDeRegistro;
    private PersonajeUser personaje;
    private boolean bloqueado;

    public String generarNumeroDeRegistro() {
        try {
            String filePath = UtilConstants.FILE_NUMREG;
            File archivo = new File(filePath);
            if (!archivo.exists()) {
                archivo.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    String nuevaLinea = "-1 Z";
                    writer.write(nuevaLinea);
                }
            }
            String linea;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                linea = reader.readLine();
            }

            if (linea != null) {
                String[] partes = linea.split(" ");
                int num = Integer.parseInt(partes[0]);
                String letra = partes[1];
                if (letra.equalsIgnoreCase("Z")) {
                    letra = "A";
                    num++;
                } else {
                    char siguienteLetra = (char) (letra.charAt(0) + 1);
                    letra = String.valueOf(siguienteLetra);
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    String nuevaLinea = num + " " + letra;
                    writer.write(nuevaLinea);
                    System.out.println(letra + num + num + letra + letra);
                    return (letra + num + num + letra + letra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean getBloqueado(){
        return this.bloqueado;
    }

    public void setBloqueado(Boolean bool){
        this.bloqueado = bool;
    }

}