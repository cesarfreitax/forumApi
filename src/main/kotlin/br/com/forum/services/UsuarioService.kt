package br.com.forum.services

import br.com.forum.models.Usuario
import br.com.forum.repositories.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {
    fun listaPorId(id: Long): Usuario {
        return repository.getOne(id)
    }
}
