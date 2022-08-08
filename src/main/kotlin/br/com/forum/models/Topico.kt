package br.com.forum.forum.models

import java.time.LocalDateTime

data class Topico(
    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.naoResolvido,
    val respostas: List<Resposta> = ArrayList()
)