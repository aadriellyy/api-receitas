package main.java.com.example.receitas.dto;

import java.util.List;

public record ReceitaDTO(String nome, String modoPreparo, List<ItemReceitaDTO> ingredientes) {}

