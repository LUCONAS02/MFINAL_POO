package mfinal_poo;

import java.io.*;

/**
 * Serve para fazer a gestao de clientes
 */
class Cliente implements Serializable {
    /**
     * O nome do cliente {@link String}
     */
    private String nome;
    /**
     *  A morada do cliente {@link String}
     */
    private String morada;
    /**
     * O mail do cliente {@link String}
     */
    private String mail;
    /**
     * O numero de telefone do cliente {@link String}
     */
    private String telefone;
    /**
     * A data de nascimento do cliente {@link Data}
     */
    private Data data_de_nascimento;
    /**
     * O tipo de cliente {@link String}
     */
    private String tipo_de_cliente;
    /**
     * A lista de compras efetuadas pelo cliente {@link comprasList}
     */
    private comprasList compras_efetuadas;

    /**
     * O getter do mail do cliente
     * @return o mail do cliente {@link String}
     */
    public String getMail(){
        return this.mail;
    }
    /**
     * O getter do tipo de cliente
     * @return o tipo de cliente {@link String}
     */
    public String getTipo_de_cliente(){
        return this.tipo_de_cliente;
    }
    /**
     * O getter da lista de compras do cliente
     * @return a lista de compras do cliente {@link comprasList}
     */
    public comprasList getComprasefetuadas(){
        return this.compras_efetuadas;
    }
    /**
     * O getter do nome do cliente
     * @return o nome do cliente {@link String}
     */
    public String getNome(){
        return this.nome;
    }


    /**
     *
     * @param nome O nome do cliente {@link String}
     * @param morada A morada do cliente {@link String}
     * @param mail O mail do cliente {@link String}
     * @param telefone O numero de telefone do cliente {@link String}
     * @param data_de_nascimento A data de nascimento do cliente {@link Data}
     * @param tipo_de_cliente O tipo de cliente {@link String}
     * @param compras_efetuadas As compras efetuadas pelo cliente {@link comprasList}
     */
    public Cliente (String nome, String morada, String mail, String telefone, Data data_de_nascimento, String tipo_de_cliente,  comprasList compras_efetuadas){
        this.nome = nome;
        this.morada = morada;
        this.mail = mail;
        this.telefone = telefone;
        this.data_de_nascimento = data_de_nascimento;
        this.tipo_de_cliente = tipo_de_cliente;
        this.compras_efetuadas = compras_efetuadas;
    }

    /**
     * Da print a informacao necessaria sobre o cliente
     */
    public void print_cliente(){
        System.out.print("\nE-mail : "+this.mail+"\nTipo de cliente : "+this.tipo_de_cliente);
        compras_efetuadas.print_compras();
    }
}
