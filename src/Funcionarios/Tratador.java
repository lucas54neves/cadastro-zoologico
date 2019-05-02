package Funcionarios;

import Animais.*;
import java.util.*;

public class Tratador extends Funcionario {
    private int setor;
    private double salario;
    private int id;
    private List<Animal> animais_tratados;
    
    public Tratador(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao, int setor) {
        super(cpf, nome, sexo, data_nascimento, data_admissao, "Tratador");
        this.setor = setor;
        this.salario = calculo_salario();
        Funcionario.contador++;
        this.id = Funcionario.contador;
        this.animais_tratados = new LinkedList<>();
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

    public List<Animal> getAnimais_tratados() {
        return animais_tratados;
    }

    public void setSetor(int setor) {
        this.setor = setor;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimais_tratados(List<Animal> animais_tratados) {
        this.animais_tratados = animais_tratados;
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

    @Override
    public final double calculo_salario() {
        return 10000;
    }
    
    @Override
    public String retorna_funcao() {
        return "Tratador";
    }
    
    public void imprime_animais_tratados() {
        for (int i = 0; i < getAnimais_tratados().size(); i++) {
            System.out.println(getAnimais_tratados().get(i));
        }
    }
}
