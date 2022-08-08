package br.com.forum.forum.models

data class Usuario(
    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String
)
