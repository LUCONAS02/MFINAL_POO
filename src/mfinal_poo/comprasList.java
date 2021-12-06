package mfinal_poo;

import java.util.*;
import java.io.*;

class comprasList  implements Serializable{
    private ArrayList<Cesto> lista_de_compras;

    public comprasList(){
        lista_de_compras = new ArrayList<Cesto>();
    }

    public void print_compras(){
        int count = 0;
        for (Cesto i : lista_de_compras){
            count+=1;
            System.out.print("\n"+count+")"+"\n");
            i.print_all();
        }
    }
    public void add(Cesto cesto){
        lista_de_compras.add(cesto);
    }
}
