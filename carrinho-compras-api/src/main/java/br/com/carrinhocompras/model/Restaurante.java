package br.com.carrinhocompras.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> cardapio;

    @Embedded
    private Endereco endereco;

}
