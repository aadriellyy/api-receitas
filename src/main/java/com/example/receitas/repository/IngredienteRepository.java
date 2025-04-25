package com.example.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.receitas.entity.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {}
