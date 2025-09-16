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
    
    public List<Integer> getCodigos() {
        List<Integer> codigos = produtos.stream()
               .map(produto->produto.getCodigo())
               .toList();
        return codigos.isEmpty() ? null : codigos;

    }

    public List<Produto> getTituloAno(String titulo,
                                        int ano) {
       return produtos.stream()
         .filter(produto->produto.getTitulo().equalsIgnoreCase(titulo))
         .filter(produto->produto.getAnoLanca() == ano)
         .toList();
    }

    public boolean cadastraProdutoNovo(Produto produto) {
        produtos.add(produto);
        return true;
    }

    //desafio 
    public List<Produto> getCodigoPrecoAno(double num, String campo, String comparacao) {
       return produtos.stream()
         .filter(p ->{
            double valor = switch (campo){
            case "C" -> p.getCodigo();
            case "P" -> p.getPreco();
            case "A" -> p.getAnoLanca();
            default -> -1;
            };

            return switch (comparacao){
                case "<" -> valor < num;
                case "=" -> valor == num;
                case ">" -> valor > num;
                default -> false;
            };
         })
         .toList();
    }  

}