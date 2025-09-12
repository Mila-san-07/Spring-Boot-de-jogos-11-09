package br.pucrs.kamilah.s.exemplo;

import java.util.*;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
public class Acervo {
    private List<Produto> produtos;

    public Acervo() {
        produtos = new ArrayList<>();

        produtos.add(new Produto(111, "Among Us", "InnerSloth", 10.89, 2018));
        produtos.add(new Produto(222, "Battle Field", "Eletronic Arts", 39.89, 2018));
        produtos.add(new Produto(333, "Minecraft", "Mojang Studios", 9.90, 2011));
        produtos.add(new Produto(444, "Star Wars: Squadrons", "Eletric Arts", 106.94, 2020));
        produtos.add(new Produto(555, "Just Dance", "Ubisoft", 101.80, 2009));
        produtos.add(new Produto(666, "Assassin's Creed", "Ubisoft", 8.90, 2011));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public List<String> getCodigos() {
        return produtos.stream()
               .map(produto->produto.getCodigo())
               .toList().orElse(null);
    }

    public List<Produto> getTituloAno(String titulo,
                                        int ano) {
       return produtos.stream()
         .filter(produto->produto.getTitulo().equals(titulo))
         .filter(produto->produto.getAnoLanca() == ano)
         .toList();
    }

    public boolean cadastraProdutoNovo(Produto produto) {
        produtos.add(produto);
        return true;
    }

    //desafio 
    /*
    public List<Produto> getCodigoPrecoAno(double num, String campo, String comparacao) {
       return produtos.stream()
         .filter(produto->produto.getPreco() == num) //ver o ==
         .forEach(p -> {
            if(campo == "P"){
                System.out.println(p.getPreco());
            }else if(campo == "C"){
                System.out.println(p.getCodigo());
            } else if(campo == "A"){
                System.out.println(p.getAnoLanca());
            }
         })
         .forEach(d -> {
            if(comparacao == ">" ){
                System.out.println(d.getPreco());
            }else if(comparacao == "<"){
                System.out.println(d.getCodigo());
            }
         }) 
            
         
         .filter(produto->produto.getPreco() == (campo))
         .filter(produto->produto.getAno() == ano)
         .forEach(p -> {
            if()
         })
         .toList().orElse(null);
    } 
    */

   

}