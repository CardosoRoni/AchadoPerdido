package unoesc.edu.br.achadoperdido.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoDados {

	// Nome do banco
	private static final String NOME_BANCO = "achadoperdido";
	// Controle de versao
	private static final int VERSAO_BANCO = 10;
	// Script para fazer drop na tabela
	private static final String[] SCRIPT_DATABASE_DELETE
			= new String[] {"DROP TABLE IF EXISTS achado;"};

	
	// Cria a tabela com o "_id" sequencial
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
			"create table achado(_id integer primary key, achado_id text, " +
					"data text, descricao text, categoria text, " +
					"latitude text, longitude text, contato text, foto text);",

			"create table perdido(_id integer primary key, perdido_id text, " +
					"data text, descricao text, categoria text, " +
					"contato text);"

	};

	public static SQLiteDatabase db;

	public static SQLiteDatabase getDB(Context ctx) {
		if (db == null) {			
			SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
			db = dbHelper.getWritableDatabase();
		}
		return db;
		
	}
	
	

}
