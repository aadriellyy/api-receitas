package com.example.receitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.receitas.dto.IngredienteDTO;
import com.example.receitas.entity.Ingrediente;
import com.example.receitas.repository.IngredienteRepository;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente criarIngrediente(IngredienteDTO dto) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNome(dto.nome());
        ingrediente.setUnidadeMedida(dto.unidadeMedida());
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> listarTodos() {
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> buscarPorId(Long id) {
        return ingredienteRepository.findById(id);
    }

    public void deletar(Long id) {
        ingredienteRepository.deleteById(id);
    }

    public Ingrediente atualizar(Long id, IngredienteDTO dto) {
        Ingrediente ingrediente = ingredienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));
        ingrediente.setNome(dto.nome());
        ingrediente.setUnidadeMedida(dto.unidadeMedida());
        return ingredienteRepository.save(ingrediente);
    }
}

