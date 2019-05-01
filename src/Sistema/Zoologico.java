package Sistema;

import Animais.*;
import Clientes.*;
import Funcionarios.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Zoologico implements Serializable {
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
        this.setores = new LinkedList<>();
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

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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
                if (animal.getEspecie().equals(getSetores().get(i).getEspecie_animais())) {
                    return getSetores().get(i);
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Setor não encontrado.");
            return null;
        }
    }
    
    public Funcionario retorna_funcionario(String cpf) {
        try {
            for (int i = 0; i < getFuncionarios().size(); i++) {
                if (cpf.equals(getFuncionarios().get(i).getCpf())) {
                    return getFuncionarios().get(i);
                }
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Funcionário não encontrado.");
            return null;
        }
    }
    
    public void mostrar_setores() {
        System.out.println("=== Setores ===");
        for (int i = 0; i < getSetores().size(); i++) {
            System.out.println(getSetores().get(i));
        }
    }
    
    public Animal retorna_animal(String nome, String especie) {
        for (int i = 0; i < getAnimais().size(); i++) {
            if (getAnimais().get(i).getNome().equals(nome) && getAnimais().get(i).getEspecie().equals(especie)) {
                return getAnimais().get(i);
            }
        }
        return null;
    }
    
    public void salvar() {
        // Salva a lista com todos os setores em um aquivo
        try {
            File file = new File("setores.bin");
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(getSetores());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage() );
        }
        
        // Salva a lista com todos os animais em um aquivo
        try {
            File file = new File("animais.bin");
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(getAnimais());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage() );
        }
        
        // Salva a lista com todos os funcionários em um aquivo
        try {
            File file = new File("funcionarios.bin");
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(getFuncionarios());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage() );
        }
        
        // Salva a lista com todos os clientes em um aquivo
        try {
            File file = new File("clientes.bin");
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(getClientes());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void ler() {
        // Lê o arquivo dos setores e recupera os dados
        try {
            File file = new File("setores.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            setSetores((List<Setor>) in.readObject());
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Zoologico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Lê o arquivo dos animais e recupera os dados
        try {
            File file = new File("animais.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            setAnimais((List<Animal>) in.readObject());
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Zoologico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Lê o arquivo dos funcionários e recupera os dados
        try {
            File file = new File("funcionarios.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            setFuncionarios((List<Funcionario>) in.readObject());
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Zoologico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Lê o arquivo dos clientes e recupera os dados
        try {
            File file = new File("clientes.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            setClientes((List<Cliente>) in.readObject());
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arq. nao existe. Causa: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de E/S. Causa: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Zoologico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
