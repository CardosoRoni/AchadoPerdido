package unoesc.edu.br.achadoperdido.achado;

/**
 * Created by root on 14/12/16.
 */

public class Achado {

    private Long id;
    private String data;
    private String descricao;
    private String categoria;
    private String latitude;
    private String longitude;
    private String contato;
    private String foto;

    public static final String ID = "_id";
    public static final String DATA = "data";
    public static final String DESCRICAO = "descricao";
    public static final String CATEGORIA = "categoria";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String CONTATO = "contato";
    public static final String FOTO = "foto";

    public static final String TABELA = "achado";
    public static final String[] COLUNAS = {ID, DATA, DESCRICAO, CATEGORIA,
            LATITUDE, LONGITUDE, CONTATO, FOTO};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
}