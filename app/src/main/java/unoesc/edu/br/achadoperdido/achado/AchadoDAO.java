package unoesc.edu.br.achadoperdido.achado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import unoesc.edu.br.achadoperdido.sqlite.BancoDados;
import unoesc.edu.br.achadoperdido.sqlite.SQLiteHelper;

/**
 * Created by root on 14/12/16.
 */

public class AchadoDAO {

    SQLiteDatabase db;

    public AchadoDAO(Context context) {
        db = BancoDados.getDB(context);
    }

    public void salvar(Achado achado) {
        ContentValues values = new ContentValues();
        values.put(Achado.DATA, achado.getData());
        values.put(Achado.DESCRICAO, achado.getDescricao());
        values.put(Achado.CATEGORIA, achado.getCategoria());
        values.put(Achado.LATITUDE, achado.getLatitude());
        values.put(Achado.LONGITUDE, achado.getLongitude());
        values.put(Achado.CONTATO, achado.getContato());
        values.put(Achado.FOTO, achado.getFoto());
        db.insert(Achado.TABELA, null, values);
    }

    public void alterar(Achado achado){
        ContentValues values = new ContentValues();
        values.put(Achado.DATA,achado.getData());
        values.put(Achado.DESCRICAO,achado.getDescricao());
        values.put(Achado.CATEGORIA,achado.getCategoria());
        values.put(Achado.LATITUDE,achado.getLatitude());
        values.put(Achado.LONGITUDE,achado.getLongitude());
        values.put(Achado.CONTATO,achado.getContato());
        values.put(Achado.FOTO,achado.getFoto());
        String id = String.valueOf(achado.getId());
        String[] whereArgs = new String[]{id};
        db.update(Achado.TABELA,values,Achado.ID +" = ?",whereArgs);
    }

    public Achado buscar(String id){

        String[] whereArgs = new String[]{id};

        Cursor c = db.query(Achado.TABELA,Achado.COLUNAS,Achado.ID
                + " = ?",whereArgs,null,null,null);

        if(c.moveToFirst()) {
            Achado achado = new Achado();

            achado.setId(c.getLong(c.getColumnIndex(Achado.ID)));
            achado.setDescricao(c.getString(c.getColumnIndex(Achado.DESCRICAO)));
            achado.setCategoria(c.getString(c.getColumnIndex(Achado.CATEGORIA)));
            achado.setFoto(c.getString(c.getColumnIndex(Achado.FOTO)));
            achado.setLatitude(c.getString(c.getColumnIndex(Achado.LATITUDE)));
            achado.setLongitude(c.getString(c.getColumnIndex(Achado.LONGITUDE)));
            return achado;
        }else {
            return null;
        }

    }

    public List<Achado> listar(String categoria, String descricao){

        String filtro = "";
        String and = "";

        if (categoria instanceof String && !categoria.equals("")) {
            filtro = filtro + and + Achado.CATEGORIA
                    + "like '"+categoria.trim() +"%' ";
            and = " and ";
        }
        if (descricao instanceof String && !descricao.equals("")) {
            filtro = filtro + and + Achado.DESCRICAO
                    + "like '"+descricao.trim() +"%' ";
            and = " and ";
        }

        Cursor c = db.query(Achado.TABELA,Achado.COLUNAS,filtro,null,null,null,null);

        List<Achado> achados = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Achado achado = new Achado();

                achado.setId(c.getLong(c.getColumnIndex(Achado.ID)));
                achado.setData(c.getString(c.getColumnIndex(Achado.DATA)));
                achado.setDescricao(c.getString(c.getColumnIndex(Achado.DESCRICAO)));
                achado.setCategoria(c.getString(c.getColumnIndex(Achado.CATEGORIA)));
                achado.setLatitude(c.getString(c.getColumnIndex(Achado.LATITUDE)));
                achado.setLongitude(c.getString(c.getColumnIndex(Achado.LONGITUDE)));
                achado.setContato(c.getString(c.getColumnIndex(Achado.CONTATO)));
                achado.setFoto(c.getString(c.getColumnIndex(Achado.FOTO)));
                Log.i("lista",achado.getDescricao());

                achados.add(achado);
            }while (c.moveToNext());
        }
        return achados;
    }

    public List<Achado> listar(){
        Cursor c = db.query(Achado.TABELA,Achado.COLUNAS,null,null,null,null,Achado.ID+" desc");

        List<Achado> achados = new ArrayList<Achado>();
        if(c.moveToFirst()){
            do{
                Achado achado = new Achado();

                achado.setId(c.getLong(c.getColumnIndex(Achado.ID)));
                achado.setData(c.getString(c.getColumnIndex(Achado.DATA)));
                achado.setDescricao(c.getString(c.getColumnIndex(Achado.DESCRICAO)));
                achado.setCategoria(c.getString(c.getColumnIndex(Achado.CATEGORIA)));
                achado.setLatitude(c.getString(c.getColumnIndex(Achado.LATITUDE)));
                achado.setLongitude(c.getString(c.getColumnIndex(Achado.LONGITUDE)));
                achado.setContato(c.getString(c.getColumnIndex(Achado.CONTATO)));
                achado.setFoto(c.getString(c.getColumnIndex(Achado.FOTO)));


                Log.i("lista",achado.getDescricao());

                achados.add(achado);
            }while (c.moveToNext());
        }
        return achados;
    }

    public void excluir(String id){
        String[] whereArgs = new String[]{id};
        db.delete(Achado.TABELA,Achado.ID + "= ?",whereArgs);
    }

}
