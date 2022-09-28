package br.com.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;
    private double valorUnitario;

    @Builder.Default
    private Boolean disponivel = true;

    @ManyToOne
    @JsonIgnore
    private Restaurante restaurante;


}
