package Sistema;

import Animais.*;
import Clientes.*;
import Funcionarios.*;
import java.util.*;
import java.io.*;

public class Sistema {
    public void abrir(Zoologico zoo, Scanner ler) throws IOException {
        zoo.ler();
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
                    zoo.salvar();
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
        String cpf, nome, sexo, diretoria, especie;
        Date data_adminicao, data_nascimento;
        int dia, mes, ano, funcao, opcao = -1, id, tipo, setor_visitado = 0, confirmar;
        Funcionario novo_funcionario = null;
        Animal novo_animal = null;
        Setor setor;
        Cliente novo_cliente;
        
        while (opcao != 0) {
            System.out.println("### Menu de adição ###");
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Adicionar um funcionário");
            System.out.println("[2] - Adicionar um animal");
            System.out.println("[3] - Adicionar um cliente");
            
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
                    
                    confirmar = 0;
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
                    System.out.println("Entre com o ID");
                    id = ler.nextInt();
                    
                    System.out.println("Entre com o nome");
                    nome = ler.next();
                    
                    System.out.println("Entre com a espécie");
                    
                    especie = ler.next();
                    
                    System.out.println("Entre com o tipo");
                    System.out.println("[1] - Mamífero");
                    System.out.println("[2] - Réptil");
                    System.out.println("[3] - Ave");
                    System.out.println("[4] - Anfíbio");
                    tipo = ler.nextInt();
                    
                    System.out.println("Entre com o sexo");
                    sexo = ler.next();
                    
                    System.out.println("Cadastro da data de nascimento");
                    System.out.println("Entre com o dia de nascimento");
                    dia = ler.nextInt();
                    System.out.println("Entre com o mês de nascimento");
                    mes = ler.nextInt();
                    System.out.println("Entre com o ano de nascimento");
                    ano = ler.nextInt();
                    data_nascimento = new Date(ano - 1900, mes - 1, dia);
                    
                    switch (tipo) {
                        case 1:
                            novo_animal = new Mamifero(id, nome, especie, sexo, data_nascimento);
                            break;
                        case 2:
                            novo_animal = new Reptil(id, nome, especie, sexo, data_nascimento);
                            break;
                        case 3:
                            novo_animal = new Ave(id, nome, especie, sexo, data_nascimento);
                            break;
                        case 4:
                            novo_animal = new Anfibio(id, nome, especie, sexo, data_nascimento);
                            break;
                    }
                    
                    if (novo_animal != null) {
                        // Busca o setor referente a esse tipo de animal
                        setor = zoo.retorna_setor(novo_animal);
                        
                        // Cria um setor se ainda não existir um setor para esse tipo de animal
                        if (setor == null) {
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
                    
                    System.out.println("Digite os setores visitador pelo cliente");
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
        Funcionario funcionario = null;
        Animal animal = null;
        boolean encontrado;
        
        while (opcao != 0) {
            System.out.println("### Menu de consulta ###");
            System.out.println("Qual operação deseja realizar?");
            System.out.println("[0] - Sair");
            System.out.println("[1] - Consultar um funcionário");
            System.out.println("[2] - Consultar um animal");
            
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu de consulta finalizado");
                    break;
                case 1:
                    System.out.println("Entre com o CPF do funcionário");
                    cpf = ler.next();
                    encontrado = false;
                    
                    for (int i = 0; i < zoo.getFuncionarios().size() && !encontrado; i++) {
                        if ((zoo.getFuncionarios().get(i).getCpf() != null && cpf != null) && zoo.getFuncionarios().get(i).getCpf().equals(cpf)) {
                            funcionario = zoo.getFuncionarios().get(i);
                            encontrado = true;
                        }
                    }
                    
                    if (encontrado) {
                        System.out.println("Funcionário encontrado");
                        System.out.println(funcionario);
                    } else {
                        System.out.println("Funcionário não encontrado");
                    }
                    break;
                case 2:
                    System.out.println("Entre com o nome do animal");
                    nome = ler.next();
                    System.out.println("Entre com a espécie do animal");
                    especie = ler.next();
                    encontrado = false;
                    
                    for (int i = 0; i < zoo.getAnimais().size() && !encontrado; i++) {
                        if ((zoo.getAnimais().get(i).getNome()!= null && nome != null) &&
                            (zoo.getAnimais().get(i).getEspecie()!= null && especie != null) &&
                            (zoo.getAnimais().get(i).getNome().equals(nome) && zoo.getAnimais().get(i).getEspecie().equals(especie))) {
                            animal = zoo.getAnimais().get(i);
                            encontrado = true;
                        }
                    }
                    
                    if (encontrado) {
                        System.out.println("Animal encontrado");
                        System.out.println(animal);
                    } else {
                        System.out.println("Animal não encontrado");
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
