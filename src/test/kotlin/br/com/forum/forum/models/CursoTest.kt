package br.com.forum.forum.models

import br.com.forum.models.Curso

object CursoTest {
    fun build() = Curso(
        id = 1,
        nome = "Kotlin Basico",
        categoria = "Programacao"
    )
}