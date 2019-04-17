package Funcionarios;

import java.util.*;

public abstract class Funcionario {
    private final String cpf;
    private final String nome;
    private final String sexo;
    private final Date data_adminicao;
    private final Date data_nascimento;
    private String funcao;
    private int idade;

    public Funcionario(String cpf, String nome, String sexo, Date data_nascimento, Date data_adminicao, String funcao) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.data_adminicao = data_adminicao;
        this.funcao = funcao;
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

    public Date getData_adminicao() {
        return data_adminicao;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String novaFuncao) {
        this.funcao = novaFuncao;
    }
    
    private int calculaIdade() {
        // Cria um objeto Calendar com a data de nascimento
        Calendar data_nascimento = new GregorianCalendar();
        data_nascimento.setTime(this.getData_nascimento());
        
        // Cria um objeto Calendar com a data atual
        Calendar dataAtual = Calendar.getInstance();
        
        // Obtém a idade baseado no ano
        int idade = dataAtual.get(Calendar.YEAR) - data_nascimento.get(Calendar.YEAR);
        
        // Corrige caso o funcionário não tenha feito aniversário no ano
        if (dataAtual.get(Calendar.MONTH) <= data_nascimento.get(Calendar.MONTH) &&
            dataAtual.get(Calendar.DAY_OF_MONTH) < data_nascimento.get(Calendar.DAY_OF_MONTH)) {
            idade--;
        }
        
        // Retorna a idade
        return idade;
    }
}
