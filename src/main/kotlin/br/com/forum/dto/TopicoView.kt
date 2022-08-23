package br.com.forum.dto

import br.com.forum.models.StatusTopico
import org.springframework.cache.annotation.Cacheable
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

data class TopicoView(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime,
    val dataAlteracao: LocalDate?
): Serializable
