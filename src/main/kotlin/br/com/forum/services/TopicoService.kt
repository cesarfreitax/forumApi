package br.com.forum.services

import br.com.forum.dto.AtualizacaoTopicoForm
import br.com.forum.dto.NovoTopicoForm
import br.com.forum.dto.TopicoView
import br.com.forum.exceptions.NotFoundException
import br.com.forum.mapper.TopicoFormMapper
import br.com.forum.mapper.TopicoViewMapper
import br.com.forum.models.Topico
import br.com.forum.repositories.TopicoRepository
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado."
) {

    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun listaPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{ NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizaPorId(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{ NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletaPorId(id: Long) {
        repository.deleteById(id)
    }

//    fun deletaPorId(form: DeletaTopicoForm) {
//        val topico = topicos.stream().filter { topico ->
//            topico.id == form.id
//        }.findFirst().get()
//        topicos = topicos.minus(topico)
//    }

}