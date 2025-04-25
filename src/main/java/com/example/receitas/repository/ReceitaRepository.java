package com.example.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.receitas.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {}

