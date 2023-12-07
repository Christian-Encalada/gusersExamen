package ec.voto.api.repository;

import ec.voto.api.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RolPersistence extends JpaRepository<Rol, String> {
    Optional<Rol> findById(String id);
    Optional<Rol> findByNombre(String nombre);

}



