package hu.kirdev.ws2.workshop2.config

import hu.kirdev.ws2.workshop2.model.MovieEntity
import org.springframework.context.annotation.Configuration
import java.io.File
import java.nio.file.Files
import javax.annotation.PostConstruct

const val URL_BASE = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"
const val DEFAULT_IMAGE = "https://www.listchallenges.com/f/lists/63879069-2c06-4430-9345-4325152efd73.jpg"

@Configuration
class TestingConfig {

    @PostConstruct
    fun init() {
        Files.readAllLines(File("data/movies_metadata_all.csv").toPath())
                .asSequence()
                .drop(1)
                .map { it.split(",") }
                .filter { it.size == 24 }
                .map { ignoreErrors(it) { data -> MovieEntity(
                        id = null,
                        adult = data[0] == "True",
                        title = data[8],
                        tagline = data[19],
                        popularity = data[10].toDouble(),
                        revenue = data[15].toInt(),
                        description = data[9],
                        posterUrl = if (data[11].isEmpty()) DEFAULT_IMAGE else "${URL_BASE}${data[11]}",
                        runtime = if (data[16].isEmpty()) 0 else data[16].toDouble().toInt()

                )}}
                .filter { it != null }
                .forEach { println(it) }
    }

    private fun ignoreErrors(data: List<String>, fx: Function1<List<String>, MovieEntity?>): MovieEntity? {
        try {
            return fx.invoke(data)
        } catch (e: Exception) {}
        return null
    }


}