package felipe.padroesDeProjeto.padroesdeprojetocomspring.repository;

import felipe.padroesDeProjeto.padroesdeprojetocomspring.Model.Cliente;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.Model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
