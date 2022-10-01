package br.com.carrinhocompras.resource.dto;


import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ItemDto {

    private Long produtoId;
    private int quantidade;
    private Long idSacola;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return quantidade == itemDto.quantidade && Objects.equals(produtoId, itemDto.produtoId) && Objects.equals(idSacola, itemDto.idSacola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId, quantidade, idSacola);
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdSacola() {
        return idSacola;
    }

    public void setIdSacola(Long idSacola) {
        this.idSacola = idSacola;
    }
}
