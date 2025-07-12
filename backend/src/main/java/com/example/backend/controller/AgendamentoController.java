package com.example.backend.controller;

import com.example.backend.model.gerenciadores.Agendamento;
import com.example.backend.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController() {
        this.agendamentoService = new AgendamentoService();
    }

    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listar();
    }

    @PostMapping
    public void agendarConsulta(@RequestBody Agendamento agendamento) {
        agendamentoService.agendar(agendamento);
    }

    @DeleteMapping("/{id}")
    public void cancelarConsulta(@PathVariable int id) {
        agendamentoService.cancelar(id);
    }

    @GetMapping("/{id}")
    public Agendamento getAgendamento(@PathVariable int id) {
        return agendamentoService.buscar(id);
    }

    @PutMapping("/{id}")
    public void editarAgendamento(@PathVariable int id, @RequestBody Agendamento novo) {
        agendamentoService.editar(id, novo);
    }

}
