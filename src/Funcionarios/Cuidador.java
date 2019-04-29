package Funcionarios;

import java.util.*;

public class Cuidador extends Funcionario {
    private int setor;
    private double salario;
    private int id;
    
    public Cuidador(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao, int setor) {
        super(cpf, nome, sexo, data_nascimento, data_admissao, "Cuidador");
        this.setor = setor;
        this.salario = 2500;
        super.contador++;
        this.id = super.contador;
    }

    public int getSetor() {
        return setor;
    }

    public double getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return
            "ID do funcionário: " + getId() + "\n" +
            "Função: " + getFuncao() + "\n" +
            "Setor: " + getSetor() + "\n" +
            "Nome: " + getNome() + "\n" +
            "CPF: " + getCpf() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Data de admissão: " + getData_admissao() + "\n" +
            "Salário: " + getSalario() + "\n" +
            "Idade: " + getIdade();
    }
}
