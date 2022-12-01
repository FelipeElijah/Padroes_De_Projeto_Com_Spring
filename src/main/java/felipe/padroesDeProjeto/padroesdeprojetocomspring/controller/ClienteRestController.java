package felipe.padroesDeProjeto.padroesdeprojetocomspring.controller;

import felipe.padroesDeProjeto.padroesdeprojetocomspring.Model.Cliente;
import felipe.padroesDeProjeto.padroesdeprojetocomspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteHttp;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteHttp.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteHttp.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteHttp.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar (@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteHttp.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteHttp.deletar(id);
        return ResponseEntity.ok().build();
    }
}
