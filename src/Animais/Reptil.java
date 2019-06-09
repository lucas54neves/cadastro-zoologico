package Animais;

import Zoologico.Zoologico;
import java.util.Date;

public class Reptil extends Animal {
    // O réptil pode ser classificado em escamoso, crocodiliano ou quelônio
    private String tipo_animal;
    private boolean aquatico;
    
    public Reptil(Zoologico zoo, String nome, String especie, String sexo, Date data_nascimento, String tipo_animal, boolean aquatico) {
        super(zoo, nome, especie, sexo, data_nascimento);
        this.tipo_animal = tipo_animal;
        this.aquatico = aquatico;
    }

    public String getTipo_animal() {
        return tipo_animal;
    }

    public boolean isAquatico() {
        return aquatico;
    }

    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }

    public void setAquatico(boolean aquatico) {
        this.aquatico = aquatico;
    }
    
    @Override
    public String toString() {
        return
            "\n" +
            "==================================\n" +
            "Código: " + getCodigo() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Espécie: " + getEspecie() + "\n" +
            "Tipo: " + getTipo_animal() + "\n" +
            "Aquático: " + isAquatico() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Idade do animal: " + getIdade() + "\n" +
            "==================================";
    }
}
