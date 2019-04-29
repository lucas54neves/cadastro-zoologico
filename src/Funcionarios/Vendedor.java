package Funcionarios;

import java.util.*;

public class Vendedor extends Funcionario {
    private double comissao;
    private final double salario_inicial;
    private double salario_final;
    private double quantidade_vendas;
    private int id_loja;
    private int id;
    
    public Vendedor(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao, int id_loja) {
        super(cpf, nome, sexo, data_nascimento, data_admissao, "Vendedor");
        this.salario_inicial = 1000;
        this.comissao = 1.15;
        this.quantidade_vendas = 0;
        this.id_loja = id_loja;
        super.contador++;
        this.id = super.contador;
        this.salario_final = calcularSalario();
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

    public int getId_loja() {
        return id_loja;
    }

    public int getId() {
        return id;
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
        
        return getSalario_inicial() + getQuantidade_vendas() * getComissao();
    }
    
    @Override
    public String toString() {
        return
            "ID do funcionário: " + getId() + "\n" +
            "Função: " + getFuncao() + "\n" +
            "Loja: " + getId_loja() + "\n" +
            "Nome: " + getNome() + "\n" +
            "CPF: " + getCpf() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Data de admissão: " + getData_admissao() + "\n" +
            "Salário: " + getSalario_final()+ "\n" +
            "Idade: " + getIdade();
    }
}
