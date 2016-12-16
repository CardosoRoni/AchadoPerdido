package unoesc.edu.br.achadoperdido.perdido;

/**
 * Created by Roni on 16/12/2016.
 */

public class Perdido {
    private Long id;
    private String data;
    private String descricao;
    private String categoria;
    private String contato;
    public static final String ID = "_id";
    public  static final String DATA="data";
    public static final String CATEGORIA = "categoria";
    public static final String DESCRICAO = "descricao";
    public static final String CONTATO= "contato";


    public static final String TABELA = "perdido";
    public static final String[] COLUNAS = {ID,DATA,CATEGORIA,
            DESCRICAO,CONTATO};


    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}





