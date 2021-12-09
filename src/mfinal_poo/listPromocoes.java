package mfinal_poo;

import java.util.*;
import java.io.*;

/**
 * Para fazer a gestao de lista de promocoes
 */
public class listPromocoes {
    /**
     * lista de {@link Promocoes}
     */
    private ArrayList<Promocoes> list_promo;

    /**
     * Serve para criar uma nova ArrayList
     */
    public listPromocoes(){
        this.list_promo = new ArrayList<Promocoes>();
    }

    /**
     * Adicionar uma promocao a lista de promocoes
     * @param promocao promocao a ser adicionada {@link Promocoes}
     */
    public void add(Promocoes promocao){
        list_promo.add(promocao);
    }

    /**
     * Escreve todas as promocoes existentes, esta funcao nunca e utilizada apenas para teste
     */
    public void print_all(){
        for(Promocoes i : list_promo){
            System.out.print(i);
        }
    }

    /**
     * Esta funcao tenta ler o ficheiro objeto (promocoes.obj) onde esta guardada a lista de promocoes.
     * Se conseguir define a lista de promocoes igual a lida.
     * Se esse nao existir entao vai ler do ficheiro txt (Promocoes.txt) passar os valores lidos para a lista de promocoes e escrever no ficheiro objeto (promocoes.obj).
     */
    public void get_file(){

        File f = new File("./Ficheiros_objeto\\promocoes.obj");
        try{
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            try{
                list_promo = (ArrayList<Promocoes>)ois.readObject();
            }
            catch(ClassCastException ex__){
                System.out.print("Erro a fazer o cast para ArrayList<Promocoes>");
            }
            
            ois.close();
        } 
        catch(FileNotFoundException ex) {
            File f_ = new File("./Ficheiros_txt\\Promocoes.txt");
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
                    String[] splited_point = final_.split("!");
                    //System.out.print(Arrays.toString(splited_point));

                    for (String i : splited_point){

                        String[] promocoes_info = i.split(";");
                        String[] promocoes_datas = promocoes_info[2].split("-");

                        String[] data_inicio= promocoes_datas[0].split("/");
                        Data newdatainicio = new Data(Integer.parseInt(data_inicio[0]),Integer.parseInt(data_inicio[1]),Integer.parseInt(data_inicio[2]));

                        String[] data_fim = promocoes_datas[1].split("/");
                        Data newdatafim = new Data(Integer.parseInt(data_fim[0]),Integer.parseInt(data_fim[1]),Integer.parseInt(data_fim[2]));

                        Promocoes newPromocao = new Promocoes(promocoes_info[0], promocoes_info[1], newdatainicio, newdatafim);
                        //System.out.print(newPromocao);
                        list_promo.add(newPromocao);
                    }

                    File f__ = new File("./Ficheiros_objeto\\promocoes.obj");
                    
                    try{
                        FileOutputStream fos= new FileOutputStream(f__);
                        ObjectOutputStream oos= new ObjectOutputStream(fos);
                        oos.writeObject(list_promo);
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
     * Esta funcao serve para indicar se um produto tem ou nao promocao e se tem qual o tipo
     * @param identificador o identificador do produto
     * @param data_atual data atual do sistema
     * @return uma {@link String} que sera ou leve4pague3 ou paguemenos ou "",este ultimo significa que nada foi encontrado
     */
    public String promocao_existe(String identificador,Data data_atual){
        String existe_promo="";
        for (Promocoes i: list_promo){
            if((i.getidentificador().equals(identificador)) && (i.getFim().cmp_max(data_atual) && i.getInicio().cmp_min(data_atual))){
                existe_promo = i.getmodalidade();
                break;
            }
        }
        return existe_promo;
        
    }
}
