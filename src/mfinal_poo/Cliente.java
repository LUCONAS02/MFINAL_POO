package mfinal_poo;

import java.io.*;

class Cliente implements Serializable {
    private String nome;
    private String morada;
    private String mail;
    private String telefone;
    private Data data_de_nascimento;
    private String tipo_de_cliente;
    private comprasList compras_efetuadas;


    public String getMail(){
        return this.mail;
    }

    public String getTipo_de_cliente(){
        return this.tipo_de_cliente;
    }

    public comprasList getComprasefetuadas(){
        return this.compras_efetuadas;
    }

    public String getNome(){
        return this.nome;
    }
    
    

    public Cliente (String nome, String morada, String mail, String telefone, Data data_de_nascimento, String tipo_de_cliente,  comprasList compras_efetuadas){
        this.nome = nome;
        this.morada = morada;
        this.mail = mail;
        this.telefone = telefone;
        this.data_de_nascimento = data_de_nascimento;
        this.tipo_de_cliente = tipo_de_cliente;
        this.compras_efetuadas = compras_efetuadas;
    }

    public void print_cliente(){
        System.out.print("\nE-mail : "+this.mail+"\nTipo de cliente : \n"+this.tipo_de_cliente);
        compras_efetuadas.print_compras();
    }
}
