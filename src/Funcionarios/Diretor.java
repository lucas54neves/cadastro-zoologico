package Funcionarios;

import Zoologico.Zoologico;
import java.util.*;

public class Diretor extends Funcionario {
    private double salario;
    private int id;
    
    public Diretor(Zoologico zoo, String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao) {
        super(cpf, nome, sexo, data_nascimento, data_admissao);
        this.salario = calculo_salario();
        this.id = zoo.getFuncionarios().size()+1;
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
            "==================================\n" +
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
