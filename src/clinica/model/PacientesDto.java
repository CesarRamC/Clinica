
package clinica.model;

import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Usuario
 */
public class PacientesDto {
    
    private SimpleObjectProperty<Long> pacId;
    private SimpleObjectProperty<Long> pacVersion;
    private SimpleObjectProperty<Persona> pacIdPersona;
    

    public PacientesDto() {
        this.pacId = new SimpleObjectProperty<>();
        this.pacVersion = new SimpleObjectProperty<>();
        this.pacIdPersona = new SimpleObjectProperty<>();
    }

    public PacientesDto(Pacientes pacientes) {
        this();
        if (pacientes != null) {
            this.pacId.set(pacientes.getPacId());
            this.pacVersion.set(pacientes.getPacVersion());
            this.pacIdPersona.set(pacientes.getPacIdPersona());
        }
    }

    // Getters y Setters 
    public Long getPacId() { 
        
        return pacId.get(); 
    }
    
    public void setPacId(Long id) { 
        
        this.pacId.set(id); 
    }

    public Long getPacVersion() { 
        
        return pacVersion.get(); 
    }
    public void setPacVersion(Long v) { 
        
        this.pacVersion.set(v); 
    }

    public Persona getPacIdPersona() { 
        
        return pacIdPersona.get(); 
    }
    public void setPacIdPersona(Persona persona) {
        
        this.pacIdPersona.set(persona); 
    }   
       
    
}
