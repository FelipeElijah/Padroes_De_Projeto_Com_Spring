package felipe.padroesDeProjeto.padroesdeprojetocomspring.service.Implementacao;

import felipe.padroesDeProjeto.padroesdeprojetocomspring.Model.Cliente;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.Model.Endereco;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.repository.ClienteRepository;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.repository.EnderecoRepository;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.service.ClienteService;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Optional;

@Service
public class ClienteServiceImplementacao implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarCliente(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarCliente(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public void salvarCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
