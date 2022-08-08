package br.com.forum.forum.mapper

import br.com.forum.forum.dto.NovoTopicoForm
import br.com.forum.forum.models.Topico
import br.com.forum.forum.services.CursoService
import br.com.forum.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {


    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.listaPorId(t.idCurso),
            autor = usuarioService.listaPorId(t.idAutor)
        )
    }

}
