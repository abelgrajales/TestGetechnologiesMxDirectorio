package directorio.controller;

import directorio.Service.Directorio;
import directorio.Service.Ventas;
import directorio.model.Factura;
import directorio.model.Persona;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("api/v1/factura")
public class FacturaRestService {

    private static Logger logger = LoggerFactory.getLogger(FacturaRestService.class);
    @Inject
    Ventas ventas;

    @Inject
    Directorio directorio;

    @GET
    @Path("/{identificacion}")
    public Response findFacturasByPersona(@PathParam("identificacion") String identificacion){
        List<Persona> persona = directorio.findPersonaByIdentificacion(identificacion);

        if (!persona.isEmpty()){
            List<Factura> facturas = ventas.findFacturasByPersona(persona.get(0));
            for (Factura factura : facturas){
                logger.debug(factura.getFecha().toString());
                logger.debug(String.valueOf(factura.getMonto()));
            }
            return Response.ok(facturas).entity(facturas).build();
        }else {
            logger.error("No hay facturas");
            return Response.status(404).entity("No hay facturas").build();
        }

    }

    @POST
    @Transactional
    public Response guardarFactura(Factura factura){
        ventas.storeFactura(factura);
        logger.debug("Guardado con exito");
        return Response.ok(factura).build();
    }
}
