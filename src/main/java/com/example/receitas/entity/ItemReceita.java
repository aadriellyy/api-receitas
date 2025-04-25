package main.java.com.example.receitas.entity;

public class ItemReceita {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Receita receita;

    @ManyToOne
    private Ingrediente ingrediente;

    private double quantidade;

}
