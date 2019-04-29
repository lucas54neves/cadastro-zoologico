package Animais;

import java.util.*;

public class Mamifero extends Animal {
    private final String tipo_animal;
    
    public Mamifero(int id, String nome, String especie, String sexo, Date data_nascimento) {
        super(id, nome, especie, sexo, data_nascimento);
        this.tipo_animal = "Mamífero";
    }

    @Override
    public String getTipo_animal() {
        return tipo_animal;
    }
    
    @Override
    public String toString() {
        return "Código do animal: " + getCodigo() + "\n" +
            "Nome do animal: " + getNome() + "\n" +
            "Tipo do animal: " + getTipo_animal() + "\n" +
            "Espécie do animal: " + getEspecie() + "\n" +
            "Sexo do animal: " + getSexo() + "\n" +
            "Data de nascimento do animal: " + getData_nascimento() + "\n" +
            "Idade do animal: " + getIdade();
    }
}
