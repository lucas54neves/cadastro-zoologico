package Animais;

import Animais.*;
import Funcionarios.*;

public class Setor {
    private final Animal animais;
    private Funcionario responsavel;
    private final String setor;
    private int quantidade_animais;

    public Setor(Animal animal, Funcionario responsavel, String setor) {
        this.animais = animal;
        this.responsavel = responsavel;
        this.setor = setor;
    }

    public Animal getAnimais() {
        return animais;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public String getSetor() {
        return setor;
    }

    public int getQuantidade_animais() {
        return quantidade_animais;
    }

    public void setResponsavel(Funcionario novoResponsavel) {
        this.responsavel = novoResponsavel;
    }

    public void setQuantidade_animais(int quantidade_animais) {
        this.quantidade_animais = quantidade_animais;
    }
    
    public void adicionarAnimal(Animal animal) {
        try {
            if (this.getAnimais() == animal) {
                setQuantidade_animais(getQuantidade_animais() + 1);
            } else {
                throw new IllegalArgumentException("Não é possível adicionar esse animal nesse setor.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}