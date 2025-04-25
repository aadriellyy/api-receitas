package com.example.receitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.receitas.dto.IngredienteDTO;
import com.example.receitas.entity.Ingrediente;
import com.example.receitas.service.IngredienteService;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping
    public ResponseEntity<Ingrediente> criar(@RequestBody IngredienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ingredienteService.criarIngrediente(dto));
    }

    @GetMapping
    public List<Ingrediente> listarTodos() {
        return ingredienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> buscarPorId(@PathVariable Long id) {
        return ingredienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> atualizar(@PathVariable Long id, @RequestBody IngredienteDTO dto) {
        return ResponseEntity.ok(ingredienteService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ingredienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

