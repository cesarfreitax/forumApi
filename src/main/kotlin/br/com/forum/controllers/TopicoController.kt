package br.com.forum.controllers

import br.com.forum.dto.AtualizacaoTopicoForm
import br.com.forum.dto.NovoTopicoForm
import br.com.forum.dto.TopicoView
import br.com.forum.services.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun listaPorId(@PathVariable id: Long): TopicoView {
        return service.listaPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid form: NovoTopicoForm, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    fun atualizaPorId(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topicoView = service.atualizaPorId(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletaPorId(@PathVariable id: Long) {
        return service.deletaPorId(id)
    }

//    @DeleteMapping
//    fun deletaPorId(@RequestBody form: DeletaTopicoForm){
//        return service.deletaPorId(form)
//    }
}