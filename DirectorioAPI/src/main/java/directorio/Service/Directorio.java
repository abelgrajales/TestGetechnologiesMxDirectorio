package directorio.Service;

import directorio.model.Persona;
import directorio.repository.PersonaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class Directorio {

    @Inject
    PersonaRepository personaRepository;

    public List<Persona> findPersonaByIdentificacion(String identificacion){
        return personaRepository.list("identificacion", identificacion);
    }

    public List<Persona> findPersonas() {
        return personaRepository.listAll();
    }

    public void deletePersonaByIdentificacion(Long id){
        personaRepository.deleteById(id);
    }

    public Persona storePersona(Persona persona){
        personaRepository.persist(persona);
        return persona;
    }
}
