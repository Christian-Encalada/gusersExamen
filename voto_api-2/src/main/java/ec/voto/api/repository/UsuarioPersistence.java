package ec.voto.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ec.voto.api.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioPersistence extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findById(String id);
    List<Usuario> findByRolNombre(String nombreRol);
}



