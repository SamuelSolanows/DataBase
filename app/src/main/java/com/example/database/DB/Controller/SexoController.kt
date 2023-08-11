package com.example.database.DB.Controller

import android.content.ContentValues
import android.content.Context
import com.example.database.DB.CRUD
import com.example.database.DB.DBconexion
import com.example.database.DB.Models.Sexo

class SexoController(context: Context) : DBconexion(context), CRUD<Sexo> {
    companion object {
        val ID = "Id"
        val TABLA = "Sexo"
        val NOMBRE = "Nombre"
        val CREAR_TABBLA =
            "CREATE TABLE $TABLA ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NOMBRE TEXT)"
    }

    override fun Insertar(Model: Sexo): Long {
        var valor = ContentValues().apply {
            put(NOMBRE, Model.Nombre)
        }
        return writableDatabase.insert(TABLA, null, valor)
    }

    override fun Eliminar(Model: Sexo): Long {
        var condicion = "$ID like ?"
        var argumeno = arrayOf(Model.Id.toString())
        return writableDatabase.delete(TABLA, condicion, argumeno).toLong()
    }

    override fun Actializar(Model: Sexo): Long {
        var valor = ContentValues().apply {
            put(NOMBRE, Model.Nombre)
        }
        var condicion = "$ID like ?"
        var argumeno = arrayOf(Model.Id.toString())
        return writableDatabase.update(TABLA, valor, condicion, argumeno).toLong()
    }

    override fun Leer(): MutableList<Sexo> {
        var sexo: MutableList<Sexo> = mutableListOf()
        var cursor =
            readableDatabase.query(TABLA, arrayOf(ID, NOMBRE), null, null, null, null, null)
        cursor!!.use {
            while (cursor.moveToNext()) {
                var id = cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                var nombre = cursor.getString(cursor.getColumnIndexOrThrow(NOMBRE))
                sexo.add(Sexo(id, nombre))
            }
        }
        return sexo
    }
}