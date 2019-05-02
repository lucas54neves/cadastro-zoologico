package Funcionarios;

import Animais.*;
import java.util.*;

public class Tratador extends Funcionario {
    private double salario;
    private int id;
    private final List<Setor> setores;
    
    public Tratador(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao) {
        super(cpf, nome, sexo, data_nascimento, data_admissao);
        this.salario = calculo_salario();
        Funcionario.contador++;
        this.id = Funcionario.contador;
        this.setores = new LinkedList<>();
    }

    public double getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void adicionar_setor(Setor setor) {
        getSetores().add(setor);
    }
    
    @Override
    public String toString() {
        return
            "ID do funcionário: " + getId() + "\n" +
            "Função: " + retorna_funcao() + "\n" +
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
    
    public void imprime_setores() {
        for (int i = 0; i < getSetores().size(); i++) {
            System.out.println(getSetores().get(i));
        }
    }
}
