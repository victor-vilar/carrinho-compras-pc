package br.com.carrinhocompras.repository;

import br.com.carrinhocompras.model.Cliente;
import br.com.carrinhocompras.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
