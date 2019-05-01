package Animais;

import java.util.*;

public class Mamifero extends Animal {
    private boolean em_gestacao;
    
    public Mamifero(String nome, String especie, String sexo, Date data_nascimento, boolean em_gestacao) {
        super(nome, especie, sexo, data_nascimento);
        this.em_gestacao = em_gestacao;
    }

    public boolean isEm_gestacao() {
        return em_gestacao;
    }

    public void setEm_gestacao(boolean em_gestacao) {
        this.em_gestacao = em_gestacao;
    }
    
    @Override
    public String toString() {
        String retorno = "Código do animal: " + getCodigo() + "\n";
        retorno += "Nome do animal: " + getNome() + "\n";
        retorno += "Espécie do animal: " + getEspecie() + "\n";
        retorno += "Sexo do animal: " + getSexo() + "\n";
        if ("Fêmea".equals(getEspecie())) {
            retorno += "Em gestação: " + isEm_gestacao() + "\n";
        }
        retorno += "Data de nascimento do animal: " + getData_nascimento() + "\n";
        retorno += "Idade do animal: " + getIdade();
        
        return retorno;
    }
}
