package Funcionarios;

import java.util.*;

public class Diretor extends Funcionario {
    private String diretoria;
    private double salario;
    private int id;
    
    public Diretor(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao, String diretoria) {
        super(cpf, nome, sexo, data_nascimento, data_admissao, "Diretor");
        this.diretoria = diretoria;
        this.salario = 20000;
        super.contador++;
        this.id = super.contador;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public double getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return
            "ID do funcionário: " + getId() + "\n" +
            "Função: " + getFuncao() + "\n" +
            "Diretoria: " + getDiretoria() + "\n" +
            "Nome: " + getNome() + "\n" +
            "CPF: " + getCpf() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Data de admissão: " + getData_admissao() + "\n" +
            "Salário: " + getSalario() + "\n" +
            "Idade: " + getIdade();
    }
}
