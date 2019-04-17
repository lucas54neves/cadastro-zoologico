package Funcionarios;

public class Loja {
    private final String nome;
    private Vendedor vendedor;
    private String nome_produto;
    private double preco_produto;

    public Loja(String nome, Vendedor vendedor, String nome_produto, double preco_produto) {
        this.nome = nome;
        this.vendedor = vendedor;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
    }

    public String getNome() {
        return nome;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }
    
    
}
