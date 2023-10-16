package com.mycompany.projectuni03.resources;

import DAOs.PersonajeDAO;
import Entities.Personaje;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/personajes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonajeResource {
    @Inject
    private PersonajeDAO personajeDAO;

    @GET
    @Path("/{id}")
    public Response getPersonaje(@PathParam("id") int id) {
        Personaje personaje = personajeDAO.read(id);
        if (personaje != null) {
            return Response.ok(personaje).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createPersonaje(Personaje personaje) {
        personajeDAO.create(personaje);
        return Response.status(Response.Status.CREATED).entity(personaje).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePersonaje(@PathParam("id") int id, Personaje personaje) {
        Personaje existingPersonaje = personajeDAO.read(id);
        if (existingPersonaje != null) {
            personaje.setId(id);
            personajeDAO.edit(personaje);
            return Response.ok(personaje).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePersonaje(@PathParam("id") int id) {
        Personaje existingPersonaje = personajeDAO.read(id);
        if (existingPersonaje != null) {
            personajeDAO.destroy(id);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
