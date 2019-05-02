package Zoologico;

import Animais.*;
import Clientes.*;
import Funcionarios.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    }
    
    public Setor retorna_setor(String especie) {
        for (int i = 0; i <  getSetores().size(); i++) {
            if (especie.equals(getSetores().get(i).getEspecie())) {
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
            
            if (id_setor != -1) {
                cliente.Visitar(id_setor);
            }
        } while (id_setor != -1);
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
                    System.out.println("Menu principal finalizado");
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
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Zoologico zoo = new Zoologico();
        zoo.abrir();
    }
}
