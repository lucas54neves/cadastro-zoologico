package Animais;

import Zoologico.Zoologico;
import java.io.*;
import java.util.*;

public abstract class Animal implements Serializable  {
    private int codigo;
    private String nome;
    private String especie;
    private String sexo;
    private Date data_nascimento;
    private int idade;
    private Setor setor;

    public Animal(Zoologico zoo, String nome, String especie, String sexo, Date data_nascimento) {
        this.codigo = zoo.getAnimais().size()+1;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.idade = calculaIdade();
        this.setor = null;
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

    public Setor getSetor() {
        return setor;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
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
}
