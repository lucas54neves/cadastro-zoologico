package Animais;

import java.util.*;

public class Animal {
    private final int mCodigo;
    private final String mNome;
    private final String mEspecie;
    private final String mSexo;
    private final Date mDataNasc;
    private int mIdade;

    public Animal(int codigo, String nome, String especie, String sexo, Date dataNasc) {
        this.mCodigo = codigo;
        this.mNome = nome;
        this.mEspecie = especie;
        this.mSexo = sexo;
        this.mDataNasc = dataNasc;
        this.mIdade = this.calculaIdade();
    }

    public int getCodigo() {
        return mCodigo;
    }

    public String getNome() {
        return mNome;
    }

    public String getEspecie() {
        return mEspecie;
    }

    public String getSexo() {
        return mSexo;
    }

    public Date getDataNasc() {
        return mDataNasc;
    }
    
    public int getIdade() {
        return mIdade;
    }

    public void setIdade(int novaIdade) {
        this.mIdade = novaIdade;
    }
    
    private int calculaIdade() {
        // Cria um objeto Calendar com a data de nascimento
        Calendar dataNasc = new GregorianCalendar();
        dataNasc.setTime(this.getDataNasc());
        
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
