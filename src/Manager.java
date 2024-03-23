import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Manager implements Serializable {

    public Manager(String fichero) {
        this.terminal = new TextTerminal();
        this.listaUsuarios = new HashMap<>();
    }
    private Map<String,Personaje> listaPersonajes;
    private Map<String,Usuario> listaUsuarios;
    private transient TextTerminal terminal;

    public void aniadir(Object object, String fichero){
        if (object instanceof Usuario) {
            listaUsuarios.put(((Usuario) object).getNick(), (Usuario) object);
        }
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(fichero + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cargarInformacion(String fichero) {

    }

    public void eliminar(Object obj,String fichero) {
        if (obj instanceof Usuario){
            listaUsuarios.remove(((Usuario) obj).getNick());
        }
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(fichero + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existe(String id, int num) {
        if (num == 1){
            return this.listaUsuarios.containsKey(id);
        }
        else{
            return false;
        }
    }

    public void mostrar(int num) {
        if (num == 1) {
            for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else {
            for (Map.Entry<String, Personaje> entry : listaPersonajes.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        }
    }

    public void mostrarUsuariosBloqueados() {
        terminal.show("Usuarios Bloqueados:");
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                if (((UsuarioEstandar) user).getBloqueado()){
                    terminal.show(user.getNick());
                }
            }
        }
    }

    public void mostrarUsuariosNoNormas() {
        terminal.show("Usuarios:");
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                terminal.show(user.getNick());
            }
        }
    }

    public boolean datosCorrectos(String nick, String password) {
        Usuario user = listaUsuarios.get(nick);
        return (password.equalsIgnoreCase(user.getPassword()));
    }

    public Usuario asociarUsuario(String nick) {
        return listaUsuarios.get(nick);
    }

    public boolean datosUsuarioEstandar(String nick) {
        Usuario user = listaUsuarios.get(nick);
        return user instanceof UsuarioEstandar;
    }

    public void bloquear_desbloquear(String nick,boolean valor) {
        Usuario user = listaUsuarios.get(nick);
        if (user instanceof UsuarioEstandar){
            ((UsuarioEstandar) user).setBloqueado(valor);
            terminal.show("Usuario bloqueado con éxito");
            try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(UtilConstants.FILE_USERS + "usuarios.ser"))) {
                objetoSalida.writeObject(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            terminal.show("El nick no pertenece a un usuario");
        }
    }

    public void setTerminal() {
        this.terminal = new TextTerminal();
    }
}