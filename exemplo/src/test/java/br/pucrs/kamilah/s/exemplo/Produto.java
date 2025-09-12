package br.pucrs.kamilah.s.exemplo;

public class Produto{
    private int codigo;
    private String titulo;
    private String empresa;
    private double preco;
    private int anoLanca;

    public Produto(int codigo, String titulo, String empresa, double preco, int anoLanca){
        this.codigo = codigo;
        this.titulo = titulo;
        this.empresa = empresa;
        this.preco = preco;
        this.anoLanca = anoLanca;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoLanca() {
        return anoLanca;
    }
    public void setAnoLanca(int anoLanca) {
        this.anoLanca = anoLanca;
    }

    @Override
    public String toString() {
        return "Produto = codigo: " + codigo + ", título: " + titulo + ", empresa: " + empresa + ", preço: " + preco + " e ano de lançamento: " + anoLanca;
    }
}