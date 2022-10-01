package br.com.carrinhocompras.service;

import br.com.carrinhocompras.enumerator.FormaPagamento;
import br.com.carrinhocompras.model.Item;
import br.com.carrinhocompras.model.Sacola;
import br.com.carrinhocompras.repository.SacolaRepository;
import br.com.carrinhocompras.resource.dto.ItemDto;
import org.springframework.stereotype.Service;

@Service
public class SacolaService {

    private final SacolaRepository repository;

    public SacolaService(){
        this.repository = new SacolaRepository() {
        };
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

        return sacola;

    }

    public Item incluirItemSacola(ItemDto itemDto){

    }

}
