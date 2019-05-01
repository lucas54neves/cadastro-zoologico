package Animais;

import Funcionarios.*;
import java.util.*;

public class Setor {
    private int id;
    private String especie_animais;
    private Funcionario responsavel;
    private int quantidade_animais;
    private List<Animal> lista_animais;
    private static int contador = 0;

    public Setor(String especie_animais, Funcionario responsavel) {
        this.especie_animais = especie_animais;
        this.responsavel = responsavel;
        this.lista_animais = new LinkedList<>();
        Setor.contador++;
        this.id = contador;
    }

    public int getId() {
        return id;
    }

    public String getEspecie_animais() {
        return especie_animais;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public int getQuantidade_animais() {
        return quantidade_animais;
    }

    public List<Animal> getLista_animais() {
        return lista_animais;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEspecie_animais(String especie_animais) {
        this.especie_animais = especie_animais;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public void setQuantidade_animais(int quantidade_animais) {
        this.quantidade_animais = quantidade_animais;
    }

    public void setLista_animais(List<Animal> lista_animais) {
        this.lista_animais = lista_animais;
    }
    
    public void adicionar_animal(Animal animal) {
        try {
            if (getEspecie_animais().equals(animal.getEspecie())) {
                lista_animais.add(animal);
                setQuantidade_animais(getQuantidade_animais() + 1);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Esse animal não pode ser adicionado a esse setor. As espécies não são compatíveis.");
        }
    }
    
    public void listar_animais() {
        for (int i = 0; i < getQuantidade_animais(); i++) {
            System.out.println("==== Animal " + i + " ====");
            System.out.println(lista_animais.get(i));
            System.out.println();
        }
    }
    
    @Override
    public String toString() {
        return
            "Setor " + getId() + "\n" +
            "Espécies dos animais: " + getEspecie_animais()+ "\n" +
            "CPF do responsável: " + getResponsavel().getCpf() + "\n" +
            "Quantidade de animais: " + getQuantidade_animais();
    }
}