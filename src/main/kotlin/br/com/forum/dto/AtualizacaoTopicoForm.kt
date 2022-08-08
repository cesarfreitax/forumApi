package br.com.forum.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field:NotNull val id: Long,
    @field:NotEmpty @field:Size(min = 5, max = 50) val titulo: String,
    @field:NotEmpty val mensagem: String
)
