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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivann
 */
@Entity
@Table(name = "CLI_USUARIO", catalog = "", schema = "SYSTEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuId", query = "SELECT u FROM Usuario u WHERE u.usuId = :usuId"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE UPPER(u.usuUsuario) = :usuUsuario"),
    @NamedQuery(name = "Usuario.findByUsuUsuario", query = "SELECT u FROM Usuario u WHERE UPPER(u.usuUsuario) = :usuUsuario and UPPER(u.usuContrasena) = :usuContrasena and UPPER(u.usuEstado) = :usuEstado"),
    @NamedQuery(name = "Usuario.findByUsuEstado", query = "SELECT u FROM Usuario u WHERE u.usuEstado = :usuEstado"),
    @NamedQuery(name = "Usuario.findByUsuVersion", query = "SELECT u FROM Usuario u WHERE u.usuVersion = :usuVersion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="CLI_USUARIO_IDUSUARIO_GENERATOR",sequenceName = "SYSTEM.SEQ_USUARIOS",allocationSize =1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CLI_USUARIO_IDUSUARIO_GENERATOR") 
    @Column(name = "USU_ID")//nullable = false, precision = 0, scale = -127
    private Long usuId;
    @Basic(optional = false)
    @Column(name = "USU_USUARIO", nullable = false, length = 100)
    private String usuUsuario;
    @Basic(optional = false)
    @Column(name = "USU_CONTRASENA", nullable = false, length = 8)
    private String usuContrasena;
    @Basic(optional = false)
    @Column(name = "USU_ESTADO", nullable = false, length = 1)
    private String usuEstado;
    @Version
    @Basic(optional = false)
    @Column(name = "USU_VERSION", nullable = false)
    private Long usuVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliIdUsuario", fetch = FetchType.LAZY)
    private List<Persona> personaList;

    public Usuario() {
        this.usuId = null;
        this.usuUsuario = null;
        this.usuContrasena = null;
        this.usuEstado = null;
        this.usuVersion = null;
    }

    public Usuario(Long usuId) {
        this.usuId = usuId;
    }

    public Usuario(Long usuId, String usuUsuario, String usuContrasena, String usuEstado, Long usuVersion) {
        this.usuId = usuId;
        this.usuUsuario = usuUsuario;
        this.usuContrasena = usuContrasena;
        this.usuEstado = usuEstado;
        this.usuVersion = usuVersion;
    }
    
    public Usuario(UsuarioDto usuarioDto) {
        actualizarUsuario(usuarioDto);
    }

    public void actualizarUsuario(UsuarioDto usuarioDto) {
        this.usuUsuario = usuarioDto.getUsuUsuario();
        this.usuContrasena = usuarioDto.getUsuContrasena();
        this.usuEstado = usuarioDto.getUsuEstado();
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Long getUsuVersion() {
        return usuVersion;
    }

    public void setUsuVersion(Long usuVersion) {
        this.usuVersion = usuVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clinica.model.Usuario[ usuId=" + usuId + " ]";
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
    
}
