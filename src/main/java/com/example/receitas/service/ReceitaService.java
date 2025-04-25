package com.example.receitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.receitas.dto.ItemReceitaDTO;
import com.example.receitas.dto.ReceitaDTO;
import com.example.receitas.entity.Ingrediente;
import com.example.receitas.entity.ItemReceita;
import com.example.receitas.entity.Receita;
import com.example.receitas.repository.IngredienteRepository;
import com.example.receitas.repository.ReceitaRepository;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Receita salvar(ReceitaDTO dto) {
        Receita receita = new Receita();
        receita.setNome(dto.nome());
        receita.setModoPreparo(dto.modoPreparo());

        for (ItemReceitaDTO itemDto : dto.ingredientes()) {
            Ingrediente ingrediente = ingredienteRepository.findById(itemDto.ingredienteId())
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado com ID: " + itemDto.ingredienteId()));

            ItemReceita item = new ItemReceita();
            item.setIngrediente(ingrediente);
            item.setQuantidade(itemDto.quantidade());
            item.setReceita(receita); // importante para bidirecionalidade

            receita.getIngredientes().add(item);
        }

        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodas() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> buscarPorId(Long id) {
        return receitaRepository.findById(id);
    }

    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }

    // Atualização de receita pode ser semelhante ao salvar, só buscar a receita antes e limpar os ingredientes antigos.
}
