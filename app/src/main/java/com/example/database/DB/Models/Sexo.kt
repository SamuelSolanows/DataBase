package com.example.database.DB.Models

data class Sexo(var Id: Int, var Nombre: String) {
    override fun toString(): String {
        return Nombre
    }
}