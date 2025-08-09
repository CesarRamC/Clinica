/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivann
 */
@Entity
@Table(name = "CLI_PERSONA", catalog = "", schema = "SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByCliId", query = "SELECT p FROM Persona p WHERE p.cliId = :cliId"),
    @NamedQuery(name = "Persona.findByCliNombreCompleto", query = "SELECT p FROM Persona p WHERE p.cliNombreCompleto = :cliNombreCompleto"),
    @NamedQuery(name = "Persona.findByCliCedula", query = "SELECT p FROM Persona p WHERE p.cliCedula = :cliCedula"),
    @NamedQuery(name = "Persona.findByCliAnioNacimiento", query = "SELECT p FROM Persona p WHERE p.cliAnioNacimiento = :cliAnioNacimiento"),
    @NamedQuery(name = "Persona.findByCliGenero", query = "SELECT p FROM Persona p WHERE p.cliGenero = :cliGenero"),
    @NamedQuery(name = "Persona.findByCliTelefono", query = "SELECT p FROM Persona p WHERE p.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "Persona.findByCliCorreoElectronico", query = "SELECT p FROM Persona p WHERE p.cliCorreoElectronico = :cliCorreoElectronico"),
    @NamedQuery(name = "Persona.findByCliVersion", query = "SELECT p FROM Persona p WHERE p.cliVersion = :cliVersion")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="CLI_PERSONA_IDPERSONA_GENERATOR",sequenceName = "SYSTEM.SEQ_PERSONA",allocationSize =1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CLI_PERSONA_IDPERSONA_GENERATOR") 
    @Column(name = "CLI_ID", nullable = false, precision = 0, scale = -127)
    private Long cliId;
    @Basic(optional = false)
    @Column(name = "CLI_NOMBRE_COMPLETO", nullable = false, length = 100)
    private String cliNombreCompleto;
    @Basic(optional = false)
    @Column(name = "CLI_CEDULA", nullable = false, length = 9)
    private String cliCedula;
    @Basic(optional = false)
    @Column(name = "CLI_ANIO_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cliAnioNacimiento;
    @Basic(optional = false)
    @Column(name = "CLI_GENERO", nullable = false, length = 1)
    private String cliGenero;
    @Basic(optional = false)
    @Column(name = "CLI_TELEFONO", nullable = false, length = 8)
    private String cliTelefono;
    @Basic(optional = false)
    @Column(name = "CLI_CORREO_ELECTRONICO", nullable = false, length = 100)
    private String cliCorreoElectronico;
    @Version
    @Basic(optional = false)
    @Column(name = "CLI_VERSION", nullable = false)
    private Long cliVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacIdPersona", fetch = FetchType.LAZY)
    private List<Pacientes> pacientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medIdPersona", fetch = FetchType.LAZY)
    private List<Medicos> medicosList;
    @JoinColumn(name = "CLI_ID_USUARIO", referencedColumnName = "USU_ID", nullable = false)
    @ManyToOne(/*cascade = CascadeType.PERSIST,*/fetch = FetchType.LAZY)
    private Usuario cliIdUsuario;

    public Persona() {
    }

    public Persona(Long cliId) {
        this.cliId = cliId;
    }

    public Persona(Long cliId, String cliNombreCompleto, String cliCedula, Date cliAnioNacimiento, String cliGenero, String cliTelefono, String cliCorreoElectronico, Long cliVersion) {
        this.cliId = cliId;
        this.cliNombreCompleto = cliNombreCompleto;
        this.cliCedula = cliCedula;
        this.cliAnioNacimiento = cliAnioNacimiento;
        this.cliGenero = cliGenero;
        this.cliTelefono = cliTelefono;
        this.cliCorreoElectronico = cliCorreoElectronico;
        this.cliVersion = cliVersion;
    }
    
      public Persona(PersonaDto personaDto) {
        actualizarPersona(personaDto);
    }

    public void actualizarPersona(PersonaDto personaDto) {
        //DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       // LocalDate date = LocalDate.parse(personaDto.getCliAnioNacimiento());
        this.cliNombreCompleto = personaDto.getCliNombreCompleto();
        this.cliCedula = personaDto.getCliCedula();
        this.cliAnioNacimiento = personaDto.getCliAnioNacimiento();
        this.cliCorreoElectronico = personaDto.getCliCorreoElectronico();
        this.cliGenero = personaDto.getCliGenero();
        this.cliTelefono = personaDto.getCliTelefono();
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNombreCompleto() {
        return cliNombreCompleto;
    }

    public void setCliNombreCompleto(String cliNombreCompleto) {
        this.cliNombreCompleto = cliNombreCompleto;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    public Date getCliAnioNacimiento() {
        return cliAnioNacimiento;
    }

    public void setCliAnioNacimiento(Date cliAnioNacimiento) {
        this.cliAnioNacimiento = cliAnioNacimiento;
    }

    public String getCliGenero() {
        return cliGenero;
    }

    public void setCliGenero(String cliGenero) {
        this.cliGenero = cliGenero;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliCorreoElectronico() {
        return cliCorreoElectronico;
    }

    public void setCliCorreoElectronico(String cliCorreoElectronico) {
        this.cliCorreoElectronico = cliCorreoElectronico;
    }

    public Long getCliVersion() {
        return cliVersion;
    }

    public void setCliVersion(Long cliVersion) {
        this.cliVersion = cliVersion;
    }

    @XmlTransient
    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @XmlTransient
    public List<Medicos> getMedicosList() {
        return medicosList;
    }

    public void setMedicosList(List<Medicos> medicosList) {
        this.medicosList = medicosList;
    }

    public Usuario getCliIdUsuario() {
        return cliIdUsuario;
    }

    public void setCliIdUsuario(Usuario cliIdUsuario) {
        this.cliIdUsuario = cliIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliId != null ? cliId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clinica.model.Persona[ cliId=" + cliId + " ]";
    }
    
}
