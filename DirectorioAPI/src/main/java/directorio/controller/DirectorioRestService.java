package directorio.controller;

import directorio.Service.Directorio;
import directorio.model.Persona;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Path("api/v1/directorio")
public class DirectorioRestService {

    private static Logger logger = LoggerFactory.getLogger(DirectorioRestService.class);

    @Inject
    Directorio directorio;

    @GET
    @Path("/{identificacion}")
    public Response findPersonaByIdentificacion(@PathParam("identificacion") String identificacion){
        List<Persona> persona = directorio.findPersonaByIdentificacion(identificacion);
        if (persona.isEmpty()){
            logger.error("La persona no existe");
            return Response.status(404).entity("La persona no existe").build();
        }else {
            for (Persona persona1 : persona){
                logger.debug(persona1.getNombre());
                logger.debug(persona1.getApellidoPaterno());
                logger.debug(persona1.getApellidoMaterno());
                logger.debug(persona1.getIdentificacion());
            }
            return Response.ok(persona).build();
        }
    }

    @GET
    public Response findPersonas(){
        List<Persona> personas = directorio.findPersonas();
        if (personas.isEmpty()){
            logger.error("No hay personas");
            return Response.status(404).entity("No hay personas").build();
        }else {
            for (Persona persona1 : personas){
                logger.debug(persona1.getNombre());
                logger.debug(persona1.getApellidoPaterno());
                logger.debug(persona1.getApellidoMaterno());
                logger.debug(persona1.getIdentificacion());
            }
            return Response.ok(personas).entity(personas).build();
        }

    }


    @DELETE
    @Path("/{identificacion}")
    @Transactional
    public Response deletePersonaById(@PathParam("identificacion") String identificacion){
        List<Persona> persona = directorio.findPersonaByIdentificacion(identificacion);

        if (!persona.isEmpty()){
            for (Persona persona1 : persona){
                directorio.deletePersonaByIdentificacion(persona1.getId());
            }
            logger.debug("Borrado con exito");
            return Response.ok().entity("Borrado con exito").build();
        }else {
            logger.error("La persona no se puede borrar porque no existe");
            return Response.status(500).entity("La persona no se puede borrar porque no existe").build();
        }
    }

    @POST
    @Transactional
    public Response guardarPersona(Persona persona){
        List<Persona> personaExiste = directorio.findPersonaByIdentificacion(persona.getIdentificacion());
        if (personaExiste.isEmpty()){
            directorio.storePersona(persona);
            logger.debug("Guardado con exito");
            return Response.ok(persona).build();
        }else{
            logger.error("La persona ya esta registrada");
            return Response.status(500).entity("La persona ya esta registrada").build();
        }

    }
}
