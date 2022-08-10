package br.com.forum.repositories

import br.com.forum.dto.TopicoPorCategoriaDto
import br.com.forum.models.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>
    @Query(value = "SELECT new br.com.forum.dto.TopicoPorCategoriaDto(curso.categoria, COUNT(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>
}