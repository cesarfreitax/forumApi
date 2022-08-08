package br.com.forum.forum.models

import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class Topico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val curso: Curso,
    @ManyToOne
    val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.naoResolvido,
    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
)