package Funcionarios;

import java.util.*;

public class Cuidador extends Funcionario {
    private int setor;
    private double salario;
    
    public Cuidador(String cpf, String nome, String sexo, Date data_nascimento, int setor) {
        super(cpf, nome, sexo, data_nascimento, new Date(), "Cuidador");
        this.setor = setor;
        this.salario = 2500;
    }

    public int getSetor() {
        return setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
