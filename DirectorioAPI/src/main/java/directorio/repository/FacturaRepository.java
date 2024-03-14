package directorio.repository;

import directorio.model.Factura;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FacturaRepository implements PanacheRepository<Factura> {

}
