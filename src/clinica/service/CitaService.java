
package clinica.service;

import clinica.model.Cita;
import clinica.model.Medicos;
import clinica.model.Pacientes;
import clinica.util.EntityManagerHelper;
import clinica.util.Mensaje;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javafx.scene.control.Alert;

/**
 *
 * @author ivann
 */
public class CitaService {
    
    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public CitaService() { }

    
    public Cita guardarCita(Cita cita) {
        try { 
            et = em.getTransaction();
            et.begin();
            em.persist(cita);
            et.commit();
            em.refresh(cita);
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "La cita se registró correctamente.");
            return cita;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("CitaService.guardarCita: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al registrar la cita.");
            return null;
        }
    }

        //Editar (actualizar) una cita
    public Cita editarCita(Cita cita) {
        try {
            et = em.getTransaction();
            et.begin();
            Cita actualizada = em.merge(cita);
            et.commit();
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "La cita se actualizó correctamente.");
            return actualizada;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("CitaService.actualizarCita: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al actualizar la cita.");
            return null;
        }
    }

        //Eliminar una cita por su ID
    public boolean eliminarCita(Long id) {
        try {
            Cita c = em.find(Cita.class, id);
            if (c == null) {
                Mensaje.show(Alert.AlertType.WARNING, "ATENCIÓN", "No se encontró la cita.");
                return false;
            }
            et = em.getTransaction();
            et.begin();
            em.remove(c);
            et.commit();
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "La cita se eliminó correctamente.");
            return true;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("CitaService.eliminarCita: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al eliminar la cita.");
            return false;
        }
    }

        //Buscar una cita
    public Cita buscarPorCodigo(String codigo) {
        try {
            Query q = em.createQuery("SELECT c FROM Cita c WHERE c.citCodigo = :codigo", Cita.class);
            q.setParameter("codigo", codigo);
            return (Cita) q.getSingleResult();
        } catch (NoResultException ex) {
            Mensaje.show(Alert.AlertType.WARNING, "ATENCIÓN", "No existe una cita con ese código.");
            return null;
        } catch (NonUniqueResultException ex) {
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Existe más de una cita con el mismo código.");
            return null;
        } catch (Exception ex) {
            System.out.println("CitaService.buscarPorCodigo: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al consultar la cita por código.");
            return null;
        }
    }

        // Listar todas las citas
    /*
    public List<Cita> listarTodas() {
        try {
            return em.createQuery("SELECT c FROM Cita c ORDER BY c.citFecha, c.citHora", Cita.class)
                     .getResultList();
        } catch (Exception ex) {
            System.out.println("CitaService.listarTodas: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al listar las citas.");
            return null;
        }
    }

       //Listar citas de un paciente
    public List<Cita> listarPorPaciente(Pacientes paciente) {
        try {
            return em.createQuery(
                     "SELECT c FROM Cita c WHERE c.citIdPaciente = :pac ORDER BY c.citFecha, c.citHora",
                     Cita.class)
                     .setParameter("pac", paciente)
                     .getResultList();
        } catch (Exception ex) {
            System.out.println("CitaService.listarPorPaciente: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al listar las citas del paciente.");
            return null;
        }
    }

        // Listar citas de un médico
    public List<Cita> listarPorMedico(Medicos medico) {
        try {
            return em.createQuery(
                     "SELECT c FROM Cita c WHERE c.citIdMedico = :med ORDER BY c.citFecha, c.citHora",
                     Cita.class)
                     .setParameter("med", medico)
                     .getResultList();
        } catch (Exception ex) {
            System.out.println("CitaService.listarPorMedico: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al listar las citas del médico.");
            return null;
        }
    }

        // Listar citas por fecha (todas, opcionalmente filtrar por médico/paciente)
    public List<Cita> listarPorFecha(Date fecha) {
        try {
            return em.createQuery(
                     "SELECT c FROM Cita c WHERE c.citFecha = :f ORDER BY c.citHora",
                     Cita.class)
                     .setParameter("f", fecha)
                     .getResultList();
        } catch (Exception ex) {
            System.out.println("CitaService.listarPorFecha: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al listar las citas por fecha.");
            return null;
        }
    }    */ 
    
}
