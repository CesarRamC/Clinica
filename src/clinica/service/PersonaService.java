/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.service;

import clinica.model.Persona;
import clinica.model.PersonaDto;
import clinica.model.Usuario;
import clinica.model.UsuarioDto;
import clinica.util.EntityManagerHelper;
import clinica.util.Mensaje;
import javafx.scene.control.Alert;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ivann
 */
public class PersonaService {
    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;
    UsuarioService usuarioService;
    
    public PersonaService() {
               
    }

     public void guardarPersona(PersonaDto personaDto, UsuarioDto usuarioDto) {
        try {
            usuarioService = new UsuarioService();
            Usuario usuario = new Usuario();
            usuario = usuarioService.guardarUsuario(usuarioDto);
            
            et = em.getTransaction();
            et.begin();
            System.out.println("usuario ID: --------------------------- " +usuario.getUsuId());
            if (usuario.getUsuId() == null) {
                 throw new IllegalStateException("El ID del usuario no se ha generado correctamente.");
            }
            Persona persona = new Persona(personaDto);
            persona.setCliIdUsuario(usuario);
            em.persist(persona);
            em.flush();
            et.commit();
            Mensaje.show(Alert.AlertType.INFORMATION, "INFORMACIÓN", "El usuario se guardó correctamente.");
        } catch (Exception ex) {
            if(et != null && et.isActive()){
                et.rollback();
            }
            System.out.println("service:   " + ex);
            Mensaje.show(Alert.AlertType.ERROR, "ERROR", "Ocurrio un error al guardar el usuario.");
        }
    }    
    
}
