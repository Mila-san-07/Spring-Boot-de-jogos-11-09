package br.pucrs.kamilah.s.exemplo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ACME")
public class ExemploController {
    private Acervo acervo;

    @Autowired
    public ExemploController(Acervo acervo) {
        this.acervo = acervo;        
    }

     @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/produto")
    public List<Produto> getProdutos() {
        return acervo.getProdutos();
    }

    @GetMapping("/codigos")
    public List<Integer> getCodigos(){
        return acervo.getCodigos();
    }
    
    @GetMapping("/tituloseano/{titulo}/ano/{ano}")
    public List<Produto> getTitulosdoAno(@PathVariable(value="titulo") String titulo,
                                        @PathVariable(value="ano")int ano) {
        return acervo.getTituloAno(titulo, ano);
    }

    @PostMapping("/novojogo")
    public boolean cadastraJogoNovo(@RequestBody final Produto produto) {
        return acervo.cadastraProdutoNovo(produto);
    }

    @GetMapping("/filtro")
    public List<Produto> filtrar(
        @RequestParam double num,
        @RequestParam String campo,
        @RequestParam String comparacao) {
            return acervo.getCodigoPrecoAno(num, campo, comparacao);
    }
}