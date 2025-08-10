
package clinica.model;

import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class CitaDto {
    
    private SimpleObjectProperty<Long> citId;
    private SimpleObjectProperty<Date> citFecha;
    private SimpleStringProperty citHora;
    private SimpleStringProperty citDescripcion;
    private SimpleStringProperty citCodigo;
    private SimpleObjectProperty<Medicos> citIdMedico;
    private SimpleObjectProperty<Pacientes> citIdPaciente;

    public CitaDto() {
        this.citId = new SimpleObjectProperty<>();
        this.citFecha = new SimpleObjectProperty<>();
        this.citHora = new SimpleStringProperty();
        this.citDescripcion = new SimpleStringProperty();
        this.citCodigo = new SimpleStringProperty();
        this.citIdMedico = new SimpleObjectProperty<>();
        this.citIdPaciente = new SimpleObjectProperty<>();
    }

    public CitaDto(Cita c) {
        this();
        if (c != null) {
            this.citId.set(c.getCitId());
            this.citFecha.set(c.getCitFecha());
            this.citHora.set(c.getCitHora());
            this.citDescripcion.set(c.getCitDescripcion());
            this.citCodigo.set(c.getCitCodigo());
            this.citIdMedico.set(c.getCitIdMedico());
            this.citIdPaciente.set(c.getCitIdPaciente());
        }
    }

    // Getters y Setters
    public Long getCitId() { 
        
        return citId.get(); 
    }
    
    public void setCitId(Long id) { 
        
        this.citId.set(id); 
    }

    public Date getCitFecha() { 
        
        return citFecha.get(); 
    }
    public void setCitFecha(Date fecha) { 
        
        this.citFecha.set(fecha); 
    }

    public String getCitHora() { 
        
        return citHora.get(); 
    }
    
    public void setCitHora(String hora) { 
        
        this.citHora.set(hora); 
    }

    public String getCitDescripcion() { 
        
        return citDescripcion.get(); 
    }
    public void setCitDescripcion(String descripcion) { 
        
        this.citDescripcion.set(descripcion); 
    }

    public String getCitCodigo() { 
        
        return citCodigo.get(); 
    }
    public void setCitCodigo(String codigo) { 
        
        this.citCodigo.set(codigo); 
    }

    public Medicos getCitIdMedico() { 
        
        return citIdMedico.get(); 
    }
    public void setCitIdMedico(Medicos medico) { 
        
        this.citIdMedico.set(medico); 
    }

    public Pacientes getCitIdPaciente() { 
        
        return citIdPaciente.get(); 
    }
    
    public void setCitIdPaciente(Pacientes paciente) { 
        this.citIdPaciente.set(paciente); 
    
    }

       // Conversión DTO -> Entity
    public Cita toEntity() {
        Cita c = new Cita();
        c.setCitId(getCitId());
        c.setCitFecha(getCitFecha());
        c.setCitHora(getCitHora());
        c.setCitDescripcion(getCitDescripcion());
        c.setCitCodigo(getCitCodigo());
        c.setCitIdMedico(getCitIdMedico());
        c.setCitIdPaciente(getCitIdPaciente());
        return c;
    }
    
}
