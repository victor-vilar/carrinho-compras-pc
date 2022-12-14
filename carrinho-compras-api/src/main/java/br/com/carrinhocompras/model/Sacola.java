package br.com.carrinhocompras.model;

import br.com.carrinhocompras.enumerator.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.List;

@Entity
@Table(name = "sacola")
public class Sacola {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch= FetchType.LAZY, optional=false)
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(cascade= CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal = 0.0;
    @Enumerated
    private FormaPagamento formaPagamento;
    private boolean fechada;
    public Sacola(){

    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public boolean isFechada() {
        return fechada;
    }
    public void setFechada(boolean fechada) {
        this.fechada = fechada;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void adicionarItem(Item item){
        this.valorTotal+= item.getQuantidade() * item.getProduto().getValorUnitario();
        this.itens.add(item);
    }
}
