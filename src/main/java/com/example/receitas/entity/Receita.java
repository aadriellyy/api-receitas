package main.java.com.example.receitas.entity;

import java.util.ArrayList;
import java.util.List;

public class Receita {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String modoPreparo;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemReceita> ingredientes = new ArrayList<>();

}
