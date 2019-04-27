package Sistema;

import Animais.*;
import Funcionarios.*;
import java.util.*;

public class Sistema {
    public void menu_principal(Scanner ler) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("### Menu principal ###\n");
            System.out.println("Qual operação deseja realizar?\n");
            System.out.println("[0] - Sair\n");
            System.out.println("[1] - Adicionar algo ao sistema\n");
            System.out.println("[2] - Consultar algo do sistema");
            
            ler.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu principal finalizado");
                    break;
                case 1:
                    menu_principal(ler);
                    break;
                case 2:
                    menu_consulta(ler);
                    break;
            }
        }
    }
    
    public void menu_adicao(Scanner ler) {
        String cpf, nome, sexo, diretoria, especie;
        Date data_adminicao, data_nascimento;
        int dia, mes, ano, funcao, opcao = -1, id, tipo;
        Funcionario novo_funcionario;
        Animal animal;
        
        while (opcao != 0) {
            System.out.println("### Menu de adição ###\n");
            System.out.println("Qual operação deseja realizar?\n");
            System.out.println("[0] - Sair\n");
            System.out.println("[1] - Adicionar um funcionário\n");
            System.out.println("[2] - Adicionar um animal");
            
            ler.nextInt();
            
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
                    
                    // Salvar em arquivo
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
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                    }
                    break;
            }
        }
    }
    
    public void menu_consulta(Scanner ler) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("### Menu de consulta ###\n");
            System.out.println("Qual operação deseja realizar?\n");
            System.out.println("[0] - Sair\n");
            System.out.println("[1] - Consultar um funcionário\n");
            System.out.println("[2] - Consultar um animal");
            
            ler.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Menu principal finalizado");
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        Sistema tb = new Sistema();
        Scanner ler = new Scanner(System.in);
        tb.menu_principal(ler);
    }
}
