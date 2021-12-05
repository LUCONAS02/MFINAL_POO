package mfinal_poo;

import java.io.Serializable;

public class Promocoes implements Serializable{
    protected String identificador;
    protected String modalidade;
    protected Data inicio;
    protected Data fim;
    
    public Promocoes(String identificador, String modalidade, Data inicio, Data fim){
        this.identificador = identificador;
        this.modalidade = modalidade;
        this.inicio = inicio;
        this.fim = fim;
    }
    @Override
    public String toString(){
        return identificador+" "+modalidade+" "+inicio+" "+fim+"\n";
    }
}
