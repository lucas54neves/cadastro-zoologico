package Animais;

import java.io.Serializable;
import java.util.*;

public class Setor implements Serializable, Comparable<Setor> {
    private final List<Animal> animais;
    private final int id;
    private static int contador = 0;
    private String especie;
    private int quantidade_visitas;

    public Setor(String especie) {
        Setor.contador++;
        this.id = Setor.contador;
        this.animais = new LinkedList<>();
        this.especie = especie;
        this.quantidade_visitas = 0;
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

    public int getQuantidade_visitas() {
        return quantidade_visitas;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setQuantidade_visitas(int quantidade_visitas) {
        this.quantidade_visitas = quantidade_visitas;
    }
    
    public int retorna_quantidade_animais() {
        return getAnimais().size();
    }
    
    @Override
    public String toString() {
        return
            "=== Setor " + getId() + " ===\n" +
            "Quantidade de animais: " + retorna_quantidade_animais() + "\n" +
            "Espécie de animais: " + getEspecie() + "\n" +
            "Quantidade de visitas: " + getQuantidade_visitas();
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
    
    @Override
    public int compareTo(Setor outro_setor) {
        if (getQuantidade_visitas() > outro_setor.getQuantidade_visitas()) {
            return -1;
        }
        
        if (getQuantidade_visitas() < outro_setor.getQuantidade_visitas()) {
            return 1;
        }
        
        return 0;
    }
}
