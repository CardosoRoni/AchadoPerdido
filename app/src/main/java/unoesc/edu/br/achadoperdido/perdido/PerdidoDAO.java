package unoesc.edu.br.achadoperdido.perdido;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import unoesc.edu.br.achadoperdido.achado.Achado;
import unoesc.edu.br.achadoperdido.sqlite.BancoDados;

/**
 * Created by Roni on 14/12/2016.
 */

public class PerdidoDAO {

    SQLiteDatabase db;

    public PerdidoDAO(Context context){db= BancoDados.getDB(context);}


    public void salvar(Perdido perdido){

  ContentValues values= new ContentValues();
        values.put(Perdido.DATA,perdido.getData());
        values.put(Perdido.DESCRICAO,perdido.getDescricao());
        values.put(Perdido.CATEGORIA,perdido.getCategoria());
        values.put(Perdido.CONTATO,perdido.getContato());
         db.insert(perdido.TABELA,null,values);
    }

  public void alterar(Perdido perdido){
ContentValues values = new ContentValues();
      values.put(Perdido.DATA,perdido.getData());
      values.put(Perdido.DESCRICAO,perdido.getDescricao());
      values.put(Perdido.CATEGORIA,perdido.getCategoria());
      values.put(Perdido.CONTATO,perdido.getContato());
      String id = String.valueOf(perdido.getId());
      String[] whereArgs = new String[]{id};

      db.update(Perdido.TABELA,values,Perdido.ID +" = ?",whereArgs);
}
    public Perdido buscar(String id) {

        String[] whereArgs = new String[]{id};

        Cursor c = db.query(Perdido.TABELA, Perdido.COLUNAS, Perdido.ID
                + " = ?", whereArgs, null, null, null);

        if (c.moveToFirst()) {
            Perdido perdido = new Perdido();
            perdido.setId(c.getLong(c.getColumnIndex(Perdido.ID)));
            perdido.setData(c.getString(c.getColumnIndex(Perdido.DATA)));
            perdido.setDescricao(c.getString(c.getColumnIndex(Perdido.DESCRICAO)));
            perdido.setCategoria(c.getString(c.getColumnIndex(Perdido.CATEGORIA)));
            perdido.setContato(c.getString(c.getColumnIndex(Perdido.CONTATO)));

            return perdido;
        } else {
            return null;
        }
    }

    public List<Perdido> listar(){
        Cursor c = db.query(Perdido.TABELA,Perdido.COLUNAS,null,null,null,null,Perdido.ID+" desc");

        List<Perdido> perdidos = new ArrayList<Perdido>();
        if(c.moveToFirst()){
            do{
               Perdido perdido = new Perdido();

                perdido.setId(c.getLong(c.getColumnIndex(Perdido.ID)));
               perdido.setData(c.getString(c.getColumnIndex(Perdido.DATA)));
            perdido.setDescricao(c.getString(c.getColumnIndex(Perdido.DESCRICAO)));
             perdido.setCategoria(c.getString(c.getColumnIndex(Perdido.CATEGORIA)));
             perdido.setContato(c.getString(c.getColumnIndex(Perdido.CONTATO)));
          //perdido.setFoto(c.getString(c.getColumnIndex(Perdido.FOTO)));


                Log.i("lista",perdido.getDescricao());

               perdidos.add(perdido);
            }while (c.moveToNext());
        }
        return perdidos;
    }


    public List<Perdido> listarPerdidos(String categoria, String descricao){

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
            Cursor c = db.query(Perdido.TABELA,Perdido.COLUNAS,null,null,null,null,null);

            List<Perdido> perdidos = new ArrayList<Perdido>();
                if(c.moveToFirst()){
                do{
                    Perdido perdido = new Perdido();
                    perdido.setId(c.getLong(c.getColumnIndex(Perdido.ID)));
                    perdido.setData(c.getString(c.getColumnIndex(Perdido.DATA)));
                    perdido.setDescricao(c.getString(c.getColumnIndex(Perdido.DESCRICAO)));
                    perdido.setCategoria(c.getString(c.getColumnIndex(Perdido.CATEGORIA)));
                    perdido.setContato(c.getString(c.getColumnIndex(Perdido.CONTATO)));

                    Log.i("lista",perdido.getDescricao());

                    perdidos.add(perdido);
                }while (c.moveToNext());
            }
            return perdidos;
        }

    public void excluir(String id) {
        String[] whereArgs = new String[]{id};
        db.delete(Perdido.TABELA, Perdido.ID + "= ?", whereArgs);

    }
}


