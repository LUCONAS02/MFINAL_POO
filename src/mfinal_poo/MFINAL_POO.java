package mfinal_poo;

import java.io.*;
import java.util.*;

/**
 * Onde esta o main
 */
public class MFINAL_POO {
    /**
     *
     * @author Lucas Anjo, Afonso Melo
     */
    /**
     * Onde e corrido o menu, isto e, onde e processada toda a informacao que e pedida ao utilizador, e onde sao chamadas todas
     * as funcoes e inicializadas todas as variaveis
     * @param args neste caso esta list esta vazia
     * @throws InputMismatchException Este erro acontece porque o utilizador pode se ter enganado e por uma letra em vez de um numero inteiro inteiro
     * e ao chegar a scanner.nexInt() este erro vai ser enviado.
     */
    public static void main(String[] args) {
        /**
         *
         */
        Data data_atual = new Data(20,12,2002); //defino qual a data do sistema

        File file = new File("./Ficheiros_objeto"); //crio a pasta onde vão ser guardados os ficheiros objeto 
        file.mkdir();
    
        listPromocoes promo = new listPromocoes(); //crio uma lista promoção, onde vou guardar a informação das promoções
        promo.get_file();
        
    
        listProdutos list_produtos = new listProdutos(); //crio uma lista produtos, onde vou guardar a informação dos produtos
        list_produtos.get_all_produtos();

        listClientes list_clientes = new listClientes(); //crio uma lista clientes, onde vou guardar a informação dos clientes
        list_clientes.get_all_clientes();
        
        
        int opcao_1 =1;

        boolean erro = false;
        while(opcao_1!=0){
            System.out.print("\n----------MENU----------\n"); //
            System.out.print("      1 - Login        \n");
            System.out.print("      0 - Sair        \n\n");

            Scanner sc_opcao_1 = new Scanner(System.in);

            System.out.print("O que deseja fazer??: ");

            try{
                opcao_1 = sc_opcao_1.nextInt();
                erro= false;
            }
            catch (InputMismatchException ex__){
                System.out.print("Tem que inserir um número!!\n");
                erro= true;
            }
            
            if(opcao_1==1 && (!erro)){

                Scanner sc_mail = new Scanner(System.in);

                System.out.print("Qual o seu email: ");
                String mail = sc_mail.nextLine();
                
                String tipo_cliente = list_clientes.cliente_existe(mail);
                

                while((!(mail.contains("@")))||tipo_cliente.equals("")){ 

                    System.out.print("Email inválido.\n");
                    System.out.print("Qual o seu email: ");
                    mail = sc_mail.nextLine();
                    tipo_cliente = list_clientes.cliente_existe(mail);
                }

                System.out.print("\n\n\t\t Bem vindo à sua conta "+ list_clientes.get_name_by_mail(mail));
            
                int opcao_cliente = 1;
                    while(opcao_cliente != 0){
                        System.out.print("\n\n\n--------MENU CLIENTE--------\n");
                        System.out.print("      1- Fazer compras      \n");
                        System.out.print(" 2 - Ver compras realizadas \n");
                        System.out.print("         0- Log Out         \n");

                        Scanner sc_opcao_cliente = new Scanner(System.in);

                        System.out.print("O que deseja fazer??: ");

                        try{
                            opcao_cliente = sc_opcao_cliente.nextInt();
                            erro= false;
                        }
                        catch (InputMismatchException ex__){
                            System.out.print("Tem que inserir um número!!\n");
                            erro= true;
                        }
                        

                        if (opcao_cliente == 1 && (!erro)){

                            Cesto cesto_de_compras = new Cesto();

                            int continuar_compras =1;
                            while (continuar_compras == 1) {
                                System.out.print("Produtos dísponiveis:\n\n");
                                list_produtos.print_all();
                                
                                int n_produto=0;

                                erro=true;
                                while(erro){    
                                    try{
                                        Scanner sc_n_produto = new Scanner(System.in);
                                        System.out.print("\nQual o produto que deseja comprar?? (1-"+list_produtos.size()+"): ");
                                        n_produto = sc_n_produto.nextInt();
                                        erro =false;
                                    }
                                    catch(InputMismatchException ev){
                                        System.out.print("Tem que inserir um número!!\n");
                                        erro=true;
                                        
                                    }
                                }
                                
                                
                                while((n_produto<1 || n_produto>list_produtos.size())){
                                    System.out.print("Opção inválida.\n");

                                    erro=true;
                                    while(erro){    
                                        try{
                                            Scanner sc_n_produto = new Scanner(System.in);
                                            System.out.print("\nQual o produto que deseja comprar?? (1-"+list_produtos.size()+"): ");
                                            n_produto = sc_n_produto.nextInt();
                                            erro =false;
                                        }
                                        catch(InputMismatchException ev){
                                            System.out.print("Tem que inserir um número!!\n");
                                            erro=true;
                                            
                                        }
                                    }
                                }

                                Produto produto_selecionado = list_produtos.get(n_produto-1);

                                int quan_produto = 0;

                                erro = true;
                                while(erro){
                                    try{
                                        Scanner sc_quan_produto = new Scanner(System.in);
                                        System.out.print("Qual a quantidade de "+produto_selecionado.getNome()+" é que quer comprar?? (Se já não quiser comprar escreva 0):");
                                        quan_produto = sc_quan_produto.nextInt();
                                        erro = false;
                                    }
                                    catch(InputMismatchException ev){
                                        System.out.print("Tem que inserir um número!!\n");
                                        erro=true;
                                        
                                    }
                                }
                                while(quan_produto>produto_selecionado.getStockExistente() || quan_produto<0){
                                    System.out.print("O stock existente é "+produto_selecionado.getStockExistente()+" e portanto insuficiente para o seu pedido.\n");
                                    erro = true;
                                    while(erro){
                                        try{
                                            Scanner sc_quan_produto = new Scanner(System.in);
                                            System.out.print("Qual a quantidade de "+produto_selecionado.getNome()+" é que quer comprar?? (Se já não quiser comprar escreva 0):");
                                            quan_produto = sc_quan_produto.nextInt();
                                            erro = false;
                                        }
                                        catch(InputMismatchException ev){
                                            System.out.print("Tem que inserir um número!!\n");
                                            erro=true;
                                            
                                        }
                                    }
                                }

                                if(quan_produto!=0){
                                    cesto_de_compras.add_cesto(produto_selecionado, quan_produto, list_produtos);
                                }

                                if(cesto_de_compras.size()!=0){
                                    System.out.print("\n\tO seu cesto atualmente:\n\n");
                                    cesto_de_compras.print_all();
                                }
                                
                                continuar_compras = 0; 

                                erro = true;
                                while (erro){    
                                    try{
                                        Scanner sc_compras = new Scanner(System.in);
                                        System.out.print("\n\nDeseja comprar mais algum produto?? (1 - Sim / 0 - Nao) : ");
                                        continuar_compras = sc_compras.nextInt();
                                        erro= false;
                                    }
                                    catch(InputMismatchException evv){
                                        System.out.print("Tem que inserir um número!!\n");
                                        erro=true;
                                    }
                                }

                                while (!(continuar_compras == 1 || continuar_compras == 0)) {

                                    System.out.print("Opção inválida\n");

                                    erro = true;
                                    while (erro){    
                                        try{
                                            Scanner sc_compras = new Scanner(System.in);
                                            System.out.print("\n\nDeseja comprar mais algum produto?? (1 - Sim / 0 - Nao) : ");
                                            continuar_compras = sc_compras.nextInt();
                                            erro = false;
                                        }
                                        catch(InputMismatchException evv){
                                            System.out.print("Tem que inserir um número!!\n");
                                            erro=true;
                                        }
                                    }


                                }
                                
                            }
                            if(continuar_compras ==0){
                                if(cesto_de_compras.size()!=0){
                                    
                                    list_clientes.add_compras(mail, cesto_de_compras);

                                    System.out.print("Conta Final: ");
                                    double conta = cesto_de_compras.calcular_conta(promo, data_atual);

                                    if (tipo_cliente.equals("frequente") && conta<40){
                                        conta+=15;
                                        System.out.print("\n\n\tCustos de transporte : 15 euros "); 
                                    }
                                    if(tipo_cliente.equals("normal")){
                                        conta+=20;
                                        System.out.print("\n\n\tCusto de transporte : 20 euros");
                                    }
                                    
                                    System.out.print("\n\n\t\t TOTAL : "+conta);
                                }
                                else{
                                    System.out.print("\n\tO seu cesto estava vazio!!");
                                }
                                
                            }
                            
                        }
                        else if (opcao_cliente == 2 && (!erro)){
                            
                            list_clientes.print_all_clientes(mail);
                        }

                    }

            }

            if ((opcao_1 !=0 && opcao_1 !=1)&& !erro ){
                System.out.print("Não existe a opção "+opcao_1+".\n\n");
            }
            
        }
        
        
        
    }
    
}
