package mfinal_poo;
import java.io.*;


public class Data implements Serializable{

    private int dia;
    private int mes;
    private int ano;

    
    public Data(int dia,int mes,int ano){

        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
        
    } 
   
    
    public boolean cmp_max(Data d){
        if (d == null) {
            return false;
        }
        if(d.ano<this.ano){
            return true;
        }
        if((d.ano==this.ano)&&(d.mes<this.mes)){
            return true;
        }
        if((d.ano==this.ano)&&(d.mes==this.mes)&&(d.dia<this.dia)){
            return true;
        }
        if((d.ano==this.ano)&&(d.mes==this.mes)&&(d.dia==this.dia)){
            return true;
        }
        return false;
    }
    public boolean cmp_min(Data d){
        if (d == null) {
            return false;
        }
        if(d.ano>this.ano){
            return true;
        }
        if((d.ano==this.ano)&&(d.mes>this.mes)){
            return true;
        }
        if((d.ano==this.ano)&&(d.mes==this.mes)&&(d.dia>this.dia)){
            return true;
        }
        if((d.ano==this.ano)&&(d.mes==this.mes)&&(d.dia==this.dia)){
            return true;
        }
        return false;
    }
    
    

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}


