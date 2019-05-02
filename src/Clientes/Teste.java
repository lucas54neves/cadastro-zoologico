package Clientes;

import java.io.*;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        List<Cliente> clientes = new LinkedList<>();
        
        Cliente c1 = new Cliente();
        c1.Visitar(2);
        c1.Visitar(3);
        Cliente c2 = new Cliente();
        c2.Visitar(4);
        Cliente c3 = new Cliente();
        c3.Visitar(5);
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        
        try {
            File file = new File("dados/teste.bin" );
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
            
            out.writeObject(clientes);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
        
        List<Cliente> apenas_teste = new LinkedList<>();
        
        try {
            File file = new File("dados/teste.bin");
            ObjectInput in = new ObjectInputStream(new FileInputStream(file));
            List<Cliente> teste = (List<Cliente>) in.readObject();
            for ( Cliente a : teste ) {
                apenas_teste.add(a);
            }
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println( "Classe nao existe. Causa: " + e.getMessage() );
        } catch (FileNotFoundException e) {
            System.out.println( "Arq. nao existe. Causa: " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "Erro de E/S. Causa: " + e.getMessage() );
        }
        
        for (int i = 0; i < apenas_teste.size(); i++) {
            System.out.println(apenas_teste.get(i));
        }
    }
}
