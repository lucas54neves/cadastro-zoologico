package Animais;

import java.util.Date;

public class Reptil extends Animal {
    // O réptil pode ser classificado em escamoso, crocodiliano ou quelônio
    private String tipo_animal;
    
    public Reptil(String nome, String especie, String sexo, Date data_nascimento, String tipo_animal) {
        super(nome, especie, sexo, data_nascimento);
        this.tipo_animal = tipo_animal;
    }

    public String getTipo_animal() {
        return tipo_animal;
    }

    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }
    
    @Override
    public String toString() {
        return
            "Código: " + getCodigo() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Espécie: " + getEspecie() + "\n" +
            "Tipo: " + getTipo_animal() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Idadel: " + getIdade();
    }
}
