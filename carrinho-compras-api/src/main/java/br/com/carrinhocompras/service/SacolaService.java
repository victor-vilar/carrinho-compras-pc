package br.com.carrinhocompras.service;

import br.com.carrinhocompras.enumerator.FormaPagamento;
import br.com.carrinhocompras.model.Item;
import br.com.carrinhocompras.model.Restaurante;
import br.com.carrinhocompras.model.Sacola;
import br.com.carrinhocompras.repository.ItemRepository;
import br.com.carrinhocompras.repository.ProdutoRepository;
import br.com.carrinhocompras.repository.SacolaRepository;
import br.com.carrinhocompras.resource.dto.ItemDto;
import org.springframework.stereotype.Service;

@Service
public class SacolaService {

    private final SacolaRepository repository;
    private final ProdutoRepository produtoRepositorio;
    private final ItemRepository itemRepositorio;

    public SacolaService(ItemRepository itemRepositorio, SacolaRepository repositorio,ProdutoRepository produtoRepositorio){
        this.repository =repositorio;
        this.produtoRepositorio = produtoRepositorio;
        this.itemRepositorio = itemRepositorio;
    }

    public Sacola verSacola(Long id){

        return repository.findById(id).orElseThrow(
                () -> { throw new RuntimeException("Essa Sacola Não Existe !");}
        );
    }

    public Sacola fecharSacola(long id, int formaDePagamento){

        Sacola sacola = verSacola(id);

        if(sacola.getItens().isEmpty()){

            throw new RuntimeException("Inclua itens na sacola");

        }

        FormaPagamento fPagamento = formaDePagamento == 0 ? FormaPagamento.DINHEIRO: FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(fPagamento);
        sacola.setFechada(true);


        return repository.save(sacola);

    }

    public Item incluirItemSacola(ItemDto itemDto){

        Sacola sacola = verSacola(itemDto.getIdSacola());

        if(sacola.isFechada()){
            throw new RuntimeException("Esta sacola esta fechada");
        }

        Item item = new Item();
        item.setProduto(produtoRepositorio.findById(itemDto.getProdutoId()).orElseThrow(
                () -> { throw new RuntimeException("Essa Produto Não Existe !");}
        ));
        item.setQuantidade(itemDto.getQuantidade());
        item.setSacola(verSacola(itemDto.getIdSacola()));

        if(sacola.getItens().isEmpty()){
            sacola.getItens().add(item);
        }else{
            Restaurante restaurante = sacola.getItens().get(0).getProduto().getRestaurante();
            if(item.getProduto().getRestaurante().equals(restaurante)){
                sacola.getItens().add(item);
            }else{
                throw new RuntimeException("Não é possível adicionar produtos de restaurante diferentes." +
                        "Feche a sacola ou esvazie !");
            }
        }

        repository.save(sacola);
        itemRepositorio.save(item);
        return item;

    }

}
