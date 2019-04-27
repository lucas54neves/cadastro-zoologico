package Animais;

import Funcionarios.*;
import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        Animal leao = new Animal(1, "Leo", "Leão", "Macho", new Date(1995-1900, 3-1, 30));
        System.out.println(leao.getIdade());
        
        System.out.println(leao);
        
        Cuidador cuidador = new Cuidador("123", "Jack", "M", new Date(), 10);
        
        Setor leoes = new Setor(leao, cuidador, 10);
        
        leoes.adicionarAnimal(leao);
        leoes.adicionarAnimal(leao);
        leoes.adicionarAnimal(leao);
        leoes.adicionarAnimal(leao);
        leoes.adicionarAnimal(leao);
        
        System.out.println(leoes);
        
        leoes.listar_animais();
    }
}
