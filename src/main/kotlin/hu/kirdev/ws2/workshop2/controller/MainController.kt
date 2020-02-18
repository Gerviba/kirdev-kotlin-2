package hu.kirdev.ws2.workshop2.controller

import hu.kirdev.ws2.workshop2.config.DEFAULT_IMAGE
import hu.kirdev.ws2.workshop2.model.MovieEntity
import hu.kirdev.ws2.workshop2.service.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Controller
class MainController {

    @Autowired
    lateinit var movies: MovieService

    @ResponseBody
    @GetMapping("/api/movies")
    fun allMovies(): List<MovieEntity> {
        return movies.getAllMovies()
    }

    @GetMapping("/")
    fun index() = "index"

    @GetMapping("/movies")
    fun movies(model: Model): String {
        model.addAttribute("time", Date().time)
        model.addAttribute("movies",
                movies.getMostPopularMovies()
                        .filter { it.posterUrl != DEFAULT_IMAGE }
                        .take(30))
        return "movies"
    }

}