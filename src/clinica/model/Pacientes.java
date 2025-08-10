/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivann
 */
@Entity
@Table(name = "CLI_PACIENTES", catalog = "", schema = "SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByPacId", query = "SELECT p FROM Pacientes p WHERE p.pacId = :pacId"),
    @NamedQuery(name = "Pacientes.findByPacVersion", query = "SELECT p FROM Pacientes p WHERE p.pacVersion = :pacVersion")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PAC_ID", nullable = false, precision = 0, scale = -127)
    private Long pacId;
    @Basic(optional = false)
    @Column(name = "PAC_VERSION", nullable = false)
    private Long pacVersion;
    @JoinColumn(name = "PAC_ID_PERSONA", referencedColumnName = "CLI_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona pacIdPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citIdPaciente", fetch = FetchType.LAZY)
    private List<Cita> citaList;

    public Pacientes() {
    }

    public Pacientes(Long pacId) {
        this.pacId = pacId;
    }

    public Pacientes(Long pacId, Long pacVersion) {
        this.pacId = pacId;
        this.pacVersion = pacVersion;
    }
    
    public Pacientes(PacientesDto pacientesdto) {   
    }
    
   
    public Long getPacId() {
        return pacId;
    }

    public void setPacId(Long pacId) {
        this.pacId = pacId;
    }

    public Long getPacVersion() {
        return pacVersion;
    }

    public void setPacVersion(Long pacVersion) {
        this.pacVersion = pacVersion;
    }

    public Persona getPacIdPersona() {
        return pacIdPersona;
    }

    public void setPacIdPersona(Persona pacIdPersona) {
        this.pacIdPersona = pacIdPersona;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacId != null ? pacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacId == null && other.pacId != null) || (this.pacId != null && !this.pacId.equals(other.pacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clinica.model.Pacientes[ pacId=" + pacId + " ]";
    }
    
}
