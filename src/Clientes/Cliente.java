package Clientes;

import Funcionarios.*;
import java.util.*;

public class Cliente {
    private final int id;
    private final String nome;
    private double valor_gasto;
    private final List setores_visitados;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.valor_gasto = 0;
        this.setores_visitados = new LinkedList();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor_gasto() {
        return valor_gasto;
    }

    public void setValor_gasto(double valor_gasto) {
        this.valor_gasto = valor_gasto;
    }

    public List getSetores_visitados() {
        return setores_visitados;
    }
    
    public void Comprar(Vendedor vendedor, Loja loja, String nome_produto, int quantidade) {
        try {
            if ((loja.getNome_produto() == null || nome_produto == null) || !loja.getNome_produto().equals(nome_produto)) {
                throw new IllegalArgumentException("Não existe esse produto na loja.");
            } else {
                this.setValor_gasto(this.getValor_gasto() + loja.getPreco_produto() * quantidade);
                vendedor.setQuantidade_vendas(vendedor.getQuantidade_vendas() + loja.getPreco_produto() * quantidade);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Visitar(int idSetor) {
        setores_visitados.add(idSetor);
    }
}
