import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Manager implements Serializable {

    public Manager(String fichero) {
        this.terminal = new TextTerminal();
        this.listaUsuarios = new HashMap<>();
        this.listaPersonajes = new HashMap<>();
        this.listaCombates = new HashMap<>();
        this.listaArmas = new HashMap<>();
        this.listaArmaduras = new HashMap<>();
    }
    private Map<String,Personaje> listaPersonajes;
    private Map<String,Usuario> listaUsuarios;
    private Map<String,Combate> listaCombates;
    private Map<String,Arma> listaArmas;
    private Map<String,Armadura> listaArmaduras;
    private transient TextTerminal terminal;

    public void aniadir(Object object, String fichero){
        if (object instanceof Usuario) {
            listaUsuarios.put(((Usuario) object).getNick(), (Usuario) object);
        } else if (object instanceof Personaje){
            listaPersonajes.put(((Personaje) object).getNombre(), (Personaje) object);
        } else if (object instanceof Combate){
            listaCombates.put(((Combate) object).getId(), (Combate) object);
        } else if (object instanceof Arma) {
            listaArmas.put(((Arma) object).getId(), (Arma) object);
        } else if (object instanceof Armadura) {
            listaArmaduras.put(((Armadura) object).getId(), (Armadura) object);
        }
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(fichero + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardar() {
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(UtilConstants.FILE_USERS + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Object obj,String fichero) {
        if (obj instanceof Usuario){
            listaUsuarios.remove(((Usuario) obj).getNick());
        } else if (obj instanceof Personaje){
            listaPersonajes.remove(((Personaje) obj).getNombre());
        } else if (obj instanceof Combate){
            listaCombates.remove(((Combate) obj).getId());
        }  else if (obj instanceof Arma){
            listaArmas.remove(((Arma) obj).getId());
        } else if (obj instanceof Armadura){
            listaArmaduras.remove(((Armadura) obj).getId());
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
        } else if (num == 2){
            return this.listaPersonajes.containsKey(id);
        } else if (num == 3){
            return this.listaCombates.containsKey(id);
        } else if (num == 4){
            return this.listaArmas.containsKey(id);
        } else if (num == 5) {
            return this.listaArmaduras.containsKey(id);
        } else return false;
    }

    public void mostrar(int num) {
        if (num == 1) {
            for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else if (num == 2) {
            for (Map.Entry<String, Personaje> entry : listaPersonajes.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else if (num == 3) {
            for (Map.Entry<String, Combate> entry : listaCombates.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else if (num == 4) {
            for (Map.Entry<String, Arma> entry : listaArmas.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else if (num == 5) {
            for (Map.Entry<String, Armadura> entry : listaArmaduras.entrySet()) {
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

    public Personaje asociarPersonaje(String nick) {
        return listaPersonajes.get(nick);
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


    public void mostrarUsuariosParaDesafiar(String nick) {
        terminal.show("Usuarios para desafiar:");
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                if (!(((UsuarioEstandar) user).getBloqueado())){
                    if (user.getNick() != nick) {
                        terminal.show(user.getNick());
                    }
                }
            }
        }
    }

    public boolean existeDesafiar(String opcion) {
        Boolean encontrado = false;
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                if (!(((UsuarioEstandar) user).getBloqueado())){
                    if (user.getNick().equalsIgnoreCase(opcion)) {
                        encontrado = true;
                    }
                }
            }
        }
        return encontrado;
    }

    public void asociarDesafio(String opcion) {
        Combate combate = this.listaCombates.get(opcion);
        combate.asociarDesafio();
    }
}