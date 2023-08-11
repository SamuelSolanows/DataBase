package com.example.database.DB.Controller

import android.content.ContentValues
import android.content.Context
import com.example.database.DB.CRUD
import com.example.database.DB.DBconexion
import com.example.database.DB.Models.Usuario

class UsuarioController(context: Context) : DBconexion(context), CRUD<Usuario> {
    companion object {
        val TABLA = "Usuario"
        val ID = "Id"
        val NOMBRE = "Nombre"
        val SEXO_ID = "Id_Sexo"
        var CREAR_TABLA =
            "CREATE TABLE $TABLA ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NOMBRE TEXT, $SEXO_ID INTEGER, FOREIGN KEY($SEXO_ID) REFERENCES ${SexoController.TABLA}(${SexoController.ID})  )"
    }

    override fun Insertar(Model: Usuario): Long {
        var valor = ContentValues().apply {
            put(NOMBRE, Model.Nombre)
        }
        return writableDatabase.insert(TABLA, null, valor)
    }

    override fun Eliminar(Model: Usuario): Long {
        var condicion = "$ID like ?"
        var argumeno = arrayOf(Model.Id.toString())
        return writableDatabase.delete(TABLA, condicion, argumeno).toLong()
    }

    override fun Actializar(Model: Usuario): Long {
        var valor = ContentValues().apply {
            put(NOMBRE, Model.Nombre)
        }
        var condicion = "$ID like ?"
        var argumeno = arrayOf(Model.Id.toString())
        return writableDatabase.update(TABLA, valor, condicion, argumeno).toLong()
    }

    override fun Leer(): MutableList<Usuario> {
        var usuario: MutableList<Usuario> = mutableListOf()
        var cursor =
            readableDatabase.query(TABLA, arrayOf(ID, NOMBRE), null, null, null, null, null)
        cursor!!.use {
            while (cursor.moveToNext()) {
                var id = cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                var nombre = cursor.getString(cursor.getColumnIndexOrThrow(NOMBRE))
                var id_sexo = cursor.getInt(cursor.getColumnIndexOrThrow(SEXO_ID))
                usuario.add(Usuario(id, nombre, id_sexo))
            }
        }
        return usuario
    }
}