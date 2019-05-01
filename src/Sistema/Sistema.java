package Sistema;

import Animais.*;
import Clientes.*;
import Funcionarios.*;
import java.util.*;
import java.io.*;

public class Sistema {
    public void abrir(Zoologico zoo, Scanner ler) throws IOException {
        menu_principal(zoo, ler);
    }
    
    public void menu_principal(Zoologico zoo, Scanner ler) throws IOException {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("### Menu principal ###");
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Adicionar algo ao sistema");
            System.out.println("[2] - Consultar algo do sistema");
            
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu principal finalizado");
                    break;
                case 1:
                    menu_adicao(zoo, ler);
                    break;
                case 2:
                    menu_consulta(zoo, ler);
                    break;
            }
        }
    }
    
    public void menu_adicao(Zoologico zoo, Scanner ler) {
        String cpf, nome, sexo, diretoria, especie, tipo_agua;
        Date data_adminicao, data_nascimento;
        int dia, mes, ano, funcao, opcao = -1, id, tipo, setor_visitado = 0, confirmar, gestacao;
        Funcionario novo_funcionario = null;
        Animal novo_animal = null;
        Setor setor;
        Cliente novo_cliente;
        boolean esta_gestacao, pode_voar;
        
        while (opcao != 0) {
            System.out.println("### Menu de adição ###");
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Adicionar um funcionário");
            System.out.println("[2] - Adicionar um animal");
            System.out.println("[3] - Adicionar um cliente");
            System.out.println();
            
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu principal finalizado");
                    break;
                case 1:
                    System.out.println("Entre com o CPF do novo funcionário");
                    cpf = ler.next();
                    
                    System.out.println("Entre com o nome do novo funcionário");
                    nome = ler.next();
                    
                    System.out.println("Entre com o sexo do novo funcionário");
                    sexo = ler.next();
                    
                    System.out.println("Entre com a função do novo funcionário");
                    System.out.println("[1] - Diretor");
                    System.out.println("[2] - Cuidador");
                    System.out.println("[3] - Vendedor");
                    funcao = ler.nextInt();
                    
                    System.out.println("Cadastro da data de nascimento");
                    System.out.println("Entre com o dia de nascimento");
                    dia = ler.nextInt();
                    System.out.println("Entre com o mês de nascimento");
                    mes = ler.nextInt();
                    System.out.println("Entre com o ano de nascimento");
                    ano = ler.nextInt();
                    data_nascimento = new Date(ano - 1900, mes - 1, dia);
                    
                    System.out.println("Cadastro da data de adminição");
                    System.out.println("Entre com o dia da adminição");
                    dia = ler.nextInt();
                    System.out.println("Entre com o mês da adminição");
                    mes = ler.nextInt();
                    System.out.println("Entre com o ano da adminição");
                    ano = ler.nextInt();
                    data_adminicao = new Date(ano - 1900, mes - 1, dia);
                    
                    switch (funcao) {
                        case 1:
                            System.out.println("Entre com a diretoria");
                            diretoria = ler.next();
                            
                            novo_funcionario = new Diretor(cpf, nome, sexo, data_nascimento, data_adminicao, diretoria);
                            break;
                        case 2:
                            System.out.println("Entre com o ID do setor");
                            id = ler.nextInt();
                            
                            novo_funcionario = new Cuidador(cpf, nome, sexo, data_nascimento, data_adminicao, id);
                            break;
                        case 3:
                            System.out.println("Entre com o ID da loja");
                            id = ler.nextInt();
                            
                            novo_funcionario = new Vendedor(cpf, nome, sexo, data_nascimento, data_adminicao, id);
                            break;
                    }
                    
                    System.out.println("Novo Funcionário");
                    System.out.println(novo_funcionario);
                    System.out.println();
                    System.out.println("[0] para apagar registro");
                    System.out.println("[1] para salvar registro");
                    confirmar = ler.nextInt();
                    
                    if (confirmar == 1) {
                        zoo.adicionar(novo_funcionario);
                        System.out.println("Registro salvo");
                    } else {
                        System.out.println("Registro apagado");
                    }
                    break;
                case 2:
                    System.out.println("### Cadastro de animal ###");
                    System.out.println();
                    
                    System.out.println("Entre com o nome");
                    nome = ler.next();
                    System.out.println();
                    
                    System.out.println("Entre com a espécie. [Macho/Fêmea]");
                    especie = ler.next();
                    System.out.println();
                    
                    System.out.println("Entre com o tipo");
                    System.out.println("[1] - Mamífero");
                    System.out.println("[2] - Réptil");
                    System.out.println("[3] - Ave");
                    System.out.println("[4] - Anfíbio");
                    System.out.println("[5] - Peixe");
                    tipo = ler.nextInt();
                    System.out.println();
                    
                    System.out.println("Entre com o sexo");
                    sexo = ler.next();
                    System.out.println();
                    
                    System.out.println("# Cadastro da data de nascimento #");
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
                            
                            esta_gestacao = gestacao == 1;
                            
                            novo_animal = new Mamifero(nome, especie, sexo, data_nascimento, esta_gestacao);
                            break;
                        case 2:
                            System.out.println("Entre com o tipo de réptil.");
                            System.out.println("Escamoso, Crocodiliano ou Quelônio");
                            String tipo_reptil = ler.next();
                            System.out.println();

                            novo_animal = new Reptil(nome, especie, sexo, data_nascimento, tipo_reptil);
                            break;
                        case 3:
                            System.out.println("O animal encontra-se em gestação?");
                            System.out.println("[0] - Não");
                            System.out.println("[1] - Sim");
                            int voa = ler.nextInt();
                            System.out.println();

                            pode_voar = voa == 1;
                            
                            novo_animal = new Ave(nome, especie, sexo, data_nascimento, pode_voar);
                            break;
                        case 4:
                            novo_animal = new Anfibio(nome, especie, sexo, data_nascimento);
                            break;
                        case 5:
                            System.out.println("Qual o tipo de água desse paixe?");
                            System.out.println("[Água salgada / Água doce]");
                            tipo_agua = ler.next();
                            System.out.println();
                            
                            novo_animal = new Peixe(nome, especie, sexo, data_nascimento, tipo_agua);
                            break;
                    }
                    
                    if (novo_animal != null) {
                        // Busca o setor referente a esse tipo de animal
                        setor = zoo.retorna_setor(novo_animal);
                        
                        // Cria um setor se ainda não existir um setor para esse tipo de animal
                        if (setor == null) {
                            System.out.println("Qual setá o funcionário responsável por esse setor?");
                            System.out.println("Entre com o CPF do funcionário");
                            cpf = ler.next();
                            System.out.println();
                            
                            novo_funcionario = zoo.retorna_funcionario(cpf);
                            setor = new Setor(nome, novo_funcionario);
                            
                            // Adiciona o setor ao zoológico
                            zoo.adicionar(setor);
                            
                            // Adiciona o animal ao setor correspondente
                            setor.adicionar_animal(novo_animal);
                        } else {
                            // Adiciona o animal ao setor correspondente
                            setor.adicionar_animal(novo_animal);
                        }
                    } else {
                        System.out.println("Adição do animal ao sistema não foi concluída");
                    }
                    break;
                case 3:
                    System.out.println("### Cadastro de clientes ###");
                    novo_cliente = new Cliente();
                    
                    System.out.println("Setores do zoológico");
                    zoo.mostrar_setores();
                    System.out.println();
                    System.out.println("Digite os ID dos setores visitados pelo cliente");
                    System.out.println("Digite -1 para parar de adicionar setores");
                    
                    while (setor_visitado != -1) {
                        setor_visitado = ler.nextInt();
                        novo_cliente.Visitar(setor_visitado);
                    }
                    
                    zoo.adicionar(novo_cliente);
                    break;
            }
        }
    }
    
    public void menu_consulta(Zoologico zoo, Scanner ler) {
        int opcao = -1;
        String cpf, nome, especie;
        Funcionario funcionario;
        Animal animal;
        
        while (opcao != 0) {
            System.out.println("### Menu de consulta ###");
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Consultar um funcionário");
            System.out.println("[2] - Consultar um animal");
            System.out.println();
            
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu de consulta finalizado");
                    break;
                case 1:
                    System.out.println("Entre com o CPF do funcionário");
                    cpf = ler.next();
                    System.out.println();
                    
                    funcionario = zoo.retorna_funcionario(cpf);
                    
                    if (funcionario != null) {
                        System.out.println("Funcionário encontrado");
                        System.out.println(funcionario);
                        System.out.println();
                    } else {
                        System.out.println("Funcionário não encontrado");
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Entre com o nome do animal");
                    nome = ler.next();
                    System.out.println("Entre com a espécie do animal");
                    especie = ler.next();
                    System.out.println();
                    
                    animal = zoo.retorna_animal(nome, especie);
                    
                    
                    if (animal != null) {
                        System.out.println("Animal encontrado");
                        System.out.println(animal);
                        System.out.println();
                    } else {
                        System.out.println("Animal não encontrado");
                        System.out.println();
                    }
                    break;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Zoologico zoo = new Zoologico();
        Sistema sistema = new Sistema();
        Scanner ler = new Scanner(System.in);
        sistema.abrir(zoo, ler);
    }
}
