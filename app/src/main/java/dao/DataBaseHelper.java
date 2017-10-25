package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String BANCO_DADOS = "tasks";
    private static final Integer VERSAO = 1;

    public DataBaseHelper(Context context){
        super(context,BANCO_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tabela de Usuarios
        db.execSQL("create table usuario(_id integer primary key autoincrement,"
        +"nome text not null, login text not null, senha text not null)");

        //Tabela de Cursos
        db.execSQL("create table cursos(_id integer primary key autoincrement,"
        +"curso text not null, dt_criacao datetime default current_datetime, dt_completado date)");

        db.execSQL("insert into usuario(nome,login,senha) values('Admin','admin','123456')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static class Usuarios{
        public static final String TABELA = "usuarios";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String LOGIN = "login";
        public static final String SENHA = "senha";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME,LOGIN,SENHA
        };
    }

    public static class Cursos{
        public static final String TABELA = "cursos";
        public static final String _ID = "_id";
        public static final String CURSO = "curso";
        public static final String DT_CRIACAO = "dt_criacao";
        public static final String DT_COMPLETADO = "dt_completado";

        public static final String[] COLUNAS = new String[]{
            _ID,CURSO,DT_CRIACAO,DT_COMPLETADO
        };

    }
}
