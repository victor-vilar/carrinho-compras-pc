package br.com.carrinhocompras.resource;


import br.com.carrinhocompras.model.Item;
import br.com.carrinhocompras.model.Sacola;
import br.com.carrinhocompras.resource.dto.ItemDto;
import br.com.carrinhocompras.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sacolas")
public class SacolaResource {

    private final SacolaService service;

    public SacolaResource(SacolaService service){

        this.service = service;

    }

    @PostMapping
    public Item incluirItemSacola(@RequestBody ItemDto itemDto){

        return service.incluirItemSacola(itemDto);

    }

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id){

        return service.verSacola(id);

    }

    @PatchMapping("/fecharsacola/{id}")
    public Sacola fecharSacola(@PathVariable("id") Long id,@RequestParam("formaPagamento") int formaPagamento){

        return service.fecharSacola(id,formaPagamento);

    }



}
