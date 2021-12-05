package mfinal_poo;

import java.io.Serializable;

abstract class Produto implements Serializable {
    protected String Identificador;
    protected String Nome;
    protected double PrecoUnitario;
    protected long stockExistente;  

    public Produto(String Identificador, String Nome, double PrecoUnitario, long stockExistente){
        this.Identificador = Identificador;
        this.Nome = Nome;
        this.PrecoUnitario = PrecoUnitario;
        this.stockExistente = stockExistente;
    }
    public abstract double calcular_valor(listPromocoes list_promo,Data data_atual, int quantidade);
    
    public String toString(){
        return "Nome do Produto: "+this.Nome+", Preço: "+this.PrecoUnitario+", Stock Existente: "+this.stockExistente;
    }

    public abstract String print_comprado();
    
}
class Alimentares extends Produto{
    private double calorias;
    private int percGordura;

    public Alimentares(String Identificador, String Nome, double PrecoUnitario, long stockExistente, double calorias, int percGordura){
        super(Identificador, Nome, PrecoUnitario, stockExistente);
        this.calorias = calorias;
        this.percGordura = percGordura;
    }

    public double calcular_valor(listPromocoes list_promocoes,Data data_atual, int quantidade){
        double valor = 0;
        if((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("leve4pague3")){
            int promo = quantidade/4;
            int normal = quantidade%4;

            valor = promo*3*this.PrecoUnitario + normal*this.PrecoUnitario;
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(leve 4 pague 3) - "+(promo*PrecoUnitario)+" ----- "+valor);
            
        }

        else if((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("paguemenos")){
            double desconto = 1.0;
            /*
            for(int i = 0;i<quantidade;i++){
                if(desconto)
            }
            */

        }

        else if ((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("")){

            valor = quantidade*this.PrecoUnitario;
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"  ----- "+valor);
        }

        return valor;
    }

    public String print_comprado(){
        return "Nome do Produto: "+this.Nome+", Identificador :"+this.Identificador+", Preço: "+this.PrecoUnitario+", Calorias: "+this.calorias+", Percentagem de Gordura: "+this.percGordura+"\n";
    }

    @Override
    public String toString(){
        return super.toString()+", Calorias: "+this.calorias+", Percentagem de Gordura: "+this.percGordura+"\n";
    }
    
}

class Limpeza extends Produto{
    private int grauToxicidade;

    public Limpeza(String Identificador, String Nome, double PrecoUnitario, long stockExistente, int grauToxicidade){
        super(Identificador, Nome, PrecoUnitario, stockExistente);
        this.grauToxicidade = grauToxicidade;    
    }

    public double calcular_valor(listPromocoes list_promocoes,Data data_atual, int quantidade){
        double valor = 0;
        if((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("leve4pague3")){
            int promo = quantidade/4;
            int normal = quantidade%4;

            valor = promo*3*this.PrecoUnitario + normal*this.PrecoUnitario;
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(leve 4 pague 3) - "+(promo*PrecoUnitario)+" ----- "+valor);
            
        }

        else if((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("paguemenos")){
            double desconto = 1.0;
            /*
            for(int i = 0;i<quantidade;i++){
                if(desconto)
            }
            */

        }

        else if ((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("")){
            valor = quantidade*this.PrecoUnitario;
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"  ----- "+valor);
        }

        return valor;
    }
    
    public String print_comprado(){
        return "Nome do Produto: "+this.Nome+", Identificador :"+this.Identificador+", Preço: "+this.PrecoUnitario+", Grau de Toxicidade: "+this.grauToxicidade+"\n";
    }

    @Override
    public String toString(){
        return super.toString()+", Grau de Toxicidade: "+this.grauToxicidade+"\n";
    }
}

class Mobiliario extends Produto{
    private double peso;
    private double largura;
    private double comprimento;
    private double profundidade;

    public Mobiliario(String Identificador, String Nome, double PrecoUnitario, long stockExistente, double peso, double largura, double comprimento, double profundidade){
        super(Identificador, Nome, PrecoUnitario, stockExistente);
        this.peso = peso;
        this.largura = largura;
        this.comprimento = comprimento;
        this.profundidade = profundidade;   
    }
    
    public double calcular_valor(listPromocoes list_promocoes,Data data_atual, int quantidade){
        double valor = 0;
        if((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("leve4pague3")){
            int promo = quantidade/4;
            int normal = quantidade%4;

            valor = promo*3*this.PrecoUnitario + normal*this.PrecoUnitario;
            if (this.peso>15){
                valor+=10;
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(leve 4 pague 3) - "+(promo*PrecoUnitario)+" ----- "+(valor-10)+" + 10 euros = "+valor);
            }
            else{
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(leve 4 pague 3) - "+(promo*PrecoUnitario)+" ----- "+valor);
            }
            
        }

        else if((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("paguemenos")){
            double desconto = 1.0;
            /*
            for(int i = 0;i<quantidade;i++){
                if(desconto)
            }
            */
            if (this.peso>15){
                valor+=10;
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+(valor-10)+" + 10 euros = "+valor);
            }
            else{
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+valor);
            }

        }

        else if ((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("")){
            valor = quantidade*this.PrecoUnitario;
            if (this.peso>15){
                valor+=10;
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"  ----- "+(valor-10)+" + 10 euros = "+valor);
            }
            else{
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"  ----- "+valor);
            }
            
        }

        return valor;
    }

    public String print_comprado(){
        return "Nome do Produto: "+this.Nome+", Identificador :"+this.Identificador+", Preço: "+this.PrecoUnitario+", Peso: "+this.peso+", Largura: "+this.largura+", Comprimento: "+this.comprimento+", Profundidade: "+this.profundidade+"\n";
    }

    @Override
    public String toString(){
        return super.toString()+", Peso: "+this.peso+", Largura: "+this.largura+", Comprimento: "+this.comprimento+", Profundidade: "+this.profundidade+"\n";
    }
}