package br.com.forum.repositories

import br.com.forum.models.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}