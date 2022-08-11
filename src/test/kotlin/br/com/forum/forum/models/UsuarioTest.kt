package br.com.forum.forum.models

import br.com.forum.models.Usuario

object UsuarioTest {
    fun build() = Usuario(
        id = 1,
        nome = "Rafaella",
        email = "rafaella@email.com",
        senha = "123"
    )
}