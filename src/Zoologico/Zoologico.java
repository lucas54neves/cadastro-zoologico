package Zoologico;

import Animais.*;
import Clientes.*;
import Funcionarios.*;
import java.io.*;
import java.util.*;

public class Zoologico implements Serializable {
    // Lista com os animais do zoológico
    private List<Animal> animais;
    // Lista de todos os funcionários que trabalham na instiuição
    private List<Funcionario> funcionarios;
    // Lista de todos os clientes que visitaram o zoológico
    private List<Cliente> clientes;
    // Lista de todos os clientes que visitaram o zoológico
    private List<Setor> setores;
    
    public Zoologico() {
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

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
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
    
    public Funcionario retorna_funcionario(String cpf) {
        try {
            for (int i = 0; i < getFuncionarios().size(); i++) {
                if (cpf.equals(getFuncionarios().get(i).getCpf())) {
                    return getFuncionarios().get(i);
                }
            }
            throw new IllegalArgumentException("Funcionário não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Veterinario retorna_veterinario(String crmv) {
        try {
            for (int i = 0; i < getFuncionarios().size(); i++) {
                Object obj = getFuncionarios().get(i);
                if (obj instanceof Veterinario) {
                    if (((Veterinario) obj).getNumero_crmv().equals(crmv))
                    return (Veterinario) obj;
                }
            }
            throw new IllegalArgumentException("Funcionário não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
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
        salvar_animais();
        salvar_clientes();
        salvar_funcionarios();
        salvar_setores();
    }
    
    public void ler() {
        ler_animais();
        ler_clientes();
        ler_funcionarios();
        ler_setores();
    }
    
    public Setor retorna_setor(String especie) {
        for (int i = 0; i <  getSetores().size(); i++) {
            if (especie.equals(getSetores().get(i).getEspecie())) {
                return getSetores().get(i);
            }
        }
        return null;
    }
    
    public Setor retorna_setor(int id) {
        for (int i = 0; i <  getSetores().size(); i++) {
            if (getSetores().get(i).getId() == id) {
                return getSetores().get(i);
            }
        }
        return null;
    }
    
    public void salvar_clientes() {
        try {
            File file = new File("dados/clientes.bin" );
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            
            out.writeObject(getClientes());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void ler_clientes() {
        try {
            File file = new File("dados/clientes.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            List<Cliente> leitura = (List<Cliente>) in.readObject();
            for ( Cliente a : leitura ) {
                adicionar(a);
            }
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println( "Classe nao existe. Causa: " + e.getMessage() );
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void salvar_animais() {
        try {
            File file = new File("dados/animais.bin" );
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            
            out.writeObject(getAnimais());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void ler_animais() {
        try {
            File file = new File("dados/animais.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            List<Animal> leitura = (List<Animal>) in.readObject();
            for (Animal a : leitura) {
                adicionar(a);
            }
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println( "Classe nao existe. Causa: " + e.getMessage() );
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void salvar_funcionarios() {
        try {
            File file = new File("dados/funcionarios.bin" );
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            
            out.writeObject(getFuncionarios());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void ler_funcionarios() {
        try {
            File file = new File("dados/funcionarios.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            List<Funcionario> leitura = (List<Funcionario>) in.readObject();
            for (Funcionario a : leitura) {
                adicionar(a);
            }
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println( "Classe nao existe. Causa: " + e.getMessage() );
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void salvar_setores() {
        try {
            File file = new File("dados/setores.bin" );
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            
            out.writeObject(getSetores());
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public void ler_setores() {
        try {
            File file = new File("dados/setores.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            List<Setor> leitura = (List<Setor>) in.readObject();
            for (Setor a : leitura) {
                adicionar(a);
            }
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println( "Classe nao existe. Causa: " + e.getMessage() );
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
    }
    
    public Cliente retorna_cliente(int id) {
        for (int i = 0; i < getClientes().size(); i++) {
            if (getClientes().get(i).getId() == id) {
                return getClientes().get(i);
            }
        }
        
        return null;
    }
    
    public void calcula_quantidade_visitas() {
        int quantidade;
        
        for (int k = 0; k < getSetores().size(); k++) {
            quantidade = 0;
            
            for (int i = 0; i < getClientes().size(); i++) {
                for (int j = 0; j < getClientes().get(i).getSetores_visitados().size(); j++) {
                    if ((int)getClientes().get(i).getSetores_visitados().get(j) == getSetores().get(k).getId()) {
                        quantidade++;
                    }
                }
            }
            
            getSetores().get(k).setQuantidade_visitas(quantidade);
        }
    }
}
