
package clinica.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Usuario
 */
public class MedicosDto {   
    

    private SimpleObjectProperty<BigDecimal> medId;
    private SimpleObjectProperty<BigInteger> medVersion;
    private SimpleObjectProperty<Persona> medIdPersona;

    public MedicosDto() {
        this.medId = new SimpleObjectProperty<>();
        this.medVersion = new SimpleObjectProperty<>();
        this.medIdPersona = new SimpleObjectProperty<>();
    }

    public MedicosDto(Medicos medicos) {
        this();
        if (medicos != null) {
            this.medId.set(medicos.getMedId());
            this.medVersion.set(medicos.getMedVersion());
            this.medIdPersona.set(medicos.getMedIdPersona());
        }
    }

    // Getters y Setters
    public BigDecimal getMedId() { 
        
        return medId.get(); 
    }
    
    public void setMedId(BigDecimal id) {
        
        this.medId.set(id); 
    }

    // Conveniencia: setear id desde long
    public void setMedIdFromLong(Long id) {
        
        this.medId.set(id != null ? BigDecimal.valueOf(id) : null);
    }

    public BigInteger getMedVersion() { 
        
        return medVersion.get(); 
    }
    public void setMedVersion(BigInteger v) { 
        
        this.medVersion.set(v); }

    // Conveniencia: setear versión desde long
    public void setMedVersionFromLong(Long v) {
        
        this.medVersion.set(v != null ? BigInteger.valueOf(v) : null);
    }

    public Persona getMedIdPersona() { 
        
        return medIdPersona.get(); 
    
    }
    public void setMedIdPersona(Persona persona) { 
        
        this.medIdPersona.set(persona); 
    }

   

    // Conversión DTO -> Entity
    public Medicos toEntity() {
        Medicos m = new Medicos();
        m.setMedId(getMedId());
        // MUY IMPORTANTE: usar el setter BigInteger (el setter long lanza UnsupportedOperationException en tu entidad)
        m.setMedVersion(getMedVersion() != null ? getMedVersion() : BigInteger.ONE);
        m.setMedIdPersona(getMedIdPersona());
        return m;
    }
    
}
