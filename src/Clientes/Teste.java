package Clientes;

import java.io.*;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        List<Cliente> clientes = new LinkedList<>();
        
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        
        try {
            File file = new File("teste.bin" );
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            
            out.writeObject(clientes);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
        
        try {
            File file = new File("teste.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            List<Cliente> teste = (List<Cliente>) in.readObject();
            for ( Cliente a : teste ) {
                System.out.println(a);
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
}
