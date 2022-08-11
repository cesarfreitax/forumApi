package br.com.forum.forum.models

import br.com.forum.dto.TopicoView
import br.com.forum.models.StatusTopico
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoViewTest {
    fun build() = TopicoView(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo Kotlin Basico",
        status = StatusTopico.naoResolvido,
        dataCriacao = LocalDateTime.now(),
        dataAlteracao = LocalDate.now()
    )
}