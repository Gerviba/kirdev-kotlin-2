package hu.kirdev.ws2.workshop2.service

import hu.kirdev.ws2.workshop2.model.MovieEntity
import hu.kirdev.ws2.workshop2.repo.MovieRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class MovieService {

    @Autowired
    lateinit var movies: MovieRepo

    fun addMovie(movie: MovieEntity): MovieEntity {
        println(movie)
        return movies.save(movie)
    }

    fun getAllMovies(): List<MovieEntity> {
        return movies.findAll().toList()
    }

}