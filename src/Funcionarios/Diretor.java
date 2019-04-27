package Funcionarios;

import java.util.*;

public class Diretor extends Funcionario {
    private String diretoria;
    private double salario;
    
    public Diretor(String cpf, String nome, String sexo, Date data_nascimento, Date data_adminicao, String diretoria) {
        super(cpf, nome, sexo, data_nascimento, data_adminicao, "Diretor");
        this.diretoria = diretoria;
        this.salario = 20000;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public double getSalario() {
        return salario;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
