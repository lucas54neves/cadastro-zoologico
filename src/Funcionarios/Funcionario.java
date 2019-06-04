package Funcionarios;

import java.io.*;
import java.util.*;

public abstract class Funcionario  implements Serializable  {
    private String cpf;
    private String nome;
    private String sexo;
    private Date data_admissao;
    private Date data_nascimento;
    private int idade;

    public Funcionario(String cpf, String nome, String sexo, Date data_nascimento, Date data_admissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.data_admissao = data_admissao;
        this.idade = this.calculaIdade();
    }
    
    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSexo() {
        return this.sexo;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    private int calculaIdade() {
        // Cria um objeto Calendar com a data de nascimento
        Calendar nascimento = new GregorianCalendar();
        nascimento.setTime(this.getData_nascimento());
        
        // Cria um objeto Calendar com a data atual
        Calendar dataAtual = Calendar.getInstance();
        
        // Obtém a idade baseado no ano
        int i = dataAtual.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
        
        // Corrige caso o funcionário não tenha feito aniversário no ano
        if (dataAtual.get(Calendar.MONTH) <= nascimento.get(Calendar.MONTH) &&
            dataAtual.get(Calendar.DAY_OF_MONTH) < nascimento.get(Calendar.DAY_OF_MONTH)) {
            i--;
        }
        
        // Retorna a idade
        return i;
    }
    
    public abstract double calculo_salario();
    
    public abstract String retorna_funcao();
}
