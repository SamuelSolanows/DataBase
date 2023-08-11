package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.database.DB.Controller.SexoController
import com.example.database.DB.Models.Sexo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //AgregarSexo()
        MostrarSexo()
    }

    fun AgregarSexo() {
        SexoController(this@MainActivity).Insertar(Sexo(0, "Masculino"))
    }

    fun MostrarSexo() {
        SexoController(this@MainActivity).Leer().forEach {
            Toast.makeText(this@MainActivity, it.Nombre, Toast.LENGTH_SHORT).show()
        }
    }
}