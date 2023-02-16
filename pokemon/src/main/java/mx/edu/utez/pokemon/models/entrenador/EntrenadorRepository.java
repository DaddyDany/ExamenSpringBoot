package mx.edu.utez.pokemon.models.entrenador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    boolean existsEntrenadorByNombre(String nombre);

}
