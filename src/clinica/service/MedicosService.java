/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.service;
import clinica.model.Medicos;
import clinica.model.Persona;
import clinica.util.EntityManagerHelper;
import clinica.util.Mensaje;
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
public class MedicosService {
    
private final EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public MedicosService() { }

    
    public Medicos guardarMedico(Medicos medico) {
        try {
            if (medico.getMedVersion() == null) {
                medico.setMedVersion(1L);
            }
            et = em.getTransaction();
            et.begin();
            em.persist(medico);
            et.commit();
            em.refresh(medico);
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El médico se guardó correctamente.");
            return medico;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("MedicosService.guardarMedico: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al guardar el médico.");
            return null;
        }
    }

    //Desactivar un médico
    public boolean desctivarMedico(Long id) {
        try {
            Medicos m = em.find(Medicos.class, id);
            if (m == null) {
                Mensaje.show(Alert.AlertType.WARNING, "ATENCIÓN", "No se encontró el médico.");
                return false;
            }
            et = em.getTransaction();
            et.begin();
            em.merge(m);
            et.commit();
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El médico se desactivó correctamente.");
            return true;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("MedicosService.eliminarMedico: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al desactivar el médico.");
            return false;
        }
    }
    
}
