package com.example.receitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.receitas.dto.ItemReceitaDTO;
import com.example.receitas.entity.Ingrediente;
import com.example.receitas.entity.ItemReceita;
import com.example.receitas.entity.Receita;
import com.example.receitas.repository.IngredienteRepository;
import com.example.receitas.repository.ItemReceitaRepository;
import com.example.receitas.repository.ReceitaRepository;

@Service
public class ItemReceitaService {

    @Autowired
    private ItemReceitaRepository itemReceitaRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public ItemReceita adicionarItem(Long receitaId, ItemReceitaDTO dto) {
        Receita receita = receitaRepository.findById(receitaId)
            .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        Ingrediente ingrediente = ingredienteRepository.findById(dto.ingredienteId())
            .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

        ItemReceita item = new ItemReceita();
        item.setReceita(receita);
        item.setIngrediente(ingrediente);
        item.setQuantidade(dto.quantidade());

        return itemReceitaRepository.save(item);
    }

    public ItemReceita atualizarQuantidade(Long itemId, double novaQuantidade) {
        ItemReceita item = itemReceitaRepository.findById(itemId)
            .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        item.setQuantidade(novaQuantidade);
        return itemReceitaRepository.save(item);
    }

    public void deletarItem(Long itemId) {
        itemReceitaRepository.deleteById(itemId);
    }

    public List<ItemReceita> listarItensPorReceita(Long receitaId) {
        return itemReceitaRepository.findAll()
            .stream()
            .filter(item -> item.getReceita().getId().equals(receitaId))
            .toList();
    }
}
