package directorio.Service;

import directorio.model.Factura;
import directorio.model.Persona;
import directorio.repository.FacturaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class Ventas {

    @Inject
    FacturaRepository facturaRepository;

    public List<Factura> findFacturasByPersona(Persona persona){
        return facturaRepository.list("persona", persona);
    }

    public void storeFactura(Factura factura){
        facturaRepository.persist(factura);
    }

}
