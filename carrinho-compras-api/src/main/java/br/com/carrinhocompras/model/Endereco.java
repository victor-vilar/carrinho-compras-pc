package br.com.carrinhocompras.model;

import javax.persistence.*;
import java.util.Objects;


@Embeddable
public class Endereco {

    private String cep;
    private String complemento;

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep) && Objects.equals(complemento, endereco.complemento);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cep, complemento);
    }
}
