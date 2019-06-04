package Animais;

import Zoologico.Zoologico;
import java.util.*;

public class Anfibio extends Animal {
    public Anfibio(Zoologico zoo, String nome, String especie, String sexo, Date data_nascimento) {
        super(zoo, nome, especie, sexo, data_nascimento);
    }
    
    @Override
    public String toString() {
        return
            "\n" +
            "==================================" +
            "Código: " + getCodigo() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Espécie: " + getEspecie() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Idade: " + getIdade() + "\n" +
            "==================================";
    }
}
