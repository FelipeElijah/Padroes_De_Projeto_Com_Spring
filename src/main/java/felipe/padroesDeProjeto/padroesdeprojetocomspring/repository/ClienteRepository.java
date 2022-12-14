package felipe.padroesDeProjeto.padroesdeprojetocomspring.repository;

import felipe.padroesDeProjeto.padroesdeprojetocomspring.Model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findAllById(Long id);
}