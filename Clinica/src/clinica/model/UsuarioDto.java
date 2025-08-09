/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ivann
 */
public class UsuarioDto {

    private SimpleStringProperty usuUsuario;
    private SimpleStringProperty usuContrasena;
    public SimpleBooleanProperty usuEstado;
    //public SimpleIntegerProperty usuVersion;
    

    public UsuarioDto() {
        this.usuUsuario =  new SimpleStringProperty();
        this.usuContrasena = new SimpleStringProperty();
        this.usuEstado = new SimpleBooleanProperty(true);
        //this.usuVersion = new SimpleIntegerProperty();
    }
    
     public UsuarioDto(Usuario usuario) {
        this();
        this.usuUsuario.set(usuario.getUsuUsuario());
        this.usuContrasena.set(usuario.getUsuContrasena());
        this.usuEstado.set(usuario.getUsuEstado().equalsIgnoreCase("A"));
        //this.usuVersion.set(usuario.getUsuVersion().intValue());
        
    }

    public String getUsuUsuario() {
        return usuUsuario.get();
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario.set(usuUsuario);
    }

    public String getUsuContrasena() {
        return usuContrasena.get();
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena.set(usuContrasena);
    }

    public String getUsuEstado() {
        return usuEstado.getValue() ? "A" : "I";
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado.setValue(usuEstado.equalsIgnoreCase("A"));
    }
    
}
