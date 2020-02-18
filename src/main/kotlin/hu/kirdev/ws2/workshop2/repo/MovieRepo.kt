package hu.kirdev.ws2.workshop2.repo

import hu.kirdev.ws2.workshop2.model.MovieEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MovieRepo: CrudRepository<MovieEntity, Long?> {

    fun getAllByAdultFalseOrderByPopularityDesc(): List<MovieEntity>

    fun getByTitle(title: String): Optional<MovieEntity>

}