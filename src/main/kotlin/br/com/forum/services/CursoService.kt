package br.com.forum.forum.services

import br.com.forum.forum.models.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        ).apply {
            cursos = listOf(this)
        }
    }

    fun listaPorId(id: Long): Curso {
        return cursos.stream().filter {
                curso -> curso.id == id
        }.findFirst().get()
    }


}
