package com.isabela.at1_t2_tarefas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();

    public TarefaController() {
        tarefas.add(new Tarefa(1, "Estudar Spring Boot"));
        tarefas.add(new Tarefa(2, "Fazer AT1 T2"));
    }

    // ROTA 1: Listar todas (GET)
    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefas;
    }

    // ROTA 2: Buscar por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Integer id) {
        Optional<Tarefa> tarefa = tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
        
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ROTA 3: Criar nova tarefa (POST)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa novaTarefa) {
        tarefas.add(novaTarefa);
        return novaTarefa;
    }
}