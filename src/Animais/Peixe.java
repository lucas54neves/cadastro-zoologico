package Animais;

import java.util.Date;

public class Peixe extends Animal {
    // O peixe pode ser classificado em peixe água doce ou salgada
    private String tipo_agua;

    public Peixe(String nome, String especie, String sexo, Date data_nascimento, String tipo_agua) {
        super(nome, especie, sexo, data_nascimento);
        this.tipo_agua = tipo_agua;
    }

    public String getTipo_agua() {
        return tipo_agua;
    }

    public void setTipo_agua(String tipo_agua) {
        this.tipo_agua = tipo_agua;
    }
    
    @Override
    public String toString() {
        return
            "\n" +
            "==================================" +
            "Código: " + getCodigo() + "\n" +
            "Nome: " + getNome() + "\n" +
            "Espécie: " + getEspecie() + "\n" +
            "Tipo de água: " + getTipo_agua() + "\n" +
            "Sexo: " + getSexo() + "\n" +
            "Data de nascimento: " + getData_nascimento() + "\n" +
            "Idade: " + getIdade() + "\n" +
            "==================================";
    }
}
