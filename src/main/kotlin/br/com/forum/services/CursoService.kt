package br.com.forum.services

import br.com.forum.models.Curso
import br.com.forum.repositories.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {
    fun listaPorId(id: Long): Curso {
        return repository.getOne(id)
    }


}
