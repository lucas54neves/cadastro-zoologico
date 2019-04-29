package Sistema;

import Animais.*;
import Clientes.*;
import Funcionarios.*;
import java.util.*;

public class Zoologico {
    // Lista dos setores do zoológico
    private List<Setor> setores;
    // Lista com os animais do zoológico
    private List<Animal> animais;
    // Lista de todos os funcionários que trabalham na instiuição
    private List<Funcionario> funcionarios;
    // Lista de todos os clientes que visitaram o zoológico
    private List<Cliente> clientes;
    
    public Zoologico() {
        // Deve carregar do arquivo se já existir dados salvos no arquivo
        this.animais = new LinkedList<>();
        this.funcionarios = new LinkedList<>();
        this.clientes = new LinkedList<>();
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Setor> getSetores() {
        return setores;
    }
    
    public void adicionar(Animal novo_animal) {
        getAnimais().add(novo_animal);
    }
    
    public void adicionar(Funcionario novo_funcionario) {
        getFuncionarios().add(novo_funcionario);
    }
    
    public void adicionar(Cliente novo_cliente) {
        getClientes().add(novo_cliente);
    }
    
    public void adicionar(Setor novo_setor) {
        getSetores().add(novo_setor);
    }
    
    public Setor retorna_setor(Animal animal) {
        try {
            for (int i = 0; i < getSetores().size(); i++) {
                if ((getSetores().get(i).getNome() != null && animal.getTipo_animal() != null) && getSetores().get(i).getNome().equals(animal.getTipo_animal())) {
                    return getSetores().get(i);
                }
            }
            throw new IllegalArgumentException("Setor não encontrado");
        } catch (IllegalArgumentException e) {
            e.getMessage();
            return null;
        }
    }
    
    public void mostrar_setores() {
        System.out.println("Setores");
        for (int i = 0; i < getSetores().size(); i++) {
            System.out.println(getSetores().get(i).getId() + " - " + getSetores().get(i).getNome());
        }
    }
}