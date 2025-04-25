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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.receitas.dto.ItemReceitaDTO;
import com.example.receitas.entity.ItemReceita;
import com.example.receitas.service.ItemReceitaService;

@RestController
@RequestMapping("/itens")
public class ItemReceitaController {

    @Autowired
    private ItemReceitaService itemService;

    @PostMapping("/receita/{receitaId}")
    public ResponseEntity<ItemReceita> adicionarIngrediente(
            @PathVariable Long receitaId,
            @RequestBody ItemReceitaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.adicionarItem(receitaId, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemReceita> atualizarQuantidade(
            @PathVariable Long id,
            @RequestParam double quantidade) {
        return ResponseEntity.ok(itemService.atualizarQuantidade(id, quantidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        itemService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/receita/{receitaId}")
    public List<ItemReceita> listarPorReceita(@PathVariable Long receitaId) {
        return itemService.listarItensPorReceita(receitaId);
    }
}
