package Animais;

import Zoologico.Zoologico;
import java.util.*;

public class Anfibio extends Animal {
    private boolean venenoso;
    
    public Anfibio(Zoologico zoo, String nome, String especie, String sexo, Date data_nascimento, boolean venenoso) {
        super(zoo, nome, especie, sexo, data_nascimento);
        this.venenoso = venenoso;
    }

    public boolean isVenenoso() {
        return venenoso;
    }

    public void setVenenoso(boolean venenoso) {
        this.venenoso = venenoso;
    }
    
    @Override
    public String toString() {
        return
            "\n" +
            "==================================\n" +
            "Código: " + getCodigo() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Espécie: " + getEspecie() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Idade do animal: " + getIdade() + "\n" +
            "Venenoso: " +  isVenenoso() + "\n" +
            "==================================";
    }
}
