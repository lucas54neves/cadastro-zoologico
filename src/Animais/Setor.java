package Animais;

import Funcionarios.*;
import java.util.*;

public class Setor {
    private final Animal tipo_animais;
    private Funcionario responsavel;
    private final int id;
    private int quantidade_animais;
    private final List<Animal> lista_animais;

    public Setor(Animal animal, Funcionario responsavel, int id) {
        this.tipo_animais = animal;
        this.responsavel = responsavel;
        this.id = id;
        this.lista_animais = new LinkedList<>();
    }

    public Animal getTipo_animais() {
        return tipo_animais;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public int getId() {
        return id;
    }

    public int getQuantidade_animais() {
        return quantidade_animais;
    }

    public void setResponsavel(Funcionario novoResponsavel) {
        responsavel = novoResponsavel;
    }

    public void setQuantidade_animais(int quantidade_animais) {
        this.quantidade_animais = quantidade_animais;
    }
    
    public void adicionarAnimal(Animal animal) {
        try {
            if (this.getTipo_animais() == animal) {
                lista_animais.add(animal);
                setQuantidade_animais(getQuantidade_animais() + 1);
            } else {
                throw new IllegalArgumentException("Não é possível adicionar esse animal nesse setor.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void listar_animais() {
        for (int i = 0; i < getQuantidade_animais(); i++) {
            System.out.println(lista_animais.get(i).getNome());
        }
    }
    
    @Override
    public String toString() {
        return "Espécie de animais: " + getTipo_animais().getEspecie() + "\n" +
        "CPF do responsável: " + getResponsavel().getCpf() + "\n" +
        "ID do setor: " + getId() + "\n" +
        "Quantidade de animais: " + getQuantidade_animais();
    }
}