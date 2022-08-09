package br.com.forum.services

import br.com.forum.models.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Rafaella",
            email = "rafarizo@email.com",
            senha = "123"
        ).apply {
            usuarios = listOf(this)
        }
    }

    fun listaPorId(id: Long): Usuario {
        return usuarios.stream().filter { usuario ->
            usuario.id == id
        }.findFirst().get()
    }
}
