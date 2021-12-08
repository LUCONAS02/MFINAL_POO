package mfinal_poo;

import java.util.*;
import java.io.*;
/**
 * Para fazer a gestao de lista de compras
 */
class comprasList  implements Serializable{
    /**
     * lista de {@link Cesto}s
     */
    private ArrayList<Cesto> lista_de_compras;
    /**
     * Serve para criar uma nova ArrayList
     */
    public comprasList(){
        lista_de_compras = new ArrayList<Cesto>();
    }

    /**
     * Serve para dar print a todas as compras que estao na lista de compras
     */
    public void print_compras(){
        int count = 0;
        for (Cesto i : lista_de_compras){
            count+=1;
            System.out.print("\n"+count+")"+"\n");
            i.print_all();
        }
    }

    /**
     * Serve para adicionar um {@link Cesto} a lista de compras
     * @param cesto o cesto a ser adicionado
     */
    public void add(Cesto cesto){
        lista_de_compras.add(cesto);
    }
}
