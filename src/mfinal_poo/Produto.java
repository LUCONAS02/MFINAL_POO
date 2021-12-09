package mfinal_poo;

import java.io.Serializable;

/**
 * Esta classe e utilizada para gerir a informacao de um produto sendo
 */
abstract class Produto implements Serializable {
    /**
     * O identificador do produto {@link String}
     */
    protected String Identificador;
    /**
     * O nome do produto {@link String}
     */
    protected String Nome;
    /**
     * O preco unitario  {@link Double}
     */
    protected double PrecoUnitario;
    /**
     * O stock existente do produto {@link Long}
     */
    protected long stockExistente;

    /**
     * O construtor do produto serve para construir/criar um novo produto com base nos parametros passados
     * @param Identificador O identificador do produto {@link String}
     * @param Nome O nome do produto {@link String}
     * @param PrecoUnitario O preco unitario {@link Double}
     * @param stockExistente O stock existente do produto {@link Long}
     */
    public Produto(String Identificador, String Nome, double PrecoUnitario, long stockExistente){
        this.Identificador = Identificador;
        this.Nome = Nome;
        this.PrecoUnitario = PrecoUnitario;
        this.stockExistente = stockExistente;
    }

    /**
     * Esta funcao apenas esta declarada, para depois ser definida em cada subclasse
     * @param list_promo a lista de promocoes {@link listPromocoes}
     * @param data_atual a data atual do programa {@link Data}
     * @param quantidade as unidades do produto que se pretendem comprar {@link Integer }
     * @return o preco do produto tendo em conta as unidades e as promocoes {@link Double}
     */
    public abstract double calcular_valor(listPromocoes list_promo,Data data_atual, int quantidade);

    /**
     * Esta funcao e utilizada para mostrar ao utilizador as informacoes do produto
     * @return uma {@link String} com a informacao relativa a um objeto produto
     */
    public String toString(){
        return "Nome do Produto: "+this.Nome+", Preço: "+this.PrecoUnitario+", Stock Existente: "+this.stockExistente;
    }
    
    /**
     * Getter do atributo identificador
     * @return o identificado do produto
     */
    public String getIdentificador(){
        return this.Identificador;
    }
    /**
     * Getter do atributo Nome
     * @return o Nome do produto
     */
    public String getNome(){
        return this.Nome;
    }
    /**
     * Getter do atributo PrecoUnitario
     * @return o PrecoUnitario do produto
     */
    public double getPrecoUnitario(){
        return this.PrecoUnitario;
    }
    /**
     * Getter do atributo stockExistente
     * @return o stockExistente do produto
     */
    public long getStockExistente(){
        return this.stockExistente;
    }

    /**
     * Esta funcao subtrai ao stock esxistente do produto o valor de unidades compradas
     * @param numero_compra unidades compradas de um produto {@link Integer}
     */
    public void subtrair_stock_existente(int numero_compra){
        this.stockExistente-=numero_compra;
    }

    /**
     * Apenas esta declarada, para depois ser definida em cada subclasse, apenas e chamada quando o produto ja foi comprado
     * @return uma {@link String} com a informacao do produto
     */
    public abstract String print_comprado();
    
}

/**
 * Subclasse do {@link Produto} para fazer a gestao dos produtos alimentares
 */
class Alimentares extends Produto{
    /**
     * Calorias que um produto alimentar tem {@link Double}
     */
    private double calorias;
    /**
     * percentagem de gordura que um produto alimentar tem {@link Integer}
     */
    private int percGordura;

    /**
     * O Construtor desta subclasse constroi/cria um objeto do tipo Produto com base nos parametro passados
     * @param Identificador O identificador do produto {@link String}
     * @param Nome O nome do produto {@link String}
     * @param PrecoUnitario O preco unitario do produto {@link Double}
     * @param stockExistente O stock existente do produto {@link Long}
     * @param calorias As calorias de um produto alimentar {@link Double}
     * @param percGordura A percentagem de gordura de um produto alimentar {@link Integer}
     */

    public Alimentares(String Identificador, String Nome, double PrecoUnitario, long stockExistente, double calorias, int percGordura){
        super(Identificador, Nome, PrecoUnitario, stockExistente);
        this.calorias = calorias;
        this.percGordura = percGordura;
    }

    /**
     * Esta funcao ve se para o produto existe alguma promocaos valida e qual o tipo e calcula o preco a pagar em funcao disso para produtos alimentares
     * @param list_promocoes a lista de promocoes {@link listPromocoes}
     * @param data_atual a data atual do programa {@link Data}
     * @param quantidade as unidades do produto que se pretendem comprar {@link Integer }
     * @return o valor a pagar pela quatidade de produtos
     */
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
            valor=0;
            for(int i = 0;i<quantidade;i++){

                valor += desconto*this.PrecoUnitario;
                
                if(desconto > 0.5){
                    desconto-=0.05;
                }
            }
            
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(pague - menos) "+(valor-(quantidade*this.PrecoUnitario))+" ----- "+valor);

        }

        else if ((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("")){

            valor = quantidade*this.PrecoUnitario;
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"  ----- "+valor);
        }

        return valor;
    }

    /**
     * Apenas e utilizada para mostrar ao utlizador o produto alimentar comprado
     * @return uma {@link String} com a informacao do produto
     */
    public String print_comprado(){
        return "Nome do Produto: "+this.Nome+", Identificador :"+this.Identificador+", Preço: "+this.PrecoUnitario+", Calorias: "+this.calorias+", Percentagem de Gordura: "+this.percGordura+"\n";
    }

    /**
     * E utilizada para mostrar ao utilizador os produtos alimentares disponiveis
     * @return uma {@link String} com informacoes do Produto Alimentar
     */
    @Override
    public String toString(){
        return super.toString()+", Calorias: "+this.calorias+", Percentagem de Gordura: "+this.percGordura+"\n";
    }
    
}

/**
 * Subclasse do {@link Produto} para fazer a gestao dos produtos de limpeza
 */
class Limpeza extends Produto{
    /**
     * grau de toxicidade de um porduto de limpeza {@link Integer}
     */
    private int grauToxicidade;

    /**
     * O Construtor desta subclasse constroi/cria um objeto do tipo Produto com base nos parametro passados
     * @param Identificador O identificador do produto {@link String}
     * @param Nome O nome do produto {@link String}
     * @param PrecoUnitario O preco unitario do produto {@link Double}
     * @param stockExistente O stock existente do produto {@link Long}
     * @param grauToxicidade O grau de toxicidade do um produto de limpeza de 0 a 10  {@link Integer}
     */
    public Limpeza(String Identificador, String Nome, double PrecoUnitario, long stockExistente, int grauToxicidade){
        super(Identificador, Nome, PrecoUnitario, stockExistente);
        this.grauToxicidade = grauToxicidade;    
    }

    /**
     * Esta funcao ve se para o produto existe alguma promocaos valida e qual o tipo e calcula o preco a pagar em funcao disso para produtos de limpeza
     * @param list_promocoes a lista de promocoes {@link listPromocoes}
     * @param data_atual a data atual do programa {@link Data}
     * @param quantidade as unidades do produto que se pretendem comprar {@link Integer }
     * @return o valor a pagar pela quatidade de produtos
     */
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
            
            for(int i = 0;i<quantidade;i++){

                valor += desconto*this.PrecoUnitario;

                if(desconto > 0.5){
                    desconto-=0.05;
                }
            }
            
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(pague - menos) "+(valor-(quantidade*this.PrecoUnitario))+" ----- "+valor);

        }

        else if ((list_promocoes.promocao_existe(this.Identificador, data_atual)).equals("")){
            valor = quantidade*this.PrecoUnitario;
            System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"  ----- "+valor);
        }

        return valor;
    }

    /**
     * Apenas e utilizada para mostrar ao utlizador o produto de limpeza comprado
     * @return uma {@link String} com a informacao do produto
     */
    public String print_comprado(){
        return "Nome do Produto: "+this.Nome+", Identificador :"+this.Identificador+", Preço: "+this.PrecoUnitario+", Grau de Toxicidade: "+this.grauToxicidade+"\n";
    }

    /**
     * E utilizada para mostrar ao utilizador os produtos de limpeza disponiveis
     * @return uma {@link String} com informacoes do Produto de limpeza
     */
    @Override
    public String toString(){
        return super.toString()+", Grau de Toxicidade: "+this.grauToxicidade+"\n";
    }
}

/**
 * Subclasse do {@link Produto} para fazer a gestao dos produtos mobiliarios
 */
class Mobiliario extends Produto{
    /**
     * Peso de uma mobilia {@link Double}
     */
    private double peso;
    /**
     * Largura de uma mobilia {@link Double}
     */
    private double largura;
    /**
     * Comprimento de uma mobilia {@link Double}
     */
    private double comprimento;
    /**
     * Profundidade de uma mobilia {@link Double}
     */
    private double profundidade;

    /**
     * O Construtor desta subclasse constroi/cria um objeto do tipo Produto com base nos parametro passados
     * @param Identificador O identificador do produto {@link String}
     * @param Nome O nome do produto {@link String}
     * @param PrecoUnitario O preco unitario do produto {@link Double}
     * @param stockExistente O stock existente do produto {@link Long}
     * @param peso Peso de uma mobilia {@link Double}
     * @param largura Largura de uma mobilia {@link Double}
     * @param comprimento Comprimento de uma mobilia {@link Double}
     * @param profundidade Profundidade de uma mobilia {@link Double}
     */
    public Mobiliario(String Identificador, String Nome, double PrecoUnitario, long stockExistente, double peso, double largura, double comprimento, double profundidade){
        super(Identificador, Nome, PrecoUnitario, stockExistente);
        this.peso = peso;
        this.largura = largura;
        this.comprimento = comprimento;
        this.profundidade = profundidade;   
    }

    /**
     * Esta funcao ve se para o produto existe alguma promocaos valida e qual o tipo e calcula o preco a pagar em funcao disso para mobilias.
     * Tambem adiciona ao preco 10 euros caso o peso seja superior a 10Kg
     * @param list_promocoes a lista de promocoes {@link listPromocoes}
     * @param data_atual a data atual do programa {@link Data}
     * @param quantidade as unidades do produto que se pretendem comprar {@link Integer }
     * @return o valor a pagar pela quatidade de produtos
     */
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
            
            for(int i = 0;i<quantidade;i++){
                if(desconto > 0.5){
                    desconto-=0.05;
                }
                valor += desconto*this.PrecoUnitario;
            }
            
            
            if (this.peso>15){
                
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(pague - menos) "+(valor-(quantidade*this.PrecoUnitario))+" ----- "+(valor)+" + 10 euros = "+(valor+10));
                valor+=10;
            }
            else{
                System.out.print("\n\t"+this.Nome +" ----- "+quantidade+" * "+this.PrecoUnitario+" ----- "+"(pague - menos) "+(valor-(quantidade*this.PrecoUnitario))+" ----- "+valor);
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

    /**
     * Apenas e utilizada para mostrar ao utlizador a mobilia comprada
     * @return uma {@link String} com a informacao do produto
     */
    public String print_comprado(){
        return "Nome do Produto: "+this.Nome+", Identificador :"+this.Identificador+", Preço: "+this.PrecoUnitario+", Peso: "+this.peso+", Largura: "+this.largura+", Comprimento: "+this.comprimento+", Profundidade: "+this.profundidade+"\n";
    }

    /**
     * E utilizada para mostrar ao utilizador as mobilias disponiveis
     * @return uma {@link String} com informacoes da mobilia
     */
    @Override
    public String toString(){
        return super.toString()+", Peso: "+this.peso+", Largura: "+this.largura+", Comprimento: "+this.comprimento+", Profundidade: "+this.profundidade+"\n";
    }
}