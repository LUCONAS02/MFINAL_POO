package mfinal_poo;

import java.io.*;
import java.util.*;

public class MFINAL_POO {

    public static void main(String[] args) {

        Data data_atual = new Data(20,12,2002); // defino qual a data do sistema

        File file = new File("./Ficheiros_objeto"); //crio a pasta onde vão ser guardados os ficheiros objeto 
        file.mkdir();
    
        listPromocoes promo = new listPromocoes(); //crio uma lista promoção, onde vou guardar a informação das promoções
        promo.get_file();
        
    
        listProdutos list_produtos = new listProdutos(); //crio uma lista produtos, onde vou guardar a informação dos produtos
        list_produtos.get_all_produtos();

        listClientes list_clientes = new listClientes(); //crio uma lista clientes, onde vou guardar a informação dos clientes
        list_clientes.get_all_clientes();
        
        

        
        int opcao_1 =1;

        while(opcao_1!=0){
            System.out.print("\n----------MENU----------\n");
            System.out.print("      1 - Login        \n");
            System.out.print("      0 - Sair        \n\n");

            Scanner sc_opcao_1 = new Scanner(System.in);

            System.out.print("O que deseja fazer??: ");
            opcao_1 = sc_opcao_1.nextInt();
            
            if(opcao_1==1){

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

                System.out.print("\n\n\t\t Bem vindo à sua conta "+ mail);
            
                int opcao_cliente = 1;
                    while(opcao_cliente != 0){
                    System.out.print("\n\n\n--------MENU CLIENTE--------\n");
                    System.out.print("      1- Fazer compras      \n");
                    System.out.print(" 2 - Ver compras realizadas \n");
                    System.out.print("         0- Log Out         \n");

                    Scanner sc_opcao_cliente = new Scanner(System.in);

                    System.out.print("O que deseja fazer??: ");
                    opcao_cliente = sc_opcao_cliente.nextInt();

                    if (opcao_cliente == 1){

                        Cesto cesto_de_compras = new Cesto();

                        System.out.print("Produtos dísponiveis:\n\n");
                        list_produtos.print_all();
                        
                        Scanner sc_n_produto = new Scanner(System.in);
                        System.out.print("\nQual o produto que deseja comprar?? (1-"+list_produtos.size()+"): ");
                        int n_produto = sc_n_produto.nextInt();
                        
                        while(n_produto<1 || n_produto>list_produtos.size()){
                            System.out.print("Opção inválida.\n");
                            System.out.print("Qual o produto que deseja comprar?? (1-"+list_produtos.size()+"): ");
                            n_produto = sc_n_produto.nextInt();
                        }

                        Produto produto_selecionado = list_produtos.get(n_produto-1);

                        Scanner sc_quan_produto = new Scanner(System.in);
                        System.out.print("Qual a quantidade de "+produto_selecionado.Nome+" é que quer comprar?? (Se já não quiser comprar escreva 0):");
                        int quan_produto = sc_quan_produto.nextInt();
                        
                        while(quan_produto>produto_selecionado.stockExistente || quan_produto<0){
                            System.out.print("O stock existente é "+produto_selecionado.stockExistente+" e portanto insuficiente para o seu pedido.");
                            System.out.print("\nQual a quantidade de "+produto_selecionado.Nome+" é que quer comprar?? (Se já não quiser comprar escreva 0):");
                            quan_produto = sc_quan_produto.nextInt();
                        }

                        if(quan_produto!=0){
                            cesto_de_compras.add_cesto(produto_selecionado, quan_produto, list_produtos);
                        }

                        if(cesto_de_compras.size()!=0){
                            System.out.print("\n\tO seu cesto atualmente:\n\n");
                            cesto_de_compras.print_all();
                        }
                        

                        Scanner sc_compras = new Scanner(System.in);
                        System.out.print("\n\nDeseja comprar mais algum produto?? (1 - Sim / 0 - Nao) : ");
                        int continuar_compras = sc_compras.nextInt();

                        while (!(continuar_compras == 1 || continuar_compras == 0)) {

                            System.out.print("Opção inválida\n");
                            System.out.print("Deseja comprar mais algum produto?? (1 - Sim / 0 - Nao) : ");
                            continuar_compras = sc_compras.nextInt();

                        }
                        
                        while (continuar_compras == 1) {

                            System.out.print("Produtos dísponiveis:\n\n");
                            list_produtos.print_all();
                            
                            sc_n_produto = new Scanner(System.in);
                            System.out.print("\nQual o produto que deseja comprar?? (1-"+list_produtos.size()+"): ");
                            n_produto = sc_n_produto.nextInt();
                            
                            while(n_produto<1 || n_produto>list_produtos.size()){
                                System.out.print("Opção inválida.\n");
                                System.out.print("Qual o produto que deseja comprar?? (1-"+list_produtos.size()+"): ");
                                n_produto = sc_n_produto.nextInt();
                            }
        
                            produto_selecionado = list_produtos.get(n_produto-1);
        
                            sc_quan_produto = new Scanner(System.in);
                            System.out.print("Qual a quantidade de "+produto_selecionado.Nome+" é que quer comprar?? (Se já não quiser comprar escreva 0):");
                            quan_produto = sc_quan_produto.nextInt();
        
                            while(quan_produto>produto_selecionado.stockExistente || quan_produto<0){
                                System.out.print("O stock existente é "+produto_selecionado.stockExistente+" e portanto insuficiente para o seu pedido.");
                                System.out.print("\nQual a quantidade de "+produto_selecionado.Nome+" é que quer comprar?? (Se já não quiser comprar escreva 0):");
                                quan_produto = sc_quan_produto.nextInt();
                            }
                            
                            if(quan_produto!=0){
                                cesto_de_compras.add_cesto(produto_selecionado, quan_produto, list_produtos);
                            }
                            
                            if(cesto_de_compras.size()!=0){
                                System.out.print("\n\tO seu cesto atualmente:\n\n");
                                cesto_de_compras.print_all();
                            }

                            System.out.print("\n\nDeseja comprar mais algum produto?? (1 - Sim / 0 - Nao) : ");
                            continuar_compras = sc_compras.nextInt();

                            while (!(continuar_compras == 1 || continuar_compras == 0)) {

                                System.out.print("Opção inválida\n");
                                System.out.print("Deseja comprar mais algum produto?? (1 - Sim / 0 - Nao) : ");
                                continuar_compras = sc_compras.nextInt();

                            }

                        }
                        if(continuar_compras ==0){
                            if(cesto_de_compras.size()!=0){
                                
                                list_clientes.add_compras(mail, cesto_de_compras);

                                System.out.print("Conta Final: ");
                                double conta = cesto_de_compras.calcular_conta(promo, data_atual);

                                if (tipo_cliente =="frequente" && conta<40){
                                    conta+=15;
                                    System.out.print("\n\n\tCustos de transporte : 15 euros "); 
                                }
                                else{
                                    System.out.print("\n\n\tCusto de transporte : 20 euros");
                                }
                                
                                System.out.print("\n\n\t\t TOTAL : "+conta);
                            }
                            else{
                                System.out.print("\n\tO seu cesto estava vazio!!");
                            }
                            
                        }
                        
                    }
                    else if (opcao_cliente == 2){
                        
                        list_clientes.print_all_clientes(mail);
                    }

                    }

            }

            if (opcao_1 !=0 && opcao_1 !=1){
                System.out.print("Não existe a opção "+opcao_1+".\n\n");
            }
            
        }
        
        
        
    }
    
}
