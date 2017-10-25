package dao;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import model.Curso;

public class CursoDAO {

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public CursoDAO(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        if (database == null){
            database = dataBaseHelper.getWritableDatabase();
        }
        return database;
    }

    private void fechar(){
        dataBaseHelper.close();
        database = null;
    }

    private Curso CriarCurso(Cursor cursor){
        Curso curso = new Curso(
            cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Cursos._ID)),
            cursor.getString(cursor.getColumnIndex(DataBaseHelper.Cursos.CURSO)),
            cursor.getString(cursor.getColumnIndex(DataBaseHelper.Cursos.DT_CRIACAO)),
            cursor.getString(cursor.getColumnIndex(DataBaseHelper.Cursos.DT_COMPLETADO))
            );
        return curso;
    }

}
