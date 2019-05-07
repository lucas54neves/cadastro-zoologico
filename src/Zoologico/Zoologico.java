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
    
    public void cadastrar_animal() {
        Scanner ler = new Scanner(System.in);
        String nome, especie, sexo, tipo_reptil, tipo_agua;
        int tipo, dia, mes, ano, gestacao, voa;
        Date data_nascimento;
        Animal novo_animal = null;
        
        System.out.println("===========================");
        System.out.println("=== Cadastro de animais ===");
        System.out.println("===========================");
        
        System.out.println("Entre com o nome");
        nome = ler.next();
        
        System.out.println("Entre com a espécie");
        especie = ler.next();
        
        System.out.println("Entre com o sexo [Macho/Fêmea]");
        sexo = ler.next();
        
        System.out.println("Entre com o tipo");
        System.out.println("[1] - Mamífero");
        System.out.println("[2] - Réptil");
        System.out.println("[3] - Ave");
        System.out.println("[4] - Anfíbio");
        System.out.println("[5] - Peixe");
        tipo = ler.nextInt();
        
        System.out.println("Entre com o dia de nascimento");
        dia = ler.nextInt();
        System.out.println("Entre com o mês de nascimento");
        mes = ler.nextInt();
        System.out.println("Entre com o ano de nascimento");
        ano = ler.nextInt();
        data_nascimento = new Date(ano - 1900, mes - 1, dia);
        System.out.println();
        
        switch (tipo) {
            case 1:
                System.out.println("O animal encontra-se em gestação?");
                System.out.println("[0] - Não");
                System.out.println("[1] - Sim");
                gestacao = ler.nextInt();
                System.out.println();

                novo_animal = new Mamifero(nome, especie, sexo, data_nascimento, gestacao == 1);
                break;
            case 2:
                System.out.println("Entre com o tipo de réptil.");
                System.out.println("[Escamoso/Crocodiliano/Quelônio]");
                tipo_reptil = ler.next();
                System.out.println();

                novo_animal = new Reptil(nome, especie, sexo, data_nascimento, tipo_reptil);
                break;
            case 3:
                System.out.println("A ave pode voar?");
                System.out.println("[0] - Não");
                System.out.println("[1] - Sim");
                voa = ler.nextInt();
                System.out.println();

                novo_animal = new Ave(nome, especie, sexo, data_nascimento, voa == 1);
                break;
            case 4:
                novo_animal = new Anfibio(nome, especie, sexo, data_nascimento);
                break;
            case 5:
                System.out.println("Qual o tipo de água desse paixe?");
                System.out.println("[Salgada/Doce]");
                tipo_agua = ler.next();
                System.out.println();

                novo_animal = new Peixe(nome, especie, sexo, data_nascimento, tipo_agua);
                break;
        }
        
        if (novo_animal == null) {
            System.out.println();
            System.out.println("Não foi possível cadastrar o animal");
            System.out.println();
        } else {
            adicionar(novo_animal);
            System.out.println("Animal cadastrado");
            System.out.println();
        }
    }
    
    public void cadastrar_funcionario() {
        Scanner ler = new Scanner(System.in);
        String cpf, nome, sexo, crmv;
        int dia, mes, ano, funcao;
        Date nascimento, admissao;
        Funcionario novo_funcionario = null;
        
        System.out.println("===============================");
        System.out.println("=== Cadastro de funcionário ===");
        System.out.println("===============================");
        
        System.out.println("Entre com a função do novo funcionário");
        System.out.println("[1] - Diretor");
        System.out.println("[2] - Tratador");
        System.out.println("[3] - Veterinário");
        funcao = ler.nextInt();
        
        System.out.println("Entre com o CPF");
        cpf = ler.next();
        
        System.out.println("Entre com o nome");
        nome = ler.next();
        
        System.out.println("Entre com o sexo [Masculino/Feminino]");
        sexo = ler.next();
        
        System.out.println("Entre com o dia de nascimento");
        dia = ler.nextInt();
        
        System.out.println("Entre com o mês de nascimento");
        mes = ler.nextInt();
        
        System.out.println("Entre com o ano de nascimento");
        ano = ler.nextInt();
        
        nascimento = new Date(ano - 1900, mes - 1, dia);
        
        System.out.println("Entre com o dia de admissão");
        dia = ler.nextInt();
        
        System.out.println("Entre com o mês de admissão");
        mes = ler.nextInt();
        
        System.out.println("Entre com o ano de admissão");
        ano = ler.nextInt();
        
        admissao = new Date(ano - 1900, mes - 1, dia);
        
        switch (funcao) {
            case 1:
                novo_funcionario = new Diretor(cpf, nome, sexo, nascimento, admissao);
                break;
            case 2:
                novo_funcionario = new Tratador(cpf, nome, sexo, nascimento, admissao);
                break;
            case 3:
                System.out.println("Entre com o CRMV");
                crmv = ler.next();
                
                novo_funcionario = new Veterinario(cpf, nome, sexo, nascimento, admissao, crmv);
                break;
            default:
                System.out.println("Funcionário não cadastrado");
                break;
        }
        
        if (novo_funcionario != null) {
            getFuncionarios().add(novo_funcionario);
            System.out.println("Funcionário cadastrado");
        }
    }
    
    public void consultar_funcionario() {
        Scanner ler = new Scanner(System.in);
        String cpf;
        boolean encontrado = false;
        int i = 0;
        
        System.out.println("===============================");
        System.out.println("=== Consulta de funcionário ===");
        System.out.println("===============================");
        
        System.out.println("Entre com o CPF do funcionário");
        cpf = ler.next();
        
        while (i < getFuncionarios().size() && !encontrado) {
            if (cpf.equals(getFuncionarios().get(i).getCpf())) {
                System.out.println(getFuncionarios().get(i));
                encontrado = true;
            } else {
                i++;
            }
        }
        
        if (!encontrado) {
            System.out.println("Funcionário não encontrado");
        }
    }
    
    public void consultar_animal() {
        Scanner ler = new Scanner(System.in);
        String nome, especie;
        boolean encontrado = false;
        int i = 0;
        
        System.out.println("==========================");
        System.out.println("=== Consulta de animal ===");
        System.out.println("==========================");
        
        System.out.println("Entre com o nome do animal");
        nome = ler.next();
        
        System.out.println("Entre com o espécie do animal");
        especie = ler.next();
        
        while (i < getAnimais().size() && !encontrado) {
            if (nome.equals(getAnimais().get(i).getNome()) && especie.equals(getAnimais().get(i).getEspecie())) {
                System.out.println(getAnimais().get(i));
                encontrado = true;
            } else {
                i++;
            }
        }
        
        if (!encontrado) {
            System.out.println("Animal não encontrado");
        }
    }
    
    public void cadastrar_setor() {
        Scanner ler = new Scanner(System.in);
        String especie;
        Setor setor;
        
        System.out.println("=========================");
        System.out.println("=== Cadastro de setor ===");
        System.out.println("=========================");
        
        System.out.println("Entre com o espécie do animal");
        especie = ler.next();
        
        setor = new Setor(especie);
        
        adicionar(setor);
        System.out.println("Setor cadastrado");
    }
    
    public void consultar_setor() {
        Scanner ler = new Scanner(System.in);
        String especie;
        int i = 0;
        boolean encontrado = false;
        
        System.out.println("=========================");
        System.out.println("=== Consulta de setor ===");
        System.out.println("=========================");
        
        System.out.println("Entre com o espécie do animal");
        especie = ler.next();
        
        while (i < getSetores().size() && !encontrado) {
            if (especie.equals(getSetores().get(i).getEspecie())) {
                System.out.println(getSetores().get(i));
                encontrado = true;
            } else {
                i++;
            }
        }
        
        if (!encontrado) {
            System.out.println("Setor não encontrado");
        }
    }
    
    public void cadastrar_animal_setor() {
        try {
            Scanner ler = new Scanner(System.in);
            String especie, nome;
            Animal animal;
            Setor setor;

            System.out.println("========================================");
            System.out.println("=== Cadastro de um animal a um setor ===");
            System.out.println("========================================");

            System.out.println("Entre com o nome do animal");
            nome = ler.next();

            System.out.println("Entre com o espécie do animal");
            especie = ler.next();

            animal = retorna_animal(nome, especie);
            setor = retorna_setor(especie);

            animal.setSetor(setor);
            setor.adicionar(animal);
        } catch (Exception e) {
            System.out.println("Não foi possível adicionar o animal ao setor.");
        }
        
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
    
    public void cadastrar_cliente() {
        Scanner ler = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int id_setor;
        
        do {
            System.out.println("Entre com o setor visitado");
            System.out.println("[-1] - Para sair");
            id_setor = ler.nextInt();
            
            if (retorna_setor(id_setor) != null) {
                cliente.Visitar(id_setor);
            } else {
                System.out.println("Setor não cadastrado");
            }
        } while (id_setor != -1);
        
        adicionar(cliente);
        System.out.println(cliente);
    }
    
    public void abrir() {
        ler();
        menu_principal();
    }
    
    public void menu_principal() {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("### Menu principal ###");
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Adicionar algo ao sistema");
            System.out.println("[2] - Consultar algo do sistema");
            System.out.println("[2] - Remover algo do sistema");
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu principal finalizado");
                    salvar();
                    break;
                case 1:
                    menu_cadastro();
                    break;
                case 2:
                    menu_consulta();
                    break;
                case 3:
                    menu_remocao();
                    break;
                default:
                    System.out.println("Opção não cadastrada.");
                    break;
            }
        }
    }
    
    public void menu_cadastro() {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("========================");
            System.out.println("=== Menu de cadastro ===");
            System.out.println("========================");
            
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Cadastrar um funcionário");
            System.out.println("[2] - Cadastrar um animal");
            System.out.println("[3] - Cadastrar um cliente");
            System.out.println("[4] - Cadastrar um setor");
            System.out.println("[5] - Cadastrar animal a um setor");
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu de cadastro finalizado");
                    break;
                case 1:
                    cadastrar_funcionario();
                    break;
                case 2:
                    cadastrar_animal();
                    break;
                case 3:
                    cadastrar_cliente();
                    break;
                case 4:
                    cadastrar_setor();
                    break;
                case 5:
                    cadastrar_animal_setor();
                    break;
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
    }
    
    public void menu_consulta() {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("========================");
            System.out.println("=== Menu de consulta ===");
            System.out.println("========================");
            
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Consultar um funcionário");
            System.out.println("[2] - Consultar um animal");
            System.out.println("[3] - Consultar um setor");
            System.out.println("[4] - Consultar um cliente");
            System.out.println("[5] - Setores mais visitados");
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu de consulta finalizado");
                    break;
                case 1:
                    consultar_funcionario();
                    break;
                case 2:
                    consultar_animal();
                    break;
                case 3:
                    consultar_setor();
                    break;
                case 4:
                    consultar_cliente();
                    break;
                case 5:
                    mostra_setores_ordenados();
                    break;
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
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
    
    public void consultar_cliente() {
        Scanner ler = new Scanner(System.in);
        int id;
        Cliente cliente;
        
        System.out.println("Entre com o ID do cliente desejado");
        id = ler.nextInt();
        
        cliente = retorna_cliente(id);
        
        System.out.println(cliente);
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
    
    public void mostra_setores_ordenados() {
        calcula_quantidade_visitas();
        List<Setor> lista_para_ordenar = getSetores();
        Collections.sort(lista_para_ordenar);
        
        System.out.println("=======================================");
        System.out.println("=== Setores ordenados por visitação ===");
        System.out.println("=======================================");
        
        for (int i = 0; i < lista_para_ordenar.size(); i++) {
            System.out.println(lista_para_ordenar.get(i));
        }
    }
    
    public void remover_funcionario () {
        try {
            Scanner ler = new Scanner(System.in);
            String cpf;
            Funcionario funcionario;

            System.out.println("==============================");
            System.out.println("=== Remoção de funcionário ===");
            System.out.println("==============================");

            System.out.println("Entre com o CPF");
            cpf = ler.next();

            funcionario = retorna_funcionario(cpf);

            if (getFuncionarios().remove(funcionario)) {
                System.out.println("Funcionário removido");
            } else {
                System.out.println("Funcionário não removido");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível remover o funcionário do sistema");
        }
    }
    
    public void remover_animal () {
        try {
            Scanner ler = new Scanner(System.in);
            Animal animal;
            String nome, especie;

            System.out.println("=========================");
            System.out.println("=== Remoção de animal ===");
            System.out.println("=========================");

            System.out.println("Entre com o nome");
            nome = ler.next();

            System.out.println("Entre com a especie");
            especie = ler.next();

            animal = retorna_animal(nome, especie);

            if (getAnimais().remove(animal)) {
                Setor setor = retorna_setor(especie);
                setor.setQuantidade_visitas(setor.getQuantidade_visitas() - 1);
                System.out.println("Animal removido");
            } else {
                System.out.println("Animal não removido");
            } 
        } catch (Exception e) {
            System.out.println("Não foi possível remover o animal do sistema");
        }
    }
    
    public void remover_setor () {
        try {
            Scanner ler = new Scanner(System.in);
            Setor setor;
            String especie;

            System.out.println("========================");
            System.out.println("=== Remoção de setor ===");
            System.out.println("========================");

            System.out.println("Entre com a espécie");
            especie = ler.next();

            setor = retorna_setor(especie);

            if (getSetores().remove(setor)) {
                System.out.println("Setor removido");
            } else {
                System.out.println("Setor não removido");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível remover o setor do sistema");
        }
    }
    
    public void menu_remocao() {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("========================");
            System.out.println("=== Menu de remoção ===");
            System.out.println("========================");
            
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Remover um funcionário");
            System.out.println("[2] - Remover um animal");
            System.out.println("[3] - Remover um setor");
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu de remoção finalizado");
                    break;
                case 1:
                    remover_funcionario();
                    break;
                case 2:
                    remover_animal();
                    break;
                case 3:
                    remover_setor();
                    break;
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
    }
    
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();
        zoo.abrir();
    }
}
