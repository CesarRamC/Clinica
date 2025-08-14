
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

        //Eliminar una cita por ID
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

                 
}
