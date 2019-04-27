package Animais;

import java.util.*;

public abstract class Animal {
    private final int codigo;
    private final String nome;
    private final String especie;
    private final String sexo;
    private final Date data_nascimento;
    private int idade;

    public Animal(int codigo, String nome, String especie, String sexo, Date data_nascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.idade = calculaIdade();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }
    
    public abstract String getTipo_animal();
    
    private int calculaIdade() {
        // Cria um objeto Calendar com a data de nascimento
        Calendar dataNasc = new GregorianCalendar();
        dataNasc.setTime(getData_nascimento());
        
        // Cria um objeto Calendar com a data atual
        Calendar dataAtual = Calendar.getInstance();
        
        // Obtém a idade baseado no ano
        int idade = dataAtual.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        
        // Corrige caso o animal já tenha feito aniversário no ano
        if (dataAtual.get(Calendar.MONTH) <= dataNasc.get(Calendar.MONTH) &&
            dataAtual.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH)) {
            idade--;
        }
        
        // Retorna a idade
        return idade;
    }
    
    public abstract String conversao_string();
    
    @Override
    public String toString() {
        return conversao_string();
    }
}
