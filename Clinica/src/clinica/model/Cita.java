/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivann
 */
@Entity
@Table(name = "CLI_CITA", catalog = "", schema = "SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByCitId", query = "SELECT c FROM Cita c WHERE c.citId = :citId"),
    @NamedQuery(name = "Cita.findByCitFecha", query = "SELECT c FROM Cita c WHERE c.citFecha = :citFecha"),
    @NamedQuery(name = "Cita.findByCitHora", query = "SELECT c FROM Cita c WHERE c.citHora = :citHora"),
    @NamedQuery(name = "Cita.findByCitDescripcion", query = "SELECT c FROM Cita c WHERE c.citDescripcion = :citDescripcion"),
    @NamedQuery(name = "Cita.findByCitCodigo", query = "SELECT c FROM Cita c WHERE c.citCodigo = :citCodigo")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CIT_ID", nullable = false, precision = 0, scale = -127)
    private Long citId;
    @Basic(optional = false)
    @Column(name = "CIT_FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date citFecha;
    @Basic(optional = false)
    @Column(name = "CIT_HORA", nullable = false, length = 5)
    private String citHora;
    @Basic(optional = false)
    @Column(name = "CIT_DESCRIPCION", nullable = false, length = 300)
    private String citDescripcion;
    @Basic(optional = false)
    @Column(name = "CIT_CODIGO", nullable = false, length = 10)
    private String citCodigo;
    @JoinColumn(name = "CIT_ID_MEDICO", referencedColumnName = "MED_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Medicos citIdMedico;
    @JoinColumn(name = "CIT_ID_PACIENTE", referencedColumnName = "PAC_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pacientes citIdPaciente;

    public Cita() {
    }

    public Cita(Long citId) {
        this.citId = citId;
    }

    public Cita(Long citId, Date citFecha, String citHora, String citDescripcion, String citCodigo) {
        this.citId = citId;
        this.citFecha = citFecha;
        this.citHora = citHora;
        this.citDescripcion = citDescripcion;
        this.citCodigo = citCodigo;
    }

    public Long getCitId() {
        return citId;
    }

    public void setCitId(Long citId) {
        this.citId = citId;
    }

    public Date getCitFecha() {
        return citFecha;
    }

    public void setCitFecha(Date citFecha) {
        this.citFecha = citFecha;
    }

    public String getCitHora() {
        return citHora;
    }

    public void setCitHora(String citHora) {
        this.citHora = citHora;
    }

    public String getCitDescripcion() {
        return citDescripcion;
    }

    public void setCitDescripcion(String citDescripcion) {
        this.citDescripcion = citDescripcion;
    }

    public String getCitCodigo() {
        return citCodigo;
    }

    public void setCitCodigo(String citCodigo) {
        this.citCodigo = citCodigo;
    }

    public Medicos getCitIdMedico() {
        return citIdMedico;
    }

    public void setCitIdMedico(Medicos citIdMedico) {
        this.citIdMedico = citIdMedico;
    }

    public Pacientes getCitIdPaciente() {
        return citIdPaciente;
    }

    public void setCitIdPaciente(Pacientes citIdPaciente) {
        this.citIdPaciente = citIdPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citId != null ? citId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.citId == null && other.citId != null) || (this.citId != null && !this.citId.equals(other.citId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clinica.model.Cita[ citId=" + citId + " ]";
    }
    
}
