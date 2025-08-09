/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ivann
 */
public class PersonaDto {
    
    private SimpleStringProperty cliNombreCompleto;
    private SimpleStringProperty cliCedula;
    private SimpleStringProperty cliGenero;
    private SimpleStringProperty cliTelefono;
    private SimpleStringProperty cliCorreoElectronico;
    private SimpleObjectProperty<Date> cliAnioNacimiento;
    //private DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

     public PersonaDto() {
        this.cliNombreCompleto =  new SimpleStringProperty();
        this.cliCedula = new SimpleStringProperty();
        this.cliGenero = new SimpleStringProperty();
        this.cliTelefono = new SimpleStringProperty();
        this.cliCorreoElectronico = new SimpleStringProperty();
        this.cliAnioNacimiento = new SimpleObjectProperty<>();
    }
    
     public PersonaDto(Persona persona) {
        this();
        this.cliNombreCompleto.set(persona.getCliNombreCompleto());
        this.cliCedula.set(persona.getCliCedula());
        this.cliGenero.set(persona.getCliGenero());
        this.cliTelefono.set(persona.getCliTelefono());
        this.cliCorreoElectronico.set(persona.getCliCorreoElectronico());
        this.cliAnioNacimiento.set(persona.getCliAnioNacimiento());
        
    }
  
    public String getCliNombreCompleto() {
        return cliNombreCompleto.get();
    }

    public void setCliNombreCompleto(String cliNombreCompleto) {
        this.cliNombreCompleto.set(cliNombreCompleto);
    }

    public String getCliCedula() {
        return cliCedula.get();
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula.set(cliCedula);
    }

    public Date getCliAnioNacimiento() {
        return cliAnioNacimiento.get();
    }

    public void setCliAnioNacimiento(Date cliAnioNacimiento) {
        this.cliAnioNacimiento.set(cliAnioNacimiento);
    }

    public String getCliGenero() {
        return cliGenero.get();
    }

    public void setCliGenero(String cliGenero) {
        this.cliGenero.set(cliGenero);
    }

    public String getCliTelefono() {
        return cliTelefono.get();
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono.set(cliTelefono);
    }

    public String getCliCorreoElectronico() {
        return cliCorreoElectronico.get();
    }

    public void setCliCorreoElectronico(String cliCorreoElectronico) {
        this.cliCorreoElectronico.set(cliCorreoElectronico);
    }

}
