package com.example.database.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.database.DB.Controller.SexoController
import com.example.database.DB.Controller.UsuarioController

open class DBconexion(context: Context) : SQLiteOpenHelper(context, "db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(SexoController.CREAR_TABBLA)
        p0!!.execSQL(UsuarioController.CREAR_TABLA)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}