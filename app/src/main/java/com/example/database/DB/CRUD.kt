package com.example.database.DB

interface CRUD<E> {
    fun Insertar(Model: E): Long
    fun Eliminar(Model: E): Long
    fun Actializar(Model: E): Long
    fun Leer(): MutableList<E>


}