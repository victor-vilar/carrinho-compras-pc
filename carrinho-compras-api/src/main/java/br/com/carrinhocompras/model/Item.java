package br.com.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="item")
public class Item {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Produto produto;
    private int quantidade;

    @ManyToOne
    @JsonIgnore
    private Sacola sacola;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Sacola getSacola() {
        return sacola;
    }

    public void setSacola(Sacola sacola) {
        this.sacola = sacola;
    }


    public Item(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantidade == item.quantidade && Objects.equals(id, item.id) && Objects.equals(produto, item.produto) && Objects.equals(sacola, item.sacola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, quantidade, sacola);
    }
}
