package br.com.forum.forum.services

import br.com.forum.exceptions.NotFoundException
import br.com.forum.forum.models.TopicoTest
import br.com.forum.forum.models.TopicoViewTest
import br.com.forum.mapper.TopicoFormMapper
import br.com.forum.mapper.TopicoViewMapper
import br.com.forum.models.Topico
import br.com.forum.repositories.TopicoRepository
import br.com.forum.services.TopicoService
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicoServiceTest {
    private val topico = TopicoTest.build()
    private val topicoView = TopicoViewTest.build()

    private val pages = PageImpl(listOf(topico))

    private val pageable: Pageable = mockk()
    private val topicoViewMapper: TopicoViewMapper = mockk()
    private val topicoFormMapper: TopicoFormMapper = mockk()


    private val topicoRepository: TopicoRepository = mockk{
        every { findAll(pageable) } returns pages
        every { findByCursoNome(any(), any()) } returns pages
    }

    private val topicoService = TopicoService(
        repository = topicoRepository,
        topicoViewMapper = topicoViewMapper,
        topicoFormMapper = topicoFormMapper,
        notFoundMessage = "Topico nao encontrado!"
    )

    @Test
    fun `deve listar topicos a partir do nome do curso`(){
        val slot = slot<Topico>()
        every { topicoViewMapper.map(capture(slot)) } returns topicoView

        topicoService.listar("Kotlin Basico", pageable)

        verify(exactly = 0) { topicoRepository.findAll(pageable) }
        verify(exactly = 1) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }

        assertThat(slot.captured.titulo).isEqualTo(topico.titulo)
        assertThat(slot.captured.mensagem).isEqualTo(topico.mensagem)
        assertThat(slot.captured.status).isEqualTo(topico.status)
    }

    @Test
    fun `deve listar todos os topicos quando nome do curso for nulo`() {
        val slot = slot<Topico>()
        every { topicoViewMapper.map(capture(slot)) } returns topicoView

        topicoService.listar(null, pageable)

        verify(exactly = 1) { topicoRepository.findAll(pageable) }
        verify(exactly = 0) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }

        assertThat(slot.captured.titulo).isEqualTo(topico.titulo)
        assertThat(slot.captured.mensagem).isEqualTo(topico.mensagem)
        assertThat(slot.captured.status).isEqualTo(topico.status)
    }

    @Test
    fun `deve lancar excecao se nao achar topico por id`() {
        every { topicoRepository.findById(any()) } returns Optional.empty()

        val actual = assertThrows<NotFoundException> {
            topicoService.listaPorId(2)
        }

        assertThat(actual.message).isEqualTo("Topico nao encontrado!")
    }


}