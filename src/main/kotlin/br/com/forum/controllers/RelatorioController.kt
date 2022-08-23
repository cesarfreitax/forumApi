package br.com.forum.controllers

import br.com.forum.services.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("relatorios")
class RelatorioController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun relatorio() = topicoService.relatorio()
}