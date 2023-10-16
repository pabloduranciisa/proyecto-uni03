/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.PersonajeDAO;
import DAOs.PersonajeDAOImpl;
import Entities.Personaje;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duran
 */
@WebServlet("/crearPersonaje")
public class PersonajeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PersonajeDAO personajeDAO = new PersonajeDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los valores desde el formulario
        String nombre = req.getParameter("name");
        int salud = Integer.parseInt(req.getParameter("health"));
        int intelecto = Integer.parseInt(req.getParameter("intellect"));
        int agilidad = Integer.parseInt(req.getParameter("agility"));
        int fuerza = Integer.parseInt(req.getParameter("strength"));
        int espiritu = Integer.parseInt(req.getParameter("spirit"));

        // Crear el objeto Personaje
        Personaje personaje = new Personaje();
        personaje.setName(nombre);
        personaje.setHealth(salud);
        personaje.setIntellect(intelecto);
        personaje.setAgility(agilidad);
        personaje.setStrength(fuerza);
        personaje.setSpirit(espiritu);
        
        System.out.println(personaje);

        // Usar el DAO para guardar el objeto
        personajeDAO.create(personaje);

        // Redirigir al usuario a una página de confirmación (o donde desees)
        //resp.sendRedirect("confirmacion.jsp");
    }
}