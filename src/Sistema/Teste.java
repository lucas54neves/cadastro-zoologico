package Sistema;

import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        int dia = 14, mes = 3, ano = 1995;
        Date data_nascimento = new Date(ano - 1900, mes - 1, dia);
        System.out.println(data_nascimento);
    }
    
}
