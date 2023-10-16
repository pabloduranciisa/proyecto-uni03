/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entities.Personaje;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author duran
 */
public class PersonajeDAOImpl implements PersonajeDAO{

    private static final String PERSISTENCE_UNIT_NAME = "my-pu";
    private static EntityManagerFactory factory;

    public PersonajeDAOImpl() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    
    @Override
    public Personaje read(int id) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Personaje.class, id);
        } finally {
            em.close();
        }
    }


    @Override
    public void create(Personaje personaje) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Nombre del personaje: " + personaje.getName());
        System.out.println("Salud del personaje: " + personaje.getHealth());
        em.persist(personaje);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void edit(Personaje personaje) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(personaje);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void destroy(int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Personaje personaje = em.find(Personaje.class, id);
        if (personaje != null) {
            em.remove(personaje);
        }
        em.getTransaction().commit();
        em.close();
    }
}