package Funcionarios;

import java.util.*;

public class Diretor extends Funcionario {
    private double salario;
    private int id;
    
    public Diretor(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao) {
        super(cpf, nome, sexo, data_nascimento, data_admissao);
        this.salario = calculo_salario();
        Funcionario.contador++;
        this.id = Funcionario.contador;
    }

    public double getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return
            "\n" +
            "==================================" +
            "ID do funcionário: " + getId() + "\n" +
            "Função: " + retorna_funcao() + "\n" +
            "Nome: " + getNome() + "\n" +
            "CPF: " + getCpf() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Data de admissão: " + getData_admissao() + "\n" +
            "Salário: " + getSalario() + "\n" +
            "Idade: " + getIdade() + "\n" +
            "==================================";
    }

    @Override
    public final double calculo_salario() {
        return 20000;
    }
    
    @Override
    public String retorna_funcao() {
        return "Diretor";
    }
}
