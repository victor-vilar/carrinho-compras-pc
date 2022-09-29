package br.com.carrinhocompras.repository;

import br.com.carrinhocompras.model.Cliente;
import br.com.carrinhocompras.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
