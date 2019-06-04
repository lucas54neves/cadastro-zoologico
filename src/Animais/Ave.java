package Animais;

import Zoologico.Zoologico;
import java.util.*;

public class Ave extends Animal {
    private boolean voa;
    
    public Ave(Zoologico zoo, String nome, String especie, String sexo, Date data_nascimento, boolean voa) {
        super(zoo, nome, especie, sexo, data_nascimento);
        this.voa = voa;
    }

    public boolean isVoa() {
        return voa;
    }

    public void setVoa(boolean voa) {
        this.voa = voa;
    }
    
    @Override
    public String toString() {
        return
            "\n" +
            "==================================" +
            "Código: " + getCodigo() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Espécie: " + getEspecie() + "\n" +
            "Voa:" + isVoa() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Idade: " + getIdade() + "\n" +
            "==================================";
    }
}
