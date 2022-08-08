package br.com.forum.forum.services

import br.com.forum.forum.dto.AtualizacaoTopicoForm
import br.com.forum.forum.dto.DeletaTopicoForm
import br.com.forum.forum.dto.NovoTopicoForm
import br.com.forum.forum.dto.TopicoView
import br.com.forum.forum.exceptions.NotFoundException
import br.com.forum.forum.mapper.TopicoFormMapper
import br.com.forum.forum.mapper.TopicoViewMapper
import br.com.forum.forum.models.Topico
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado."
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun listaPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizaPorId(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { topico ->
            topico.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletaPorId(id: Long) {
        val topico = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(topico)
    }

//    fun deletaPorId(form: DeletaTopicoForm) {
//        val topico = topicos.stream().filter { topico ->
//            topico.id == form.id
//        }.findFirst().get()
//        topicos = topicos.minus(topico)
//    }

}