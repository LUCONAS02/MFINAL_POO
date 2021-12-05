package mfinal_poo;

import java.util.*;
import java.io.*;
public class listPromocoes {

    private ArrayList<Promocoes> list_promo;

    public listPromocoes(){
        this.list_promo = new ArrayList<>();
    }

    public void add(Promocoes promocao){
        list_promo.add(promocao);
    }
    
    public void print_all(){
        for(Promocoes i : list_promo){
            System.out.print(i);
        }
    }
    public void get_file(){

        File f = new File("./Ficheiros_objeto\\promocoes.obj");
        try{
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            list_promo = (ArrayList<Promocoes>)ois.readObject();
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

    public String promocao_existe(String identificador,Data data_atual){
        String existe_promo="";
        for (Promocoes i: list_promo){
            if((i.identificador.equals(identificador)) && (i.fim.cmp_max(data_atual) && i.inicio.cmp_min(data_atual))){
                existe_promo = i.modalidade;
            }
        }
        return existe_promo;
        
    }
}
