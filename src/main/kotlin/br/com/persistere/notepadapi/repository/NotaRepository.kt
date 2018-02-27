package br.com.persistere.notepadapi.repository

import br.com.persistere.notepadapi.model.Nota
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.stream.Stream

@Repository
interface NotaRepository : MongoRepository<Nota, String>{
    @Query("{}")
    fun all(): Stream<Nota>

    fun findByTitulo(titulo: String): Nota
}