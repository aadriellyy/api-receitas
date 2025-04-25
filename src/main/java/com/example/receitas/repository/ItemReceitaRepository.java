package com.example.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.receitas.entity.ItemReceita;

public interface ItemReceitaRepository extends JpaRepository<ItemReceita, Long> {}

