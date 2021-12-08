package mfinal_poo;

import java.io.*;
import java.util.*;
/**
 * Para fazer a gestao de lista de clientes
 */
public class listClientes implements Serializable{
    /**
     * lista de {@link Cliente}
     */
    private ArrayList<Cliente> lista_de_clientes;
    /**
     * Serve para criar uma nova ArrayList
     */
    public listClientes(){
        this.lista_de_clientes = new ArrayList<Cliente>();
    }
    /**
     * Esta funcao tenta ler o ficheiro objeto (Clientes.obj) onde esta guardada a lista de clientes.
     * Se conseguir define a lista de clientes igual a lida.
     * Se esse nao existir entao vai ler do ficheiro txt (Clientes.txt) passar os valores lidos para a lista de clientes e escrever no ficheiro objeto (Clientes.obj).
     */
    public void  get_all_clientes(){
        File f = new File("./Ficheiros_objeto\\Clientes.obj");
        try{
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            try{
                lista_de_clientes = (ArrayList<Cliente>)ois.readObject();
            }
            catch(ClassCastException ex__){
                System.out.print("Erro a fazer o cast para ArrayList<Produto>");
            }
            ois.close();
        } 
        catch(FileNotFoundException ex) {
            File f_ = new File("./Ficheiros_txt\\Clientes.txt");

            if(f_.exists() && f_.isFile()) {
                try{
                    FileReader fr= new FileReader(f_);
                    BufferedReader br= new BufferedReader(fr);
                    String line,final_="";
                    while((line= br.readLine()) != null) {
                        final_+=line;
                    }
                    br.close();

                    
                    String[] clientes_info = final_.split(";");
                    
                    
                    for (String i : clientes_info){

                        String[] clientes_info_splited = i.split(", ");
                        
                        comprasList newCompras_efetuadas = new comprasList();

                        String[] data_ = clientes_info_splited[4].split("/");
                        Data data_nascimento = new Data(Integer.parseInt(data_[0]),Integer.parseInt(data_[1]),Integer.parseInt(data_[2]));

                        Cliente newCliente = new Cliente(clientes_info_splited[0], clientes_info_splited[1],clientes_info_splited[2],clientes_info_splited[3],data_nascimento,clientes_info_splited[5],newCompras_efetuadas);
                        lista_de_clientes.add(newCliente);

                    }
                    

                    File f__ = new File("./Ficheiros_objeto\\Clientes.obj");
                    
                    try{
                        FileOutputStream fos= new FileOutputStream(f__);
                        ObjectOutputStream oos= new ObjectOutputStream(fos);
                        oos.writeObject(lista_de_clientes);
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

    /**
     * Esta funcao da print a informacoes do {@link Cliente} que tem como mail o parametro passado
     * @param mail mail do cliente {@link String}
     */
    public void print_all_clientes(String mail){

        for (Cliente i : lista_de_clientes){
            if(i.getMail().equals(mail)){
                i.print_cliente();
            }
        }
              
    
    }

    /**
     * Esta funcao serve para saber se um cliente esta ou nao na lista de clientes
     * @param mail o mail do cliente
     * @return o tipo de cliente, caso else exista e "" caso ele nao exista
     */
    public String cliente_existe(String mail){
        for (Cliente i :lista_de_clientes){
            if(i.getMail().equals(mail)){
                return i.getTipo_de_cliente();
            }
        }
        return "";
    }

    /**
     * Adicionar o {@link Cesto} de um {@link Cliente} a sua {@link comprasList}, atualizar a lsita de clientes e voltar a escrever no ficheiro objeto.
     * @param mail o mail do cliente a que se vai adicionar o cesto {@link String}
     * @param cesto o cesto a ser adicionado {@link Cesto}
     */
    public void add_compras(String mail,Cesto cesto){
        for(Cliente i :lista_de_clientes){
            if(i.getMail().equals(mail)){
                i.getComprasefetuadas().add(cesto);
            }
        }
        File f__ = new File("./Ficheiros_objeto\\Clientes.obj");
                    
        try{
            FileOutputStream fos= new FileOutputStream(f__);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(lista_de_clientes);
            oos.close();
        } 
        catch(FileNotFoundException ex2) {
            System.out.println("Erro a criar ficheiro.");
        } 
        catch(IOException ex2) {
            System.out.println("Erro a escrever para o ficheiro.");
        }

    }

    /**
     * Esta funcao apenas serve para teste e da print a todos os {@link Cliente}
     */
    public void print_all_compras(){
        for(Cliente i:lista_de_clientes){
            i.print_cliente();
        }
    }

    /**
     * Esta funcao serve para obter o nome de um cliente sabendo o seu mail
     * @param mail o mail do cliente que se deseja saber o nome
     * @return o nome do clinete ou "",caso ele nao exista
     */
    public String get_name_by_mail(String mail){
        for (Cliente i :lista_de_clientes){
            if(i.getMail().equals(mail)){
                return i.getNome();
            }
        }
        return "";
    }

}
