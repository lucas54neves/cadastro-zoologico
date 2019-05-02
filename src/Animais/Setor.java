package Animais;

import java.io.Serializable;
import java.util.*;

public class Setor implements Serializable {
    private final List<Animal> animais;
    private final int id;
    private static int contador = 0;
    private String especie;

    public Setor(String especie) {
        Setor.contador++;
        this.id = Setor.contador;
        this.animais = new LinkedList<>();
        this.especie = especie;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public int retorna_quantidade_animais() {
        return getAnimais().size();
    }
    
    @Override
    public String toString() {
        return
            "=== Setor " + getId() + " ===\n" +
            "Quantidade de animais: " + retorna_quantidade_animais() + "\n" +
            "Espécie de animais: " + getEspecie();
    }
    
    public void imprime_animais() {
        System.out.println("=== Setor " + getId() + " ===");
        
        for (int i = 0; i < retorna_quantidade_animais(); i++) {
            System.out.println(getAnimais().get(i));
        }
    }
    
    public void adicionar(Animal animal) {
        getAnimais().add(animal);
    }
}
