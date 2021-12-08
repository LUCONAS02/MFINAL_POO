package mfinal_poo;
import java.io.Serializable;
import java.util.*;

/**
 * Esta classe serve para gerir os objetos do tipo CestoItem
 */
class CestoItem implements Serializable{
    /**
     * produto que esta no cesto {@link Produto}
     */
    private Produto produto;
    /**
     * quantidade do produto {@link Integer}
     */
    private int quantidade;

    /**
     * O construtor serve para construir/criar um novo objeto do tipo CestoItem
     * @param produto o produto que passa a ser item do cesto
     * @param quantidade a quantidade do produto que o cliente quer
     */
    public CestoItem(Produto produto, int quantidade){

        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * Getter para o produto
     * @return o objeto produto {@link Produto}
     */
    public Produto getProduto(){
        return this.produto;
    }

    /**
     * Getter para a quantidade
     * @return o valor da quantidade {@link Integer}
     */
    public int getQuantidade(){
        return this.quantidade;
    }

    /**
     * Esta funcao serve para adicionar ao atributo quantidade do objeto a quantidade de produto que foi comprada
     * @param numero_compra  quantidade de produto que foi comprada {@link Integer}
     */
    public void add_quantidade(int numero_compra){
        this.quantidade+=numero_compra;
    }

    /**
     * Apenas serve para criar uma string com as informacoes do cestoItem
     * @return uma string com as informacoes do CestoItem {@link String}
     */
    @Override
    public String toString(){
        return "\tQuantidade : "+this.quantidade+", "+produto.print_comprado();
    }
}

/**
 * Serve para fazer a gestao de Cestos
 */
class Cesto implements Serializable {
    /**
     * lista de {@link CestoItem}
     */
    private ArrayList<CestoItem> Cesto;
    /**
     * Serve para criar uma nova ArrayList
     */
    public Cesto(){
        this.Cesto = new ArrayList<CestoItem>();
    }

    /**
     * Esta funcao serve para adicionar um {@link Produto} ao cesto sabendo a quantidade que vai ser comprada. Caso ele ja esteja no cesto so adiciona a quantidade
     * que vai ser comprada, senao cria um novo {@link CestoItem} com a quantidade que vai ser comprada. A list_products tem de
     * ser passada como parametro para depois poder ser retirado ao stock a quantidade que vai ser comprada.
     * @param produto produto a ser adicionado/atualizado {@link Produto}
     * @param numero_compra quantidade de produto que vai ser comprada {@link Integer}
     * @param list_products a lista com os produtos disponiveis {@link listProdutos}
     */
    public void add_cesto(Produto produto,int numero_compra, listProdutos list_products){
        boolean existe= false;
        for(CestoItem i: Cesto){
            if(produto.getIdentificador().equals(i.getProduto().getIdentificador())){
                existe = true;
                
                i.add_quantidade(numero_compra);
                break;
            }
             
        }
        if (!existe){
            CestoItem newItem = new CestoItem(produto,numero_compra); 
            Cesto.add(newItem);
            
        }
        list_products.retirar_stock(produto, numero_compra);
    }

    /**
     * Esta funcao serve para dar print a todos os itens do Cesto
     */
    public void print_all(){
        for(CestoItem i :Cesto){
            System.out.print("\t"+i);
        }
    }

    /**
     * Esta funcao vai calcular o total a pagar sem os custos de transporte
     * @param list_promocoes lista de promocoes {@link listPromocoes}
     * @param data_atual data que esta em vigor no programa {@link Data}
     * @return o valor total a pagar sem transportes {@link Double}
     */
    public double calcular_conta(listPromocoes list_promocoes,Data data_atual){
        double conta = 0;
        double valor = 0;
        System.out.print("\n\n      Nome do Produto ----- Quantidade * Preço por unidade ----- Promoções ----- Preço final \n   ");
        for(CestoItem i :Cesto){
            valor = i.getProduto().calcular_valor(list_promocoes, data_atual,i.getQuantidade());
            conta+=valor;
        }
        
        return conta;
        
    }

    /**
     * Serve para saber o tamanho do cesto, isto e, o numero de itens nele
     * @return o numero de itens no cesto {@link Integer}
     */
    public int size(){
        return Cesto.size();
    }
}
