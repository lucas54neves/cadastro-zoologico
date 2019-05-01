package Animais;

import java.util.*;

public abstract class Animal {
    private static int contador = 0;
    private int codigo;
    private String nome;
    private String especie;
    private String sexo;
    private Date data_nascimento;
    private int idade;

    public Animal(String nome, String especie, String sexo, Date data_nascimento) {
        Animal.contador++;
        this.codigo = contador;
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

    public static void setContador(int contador) {
        Animal.contador = contador;
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
