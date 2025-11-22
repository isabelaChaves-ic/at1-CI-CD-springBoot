package com.isabela.at1_t2_tarefas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class At1T2TarefasApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Teste da Rota 1: Listar
    @Test
    void deveListarTarefas() throws Exception {
        mockMvc.perform(get("/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descricao").value("Estudar Spring Boot"));
    }

    // Teste da Rota 2: Buscar por ID
    @Test
    void deveBuscarTarefaPorId() throws Exception {
        mockMvc.perform(get("/tarefas/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Fazer AT1 T2"));
    }

    // Teste da Rota 3: Criar (POST)
    @Test
    void deveCriarTarefa() throws Exception {
        Tarefa nova = new Tarefa(3, "Enviar atividade");
        
        mockMvc.perform(post("/tarefas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nova)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Enviar atividade"));
    }
}