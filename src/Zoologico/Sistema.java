package Zoologico;

import Animais.*;
import Clientes.Cliente;
import Funcionarios.*;
import java.util.*;

public class Sistema {
    public void menu_principal(Zoologico zoo) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("======================");
            System.out.println("=== Menu principal ===");
            System.out.println("======================");

            System.out.println("Qual operação deseja realizar?");
            System.out.println("[1] - Adicionar algo ao sistema");
            System.out.println("[2] - Consultar algo do sistema");
            System.out.println("[3] - Remover algo do sistema");
            System.out.println("[0] - Sair");

            System.out.println("======================");

            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("=================================");
                    System.out.println("=== Menu principal finalizado ===");
                    System.out.println("=================================");
                    zoo.salvar();
                    break;
                case 1:
                    menu_cadastro(zoo);
                    break;
                case 2:
                    menu_consulta(zoo);
                    break;
                case 3:
                    menu_remocao(zoo);
                    break;
                default:
                    System.out.println("Opção não cadastrada.");
                    break;
            }
        }
    }
    
    public void menu_consulta(Zoologico zoo) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("========================");
            System.out.println("=== Menu de consulta ===");
            System.out.println("========================");
            
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[1] - Consultar um funcionário");
            System.out.println("[2] - Consultar um animal");
            System.out.println("[3] - Consultar um setor");
            System.out.println("[4] - Consultar um cliente");
            System.out.println("[5] - Setores mais visitados");
            System.out.println("[6] - Listar os funcionários");
            System.out.println("[7] - Listar os animais");
            System.out.println("[8] - Listar os setores");
            System.out.println("[9] - Listar os clientes");
            System.out.println("[0] - Sair");
            
            System.out.println("========================");
            
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("===================================");
                    System.out.println("=== Menu de consulta finalizado ===");
                    System.out.println("===================================");
                    break;
                case 1:
                    consultar_funcionario(zoo);
                    break;
                case 2:
                    consultar_animal(zoo);
                    break;
                case 3:
                    consultar_setor(zoo);
                    break;
                case 4:
                    consultar_cliente(zoo);
                    break;
                case 5:
                    listar_setores_ordenados(zoo);
                    break;
                case 6:
                    listar_funcionarios(zoo);
                    break;
                case 7:
                    listar_animais(zoo);
                    break;
                case 8:
                    listar_setores(zoo);
                    break;
                case 9:
                    listar_clientes(zoo);
                    break;
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
    }
    
    public void menu_cadastro(Zoologico zoo) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("========================");
            System.out.println("=== Menu de cadastro ===");
            System.out.println("========================");
            
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[1] - Cadastrar um funcionário");
            System.out.println("[2] - Cadastrar um animal");
            System.out.println("[3] - Cadastrar um cliente");
            System.out.println("[4] - Cadastrar um setor");
            System.out.println("[5] - Cadastrar animal a um setor");
            System.out.println("[0] - Sair");
            
            System.out.println("========================");
            
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("===================================");
                    System.out.println("=== Menu de cadastro finalizado ===");
                    System.out.println("===================================");
                    break;
                case 1:
                    cadastrar_funcionario(zoo);
                    break;
                case 2:
                    cadastrar_animal(zoo);
                    break;
                case 3:
                    cadastrar_cliente(zoo);
                    break;
                case 4:
                    cadastrar_setor(zoo);
                    break;
                case 5:
                    cadastrar_animal_setor(zoo);
                    break;
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
    }
    
    public void menu_remocao(Zoologico zoo) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("========================");
            System.out.println("=== Menu de remoção ====");
            System.out.println("========================");
            
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[1] - Remover um funcionário");
            System.out.println("[2] - Remover um animal");
            System.out.println("[3] - Remover um setor");
            System.out.println("[0] - Sair");

            System.out.println("========================");
            
            opcao = ler.nextInt();
            System.out.println();
            
            switch (opcao) {
                case 0:
                    System.out.println("==================================");
                    System.out.println("=== Menu de remoção finalizado ===");
                    System.out.println("==================================");
                    break;
                case 1:
                    remover_funcionario(zoo);
                    break;
                case 2:
                    remover_animal(zoo);
                    break;
                case 3:
                    remover_setor(zoo);
                    break;
                default:
                    System.out.println("Opção não cadastrada. Tente novamente");
            }
        }
    }
    
    public void remover_funcionario (Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            String cpf;
            Funcionario funcionario;

            System.out.println("==============================");
            System.out.println("=== Remoção de funcionário ===");
            System.out.println("==============================");

            System.out.println("Entre com o CPF");
            cpf = ler.next();

            funcionario = zoo.retorna_funcionario(cpf);
            
            if (funcionario == null) {
                throw new IllegalArgumentException("Não foi possível remover o funcionário do sistema");
            } else {
            zoo.getFuncionarios().remove(funcionario);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("==============================");
            System.out.println(e.getMessage());
            System.out.println("==============================");
        }
    }
    
    public void remover_animal (Zoologico zoo) {
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

            animal = zoo.retorna_animal(nome, especie);
            
            if (animal == null) {
                throw new IllegalArgumentException("Não foi possível remover o animal do sistema");
            } else {
                Setor setor = zoo.retorna_setor(especie);
                setor.remover_animal(animal);
                
                System.out.println("=========================");
                System.out.println("Setor removido");
                System.out.println("=========================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("=========================");
            System.out.println(e.getMessage());
            System.out.println("=========================");
        }
    }
    
    public void remover_setor (Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            Setor setor;
            String especie;

            System.out.println("========================");
            System.out.println("=== Remoção de setor ===");
            System.out.println("========================");

            System.out.println("Entre com a espécie");
            especie = ler.next();

            setor = zoo.retorna_setor(especie);

            if (setor == null) {
                throw new IllegalArgumentException("Não foi possível remover o setor do sistema");
            } else {
                zoo.getSetores().remove(setor);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("========================");
            System.out.println(e.getMessage());
            System.out.println("========================");
        }
    }
    
    public void listar_setores_ordenados(Zoologico zoo) {
        zoo.calcula_quantidade_visitas();
        List<Setor> lista_para_ordenar = zoo.getSetores();
        Collections.sort(lista_para_ordenar);
        
        System.out.println("====================================================");
        System.out.println("=== Listagem dos setores ordenados por visitação ===");
        System.out.println("====================================================");
        
        for (int i = 0; i < lista_para_ordenar.size(); i++) {
            System.out.println(lista_para_ordenar.get(i));
        }
        
        System.out.println("====================================================");
    }
    
    public void listar_funcionarios (Zoologico zoo) {
        System.out.println("=================================");
        System.out.println("=== Listagem dos funcionários ===");
        System.out.println("=================================");
        
        for (int i = 0; i < zoo.getFuncionarios().size(); i++) {
            System.out.println(zoo.getFuncionarios().get(i));
        }

        System.out.println("=================================");
    }
    
    public void listar_animais (Zoologico zoo) {
        System.out.println("============================");
        System.out.println("=== Listagem dos animais ===");
        System.out.println("============================");

        for (int i = 0; i < zoo.getAnimais().size(); i++) {
            System.out.println(zoo.getAnimais().get(i));
        }

        System.out.println("=================================");
    }
    
    public void listar_setores (Zoologico zoo) {
        System.out.println("============================");
        System.out.println("=== Listagem dos setores ===");
        System.out.println("============================");
        
        for (int i = 0; i < zoo.getSetores().size(); i++) {
            System.out.println(zoo.getSetores().get(i));
        }

        System.out.println("=================================");
    }
    
    public void listar_clientes (Zoologico zoo) {
        System.out.println("============================");
        System.out.println("=== Listagem dos animais ===");
        System.out.println("============================");
        
        for (int i = 0; i < zoo.getClientes().size(); i++) {
            System.out.println(zoo.getClientes().get(i));
        }

        System.out.println("=================================");
    }
    
    public void consultar_cliente(Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            int id;
            Cliente cliente;

            System.out.println("===========================");
            System.out.println("=== Consulta de cliente ===");
            System.out.println("===========================");
            
            System.out.println("Entre com o ID do cliente desejado");
            id = ler.nextInt();

            cliente = zoo.retorna_cliente(id);

            if (cliente != null) {
                System.out.println("===========================");
                System.out.println(cliente);
                System.out.println("===========================");
            } else {
                throw new IllegalArgumentException("Cliente não encontrado");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("===========================");
            System.out.println(e.getMessage());
            System.out.println("===========================");
        }
        
    }
    
    public void consultar_setor(Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            String especie;
            Setor setor = null;
            int i = 0;
            boolean encontrado = false;

            System.out.println("=========================");
            System.out.println("=== Consulta de setor ===");
            System.out.println("=========================");

            System.out.println("Entre com o espécie do animal");
            especie = ler.next();

            while (i < zoo.getSetores().size() && !encontrado) {
                if (especie.equals(zoo.getSetores().get(i).getEspecie())) {
                    setor = zoo.getSetores().get(i);
                    encontrado = true;
                } else {
                    i++;
                }
            }

            if (!encontrado) {
                throw new IllegalArgumentException("Setor não encontrado");
            } else {
                System.out.println("=========================");
                System.out.println(setor);
                System.out.println("=========================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("=========================");
            System.out.println(e.getMessage());
            System.out.println("=========================");
        }
    }
    
    public void consultar_funcionario(Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            String cpf;
            Funcionario funcionario = null;
            boolean encontrado = false;
            int i = 0;

            System.out.println("===============================");
            System.out.println("=== Consulta de funcionário ===");
            System.out.println("===============================");

            System.out.println("Entre com o CPF do funcionário");
            cpf = ler.next();

            while (i < zoo.getFuncionarios().size() && !encontrado) {
                if (cpf.equals(zoo.getFuncionarios().get(i).getCpf())) {
                    funcionario = zoo.getFuncionarios().get(i);
                    encontrado = true;
                } else {
                    i++;
                }
            }

            if (!encontrado) {
                throw new IllegalArgumentException("Funcionário não encontrado");
            } else {
                System.out.println("===============================");
                System.out.println(funcionario);
                System.out.println("===============================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("===============================");
            System.out.println(e.getMessage());
            System.out.println("===============================");
        }
    }
    
    public void consultar_animal(Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            String nome, especie;
            Animal animal = null;
            boolean encontrado = false;
            int i = 0;

            System.out.println("==========================");
            System.out.println("=== Consulta de animal ===");
            System.out.println("==========================");

            System.out.println("Entre com o nome do animal");
            nome = ler.next();

            System.out.println("Entre com o espécie do animal");
            especie = ler.next();

            while (i < zoo.getAnimais().size() && !encontrado) {
                if (nome.equals(zoo.getAnimais().get(i).getNome()) && especie.equals(zoo.getAnimais().get(i).getEspecie())) {
                    animal = zoo.getAnimais().get(i);
                    encontrado = true;
                } else {
                    i++;
                }
            }

            if (!encontrado) {
                throw new IllegalArgumentException("Animal não encontrado.");
            } else {
                System.out.println("==========================");
                System.out.println(animal);
                System.out.println("==========================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("==========================");
            System.out.println(e.getMessage());
            System.out.println("==========================");
        }
    }
    
    public void cadastrar_animal(Zoologico zoo) {
        try {
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

            System.out.println("Entre com o sexo [Macho/Femea]");
            sexo = ler.next();

            
            if (!(sexo.equals("Macho") || sexo.equals("Femea"))) {
                throw new IllegalArgumentException("Sexo incorreto.");
            }

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
            
            if (data_nascimento.after(new Date())) {
                throw new IllegalArgumentException("Não é possível cadastrar um animal que ainda não nasceu.");
            }

            switch (tipo) {
                case 1:
                    if (sexo.equals("Femea")) {
                        System.out.println("O animal encontra-se em gestação?");
                        System.out.println("[0] - Não");
                        System.out.println("[1] - Sim");
                        gestacao = ler.nextInt();
                        System.out.println();
                    } else {
                        gestacao = 0;
                    }

                    novo_animal = new Mamifero(zoo, nome, especie, sexo, data_nascimento, gestacao == 1);
                    break;
                case 2:
                    System.out.println("Entre com o tipo de réptil.");
                    System.out.println("[Escamoso/Crocodiliano/Quelônio]");
                    tipo_reptil = ler.next();
                    System.out.println();

                    novo_animal = new Reptil(zoo, nome, especie, sexo, data_nascimento, tipo_reptil);
                    break;
                case 3:
                    System.out.println("A ave pode voar?");
                    System.out.println("[0] - Não");
                    System.out.println("[1] - Sim");
                    voa = ler.nextInt();
                    System.out.println();

                    novo_animal = new Ave(zoo, nome, especie, sexo, data_nascimento, voa == 1);
                    break;
                case 4:
                    novo_animal = new Anfibio(zoo, nome, especie, sexo, data_nascimento);
                    break;
                case 5:
                    System.out.println("Qual o tipo de água desse paixe?");
                    System.out.println("[Salgada/Doce]");
                    tipo_agua = ler.next();
                    System.out.println();

                    novo_animal = new Peixe(zoo, nome, especie, sexo, data_nascimento, tipo_agua);
                    break;
            }

            if (novo_animal == null) {
                throw new IllegalArgumentException("Animal não cadastrado.");
            } else {
                zoo.adicionar(novo_animal);
                System.out.println("=========================");
                System.out.println("=== Animal cadastrado ===");
                System.out.println("=========================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("=========================");
            System.out.println(e.getMessage());
            System.out.println("=========================");
        }
    }
    
    public void cadastrar_cliente(Zoologico zoo) {
        Scanner ler = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Setor setor;
        int id_setor = -2;

        System.out.println("===========================");
        System.out.println("=== Cadastro de cliente ===");
        System.out.println("===========================");
        
        while (id_setor != -1) {
            System.out.println("Entre com o setor visitado");
            System.out.println("[-1] - Para sair");
            id_setor = ler.nextInt();
            setor = zoo.retorna_setor(id_setor);

            if (setor != null) {
                cliente.Visitar(id_setor);
                setor.setQuantidade_animais(setor.getQuantidade_visitas()+1);
            } else {
                System.out.println("Setor não cadastrado");
            }
        }

        zoo.adicionar(cliente);
        System.out.println(cliente);
        
        System.out.println("===========================");
    }
    
    public void cadastrar_funcionario(Zoologico zoo) {
        try {
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
            
            if (zoo.retorna_funcionario(cpf) != null) {
                throw new IllegalArgumentException("Funcionário já cadastrado.");
            }

            System.out.println("Entre com o nome");
            nome = ler.next();

            System.out.println("Entre com o sexo [Masculino/Feminino]");
            sexo = ler.next();
            
            if (!(sexo.equals("Masculino") || sexo.equals("Feminino"))) {
                throw new IllegalArgumentException("Sexo incorreto.");
            }

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

            if (nascimento.after(admissao)) {
                throw new IllegalArgumentException("Data de nascimento é depois da data de admissão.");
            }
            
            if (admissao.after(new Date())) {
                throw new IllegalArgumentException("Não é possível cadastrar um funcionário futuro.");
            }
            
            switch (funcao) {
                case 1:
                    novo_funcionario = new Diretor(zoo, cpf, nome, sexo, nascimento, admissao);
                    break;
                case 2:
                    novo_funcionario = new Tratador(zoo, cpf, nome, sexo, nascimento, admissao);
                    break;
                case 3:
                    System.out.println("Entre com o CRMV");
                    crmv = ler.next();
                    
                    if (zoo.retorna_veterinario(crmv) != null) {
                        throw new IllegalArgumentException("Veterinário já cadastrado.");
                    }
                    
                    novo_funcionario = new Veterinario(zoo, cpf, nome, sexo, nascimento, admissao, crmv);
                    break;
                default:
                    throw new IllegalArgumentException("Funcionário não cadastrado.");
            }

            if (novo_funcionario != null) {
                zoo.getFuncionarios().add(novo_funcionario);

                System.out.println("===============================");
                System.out.println("Funcionário cadastrado");
                System.out.println("===============================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("===============================");
            System.out.println(e.getMessage());
            System.out.println("===============================");
        }
    }
    
    public void cadastrar_setor(Zoologico zoo) {
        try {
            Scanner ler = new Scanner(System.in);
            String especie;
            Setor setor;

            System.out.println("=========================");
            System.out.println("=== Cadastro de setor ===");
            System.out.println("=========================");

            System.out.println("Entre com o espécie do animal");
            especie = ler.next();

            if (zoo.retorna_setor(especie) == null) {
                setor = new Setor(especie);
                zoo.adicionar(setor);
                
                System.out.println("=========================");
                System.out.println("Setor cadastrado");
                System.out.println("=========================");
            } else {
                throw new IllegalArgumentException("Já existe um setor com essa espécie.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("=========================");
            System.out.println(e.getMessage());
            System.out.println("=========================");
        }
        
    }
    
    public void cadastrar_animal_setor(Zoologico zoo) {
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

            animal = zoo.retorna_animal(nome, especie);
            setor = zoo.retorna_setor(especie);
            
            if (animal == null || setor == null) {
                throw new IllegalArgumentException("Não foi possível adicionar o animal ao setor.");
            } else {
                animal.setSetor(setor);
                setor.adicionar(animal);
                
                System.out.println("====================================");
                System.out.println("=== Animal cadastrado a um setor ===");
                System.out.println("====================================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("====================================");
            System.out.println();
            System.out.println("====================================");
        }
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Zoologico zoo = new Zoologico();
        
        zoo.ler();
        sistema.menu_principal(zoo);
    }
}
