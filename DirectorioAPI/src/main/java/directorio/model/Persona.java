package directorio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "persona")
public class Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidoPaterno;

    private String apellidoMaterno;

    @NotNull
    private String identificacion;

    @JsonIgnoreProperties("persona")
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Persona() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public List<Factura> getFacturas() {
        return this.facturas = facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

}
