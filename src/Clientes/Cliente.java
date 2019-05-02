package Clientes;

import java.io.*;
import java.util.*;

public class Cliente implements Serializable {
    private final int id;
    private final List setores_visitados;
    private static int contador = 0;

    public Cliente() {
        Cliente.contador++;
        this.id = Cliente.contador;
        this.setores_visitados = new LinkedList();
    }

    public int getId() {
        return id;
    }

    public List getSetores_visitados() {
        return setores_visitados;
    }
    
    public void Visitar(int idSetor) {
        setores_visitados.add(idSetor);
    }
}
