
package clinica.service;

import clinica.model.Usuario;
import clinica.model.UsuarioDto;
import clinica.util.AppContext;
import clinica.util.EntityManagerHelper;
import clinica.util.Mensaje;
import javafx.scene.control.Alert;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author ivann
 */
public class UsuarioService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public UsuarioService() {
    }

    Usuario guardarUsuario(UsuarioDto usuarioDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Usuario usuario = new Usuario(usuarioDto);
            em.persist(usuario);
            et.commit();
            em.refresh(usuario);
          //  Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El usuario se guardó correctamente.");
            return usuario;
        } catch (Exception ex) {
            //et.rollback();
            System.out.println("service:   " + ex);
            //Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrio un error al guardar el usuario.");
            return null;
        }
    }

    public void buscarUsuario(String usuario, String contrasena, String estado) {
        try {
            Query qryUsuario = em.createNamedQuery("Usuario.findByUsuUsuario", Usuario.class);
            qryUsuario.setParameter("usuUsuario", usuario.toUpperCase());
            qryUsuario.setParameter("usuContrasena", contrasena.toUpperCase());
            qryUsuario.setParameter("usuEstado", estado);
            qryUsuario.getSingleResult();//Si se necesita obtener una lista sería cambiar getSingleResult por getResultList 
            AppContext.getInstance().set("BusquedaUsuario", qryUsuario.getSingleResult());
        } catch (NoResultException ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "No existe un usuario con el nombre o contraseña ingresados.");
        } catch (NonUniqueResultException ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrio un error al consultar el usuario.");
        } catch (Exception ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrio un error al consultar el usuario.");
        }
    }
    
    public void desactivarUsuario(String usuario) {
        try {
            Query qryUsuario = em.createNamedQuery("Usuario.findByNombreUsuario", Usuario.class);
            qryUsuario.setParameter("usuUsuario", usuario.toUpperCase());
            Usuario usuarioEncontrado = (Usuario) qryUsuario.getSingleResult();
            usuarioEncontrado.setUsuEstado("I");
            et = em.getTransaction();
            et.begin();
            em.merge(usuarioEncontrado); //Para eliminar sería sustituyendo la palabra merge por remove.
            et.commit();
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El usuario se eliminó correctamente.");//Se hace la simulación que se está eliminando, pero lo normal es que se desactive el usuario en base de datos.
        } catch (NoResultException ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "No existe un usuario con el nombre");
        } catch (NonUniqueResultException ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrio un error al consultar el usuario.");
        } catch (Exception ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrio un error al consultar el usuario.");
        }
    }
}
