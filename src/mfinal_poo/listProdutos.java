package mfinal_poo;

import java.util.*;
import java.io.*;

class listProdutos implements Serializable {
    private ArrayList<Produto> list_produtos;

    public listProdutos(){
        list_produtos = new ArrayList<Produto>();
    }

    public void  get_all_produtos(){
        File f = new File("./Ficheiros_objeto\\Produtos.obj");
        try{
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            list_produtos = (ArrayList<Produto>)ois.readObject();
            ois.close();
        } 
        catch(FileNotFoundException ex) {
            File f_ = new File("./Ficheiros_txt\\Produtos.txt");
            if(f_.exists() && f_.isFile()) {
                try{
                    FileReader fr= new FileReader(f_);
                    BufferedReader br= new BufferedReader(fr);
                    String line,final_="";
                    while((line= br.readLine()) != null) {
                        final_+=line;
                    }
                    br.close();

                    //System.out.print(final_);
                    String[] splited_point = final_.split(";");
                    //System.out.print(Arrays.toString(splited_point));
                    
                    for (String i : splited_point){

                        String[] produtos_info = i.split(": ");

                        if (produtos_info[0].equals("Alimentar")){
                            String[] produto_info = produtos_info[1].split(", ");
                            Produto newProduto = new Alimentares(produto_info[0], produto_info[1], Double.parseDouble(produto_info[2]), Long.parseLong(produto_info[3]), Double.parseDouble(produto_info[4]), Integer.parseInt(produto_info[5]));
                            list_produtos.add(newProduto);
                        }
                        else if (produtos_info[0].equals("Limpeza")){
                            String[] produto_info = produtos_info[1].split(", ");
                            Produto newProduto = new Limpeza(produto_info[0], produto_info[1], Double.parseDouble(produto_info[2]), Long.parseLong(produto_info[3]),Integer.parseInt(produto_info[4]));
                            list_produtos.add(newProduto);
                        }
                        else if (produtos_info[0].equals("Mobiliario")){
                            String[] produto_info = produtos_info[1].split(", ");
                            Produto newProduto = new Mobiliario(produto_info[0], produto_info[1], Double.parseDouble(produto_info[2]), Long.parseLong(produto_info[3]),Double.parseDouble(produto_info[4]), Double.parseDouble(produto_info[5]), Double.parseDouble(produto_info[6]), Double.parseDouble(produto_info[7]));
                            list_produtos.add(newProduto);
                        }
                        
                    }


                    File f__ = new File("./Ficheiros_objeto\\Produtos.obj");
                    
                    try{
                        FileOutputStream fos= new FileOutputStream(f__);
                        ObjectOutputStream oos= new ObjectOutputStream(fos);
                        oos.writeObject(list_produtos);
                        oos.close();
                    } 
                    catch(FileNotFoundException ex2) {
                        System.out.println("Erro a criar ficheiro.");
                    } 
                    catch(IOException ex2) {
                        System.out.println("Erro a escrever para o ficheiro.");
                    }
                    
                } 
                catch(FileNotFoundException ex1) {
                    System.out.println("Erro a abrir ficheiro de texto.");
                } 
                catch(IOException ex1) {
                    System.out.println("Erro a ler ficheiro de texto.");
                }
            } 

            else{
                System.out.println("Ficheiro não existe.");
            }
        } 
        catch(IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } 
        catch(ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

    public void add(Produto produto){
        list_produtos.add(produto);
    }

    public void print_all(){
        for (int j=0;j<list_produtos.size();j++){
            System.out.print(j+1+" - "+list_produtos.get(j));
        }
    }

    public int size(){
        return list_produtos.size();
    }

    public Produto get(int index){
        return list_produtos.get(index);
    }

    public void retirar_stock(Produto produtos,int numero_compra){
        for(Produto i: list_produtos){
            if(i.getIdentificador().equals(produtos.getIdentificador())){
                
                i.subtrair_stock_existente(numero_compra);
    
            }
        }
    }
    
}
