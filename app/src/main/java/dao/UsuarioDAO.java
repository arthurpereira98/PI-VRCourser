package dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public UsuarioDAO(Context context){
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

    private Usuario criarUsuario(Cursor cursor){
        Usuario user = new Usuario(
                cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Usuarios._ID)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Usuarios.NOME)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Usuarios.LOGIN)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Usuarios.SENHA))
        );
        return user;
    }

    public List<Usuario> ListarUsuarios(){
        Cursor cursor = getDatabase().query(DataBaseHelper.Usuarios.TABELA,
                DataBaseHelper.Usuarios.COLUNAS,null,null,null,null,null);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        while (cursor.moveToNext()){
            Usuario user = criarUsuario(cursor);
            usuarios.add(user);
        }
        cursor.close();
        return usuarios;
    }

    public long SalvarUsuario(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put(DataBaseHelper.Usuarios.NOME, usuario.getNome());
        valores.put(DataBaseHelper.Usuarios.LOGIN, usuario.getLogin());
        valores.put(DataBaseHelper.Usuarios.SENHA, usuario.getSenha());

        if (usuario.get_id() != null){
            return database.update(DataBaseHelper.Usuarios.TABELA, valores,
                    "_id = ?", new String[]{usuario.get_id().toString()});
        }
        return getDatabase().insert(DataBaseHelper.Usuarios.TABELA, null , valores);
    }

    public boolean removeUsuario(int id){
        return getDatabase().delete(DataBaseHelper.Usuarios.TABELA,
                "_id = ?", new String[]{Integer.toString(id)}) > 0 ;
    }

    public Usuario BuscarUsuarioPorId(int id){
        Cursor cursor = getDatabase().query(DataBaseHelper.Usuarios.TABELA,
                DataBaseHelper.Usuarios.COLUNAS, "_id = ?", new String[]{Integer.toString(id)},null,null,null);

        if(cursor.moveToNext()){
            Usuario user = criarUsuario(cursor);
            cursor.close();
            return user;
        }
        return null;
    }
}
