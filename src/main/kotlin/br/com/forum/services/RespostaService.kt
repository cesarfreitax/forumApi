package br.com.forum.services

import br.com.forum.models.Resposta
import br.com.forum.repositories.RespostaRepository
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private val respostaRepository: RespostaRepository
) {

    fun salvar(resposta: Resposta) = respostaRepository.save(resposta)
}