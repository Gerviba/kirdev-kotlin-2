package hu.kirdev.ws2.workshop2.repo

import hu.kirdev.ws2.workshop2.model.MovieEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepo: CrudRepository<MovieEntity, Long?> {



}