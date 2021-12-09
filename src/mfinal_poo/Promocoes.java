package mfinal_poo;

import java.io.Serializable;

/**
 * Class promocoes usada para gerir informacoess sobre as promocoes está associada ao identificador de um {@link Produto}
 */
public class Promocoes implements Serializable{
    /**
     *  O identificador do produto a que esta associado a promocao {@link String}
     */
    private String identificador;
    /**
     *  A modalidade da promocao {@link String}
     */
    private String modalidade;
    /**
     *  A data de princípio da promocao {@link Data}
     */
    private Data inicio;
    /**
     *  A data do fim da promocao {@link Data}
     */
    private Data fim;

    /**
     * O construtor serve para construir/criar um objeto do tipo promocoes com base nos parametros passados
     * @param identificador O identificador do produto a que esta associado a promocao {@link String}
     * @param modalidade A modalidade da promocao {@link String}
     * @param inicio A data de princípio da promocao {@link Data}
     * @param fim A data do fim da promocao {@link Data}
     */

    public Promocoes(String identificador, String modalidade, Data inicio, Data fim){
        this.identificador = identificador;
        this.modalidade = modalidade;
        this.inicio = inicio;
        this.fim = fim;
    }
    /**
     * Getter do Identificador 
     * @return identificador {@link String}
     */
    public String getidentificador(){
        return this.identificador;
    }
    /**
     * Getter da modalidade
     * @return modalidade da promocao {@link String}
     */
    public String getmodalidade(){
        return this.modalidade;
    }
    /**
     * Getter do inicio
     * @return a data em que comeca a promocao {@link Data}
     */
    public Data getInicio(){
        return this.inicio;
    }
    /**
     * Getter do fim
     * @return a data em que acaba a promocao {@link Data}
     */
    public Data getFim(){
        return this.fim;
    }
    
    /**
     * Esta funcao serve para escrever a informacao das promocoes
     * @return uma string que contêm toda a inormacao de um objeto do tipo {@link Promocoes}
     */
    @Override
    public String toString(){
        return identificador+" "+modalidade+" "+inicio+" "+fim+"\n";
    }
}
