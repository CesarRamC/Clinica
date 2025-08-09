/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.service;

import clinica.model.Pacientes;
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
public class PacientesService {
    

    private final EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public PacientesService() { }

    //Guardar el paciente
    public Pacientes guardarPaciente(Pacientes paciente) {
        try {
            if (paciente.getPacVersion() == null) {
                paciente.setPacVersion(1L);
            }
            et = em.getTransaction();
            et.begin();
            em.persist(paciente);
            et.commit();
            em.refresh(paciente);
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El paciente se guardó correctamente.");
            return paciente;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("PacientesService.guardarPaciente: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al guardar el paciente.");
            return null;
        }
    }
     
    // Lista todos los pacientes 
    public List<Pacientes> listarTodos() {
        try {
            return em.createNamedQuery("Pacientes.findAll", Pacientes.class).getResultList();
        } catch (Exception ex) {
            System.out.println("PacientesService.listarTodos: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al listar los pacientes.");
            return null;
        }
    }

        //Desactivar un paciente
    public boolean desactivarPaciente(Long id) {
        try {
            Pacientes p = em.find(Pacientes.class, id);
            if (p == null) {
                Mensaje.show(Alert.AlertType.WARNING, "ATENCIÓN", "No se encontró el paciente.");
                return false;
            }
            et = em.getTransaction();
            et.begin();
            em.merge(p);
            et.commit();
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El paciente se desactivó correctamente.");
            return true;
        } catch (Exception ex) {
            if (et != null && et.isActive()) et.rollback();
            System.out.println("PacientesService.eliminarPaciente: " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrió un error al eliminar el paciente.");
            return false;
        }
    }
    
}
