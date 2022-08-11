package br.com.forum.forum.models

import br.com.forum.models.Topico

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo Kotlin Basico",
        curso = CursoTest.build(),
        autor = UsuarioTest.build()
    )
}