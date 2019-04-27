package Animais;

import Funcionarios.*;
import java.util.*;

public class Setor {
    private final int id;
    private final String nome;
    private Funcionario responsavel;
    private int quantidade_animais;
    private final List<Animal> lista_animais;

    public Setor(String nome, Funcionario responsavel, int id) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.id = id;
        this.lista_animais = new LinkedList<>();
    }

    public String getNome() {
        return nome;
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
    
    public void adicionar_animal(Animal animal) {
        try {
            if ((this.nome == null || animal.getTipo_animal() == null) || !this.nome.equals(animal.getTipo_animal())) {
                throw new IllegalArgumentException("Não é possível adicionar esse animal nesse setor.");
            } else {
                lista_animais.add(animal);
                setQuantidade_animais(getQuantidade_animais() + 1);
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
        String retorno = "Setor " + getId() + "\n";
        retorno += "Tipo de animais: " + getNome() + "\n";
        retorno += "CPF do responsável: " + getResponsavel().getCpf() + "\n";
        
        for (int i = 0; i < getQuantidade_animais(); i++) {
            retorno += lista_animais.get(i).toString() + "\n";
        }
        
        retorno += "Quantidade de animais: " + getQuantidade_animais();
        
        return retorno;
    }
}