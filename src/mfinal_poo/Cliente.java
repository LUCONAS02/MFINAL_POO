package mfinal_poo;

import java.io.*;
import java.util.*;

class comprasList implements Serializable{
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

class Cliente implements Serializable {
    public String mail;
    public String tipo_de_cliente;
    public comprasList compras_efetuadas;

    public Cliente(String mail, String tipo_de_cliente, comprasList compras_efetuadas){
        this.mail = mail;
        this.tipo_de_cliente = tipo_de_cliente;
        this.compras_efetuadas = compras_efetuadas;
    }

    public void print_cliente(){
        System.out.print("\nE-mail : "+this.mail+"\nTipo de cliente : \n"+this.tipo_de_cliente);
        compras_efetuadas.print_compras();
    }
}
