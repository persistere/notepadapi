package br.com.persistere.notepadapi.controller

import br.com.persistere.notepadapi.model.Nota
import br.com.persistere.notepadapi.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController // Cria um serviço Rest
@CrossOrigin //O navegador tem que estar liberado
@RequestMapping(value = "/nota") //Informa por onde Começar

class NotaController {
    @Autowired
    lateinit var notaService: NotaService

    @GetMapping
    fun buscarTodos(): List<Nota>{
        return notaService.buscarTodas()
    }

    @GetMapping(value = "/titulo/{titulo}")
    fun buscar(@PathVariable(value = "titulo") titulo: String) : Nota {
        return notaService.buscar(titulo)
    }

    @PostMapping
    fun salvar(@RequestBody nota: Nota){
        notaService.salvar(nota)
    }
}
