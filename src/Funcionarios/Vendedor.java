package Funcionarios;

import java.util.*;

public class Vendedor extends Funcionario {
    private double comissao;
    private final double salario_inicial;
    private double salario_final;
    private double quantidade_vendas;
    private int id_loja;
    
    public Vendedor(String cpf, String nome, String sexo, Date data_nascimento, Date data_adminicao, int id_loja) {
        super(cpf, nome, sexo, data_nascimento, data_adminicao, "Vendedor");
        this.salario_inicial = 1000;
        this.comissao = 1.15;
        this.quantidade_vendas = 0;
        this.id_loja = id_loja;
    }

    public double getComissao() {
        return comissao;
    }

    public double getSalario_inicial() {
        return salario_inicial;
    }

    public double getSalario_final() {
        return salario_final;
    }

    public double getQuantidade_vendas() {
        return quantidade_vendas;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public void setSalario_final(double salario_final) {
        this.salario_final = salario_final;
    }

    public void setQuantidade_vendas(double quantidade_vendas) {
        this.quantidade_vendas = quantidade_vendas;
    }
    
    public double calcularSalario() {
        if (this.getQuantidade_vendas() >= this.salario_inicial) {
            setComissao(this.getComissao() + 0.10);
        }
        
        return this.getSalario_inicial() + (this.getQuantidade_vendas() * this.getComissao());
    }
}
