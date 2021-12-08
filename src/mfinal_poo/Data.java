package mfinal_poo;
import java.io.*;

/**
 * Esta classe serve para fazer a gestao das datas
 */
public class Data implements Serializable{
    /**
     * o dia na data {@link Integer}
     */
    private int dia;
    /**
     * o mes na data {@link Integer}
     */
    private int mes;
    /**
     * o ano na data {@link Integer}
     */
    private int ano;

    /**
     * O construtor serve para construir/criar um objeto do tipo Data
     * @param dia o dia na data {@link Integer}
     * @param mes o mes na data {@link Integer}
     * @param ano o ano na data {@link Integer}
     */
    public Data(int dia,int mes,int ano){

        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
        
    }

    /**
     * Esta funcao indica se a data dada como parametro e antes que a o objeto data
     * @param d data a analisar
     * @return true se a data d for antes que o objeto data, false se a data d for depois que o objeto data
     */
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
    /**
     * Esta funcao indica se a data dada como parametro e depois da do objeto data
     * @param d data a analisar
     * @return true se a data d for depois da do objeto data, false se a data d for antes que a do objeto data
     */
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


    /**
     * Serve para escrever a data
     * @return as informacoes sobre a data (dd/mm/yyyy) {@link String}
     */
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}


