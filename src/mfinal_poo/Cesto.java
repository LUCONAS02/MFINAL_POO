package mfinal_poo;
import java.io.Serializable;
import java.util.*;

class CestoItem implements Serializable{
    private Produto produto;
    protected int quantidade;

    public Produto getProduto(){
        return this.produto;
    }

    

    public CestoItem(Produto produto, int quantidade){
        
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString(){
        return "\tQuantidade : "+this.quantidade+", "+produto.print_comprado();
    }
}

class Cesto implements Serializable {
    private ArrayList<CestoItem> Cesto;
    
    public Cesto(){
        this.Cesto = new ArrayList<CestoItem>();
    }

    public void add_cesto(Produto produto,int numero_compra, listProdutos list_products){
        boolean existe= false;
        for(CestoItem i: Cesto){
            if(produto.getIdentificador().equals(i.getProduto().getIdentificador())){
                existe = true;
                
                i.quantidade+=numero_compra;
                break;
            }
             
        }
        if (!existe){
            CestoItem newItem = new CestoItem(produto,numero_compra); 
            Cesto.add(newItem);
            
        }
        list_products.retirar_stock(produto, numero_compra);
    }

    public void print_all(){
        for(CestoItem i :Cesto){
            System.out.print("\t"+i);
        }
    }

    public double calcular_conta(listPromocoes list_promocoes,Data data_atual){
        double conta = 0;
        double valor = 0;
        System.out.print("\n\n      Nome do Produto ----- Quantidade * Preço por unidade ----- Promoções ----- Preço final \n   ");
        for(CestoItem i :Cesto){
            valor = i.getProduto().calcular_valor(list_promocoes, data_atual,i.quantidade);
            conta+=valor;
            /*
            if((list_promocoes.promocao_existe(i.produto.Identificador, data_atual)).equals("leve4pague3")){
                int promo = i.quantidade/4;
                int normal = i.quantidade%4;

                valor = promo*3*i.produto.PrecoUnitario + normal*i.produto.PrecoUnitario;
                conta+=valor;

                
            }

            if((list_promocoes.promocao_existe(i.produto.Identificador, data_atual)).equals("paguemenos")){
                
                
                
            }

            if((list_promocoes.promocao_existe(i.produto.Identificador, data_atual)).equals("")){
                
            }
            */
        }
        
        return conta;
        

    }

    public int size(){
        return Cesto.size();
    }
}
