package br.com.forum.controllers

import br.com.forum.models.Resposta
import br.com.forum.services.RespostaService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearerAuth")
class RespostaController(
    private val respostaService: RespostaService
) {

    @PostMapping
    fun salvar(@RequestBody @Valid resposta: Resposta) = respostaService.salvar(resposta)
}