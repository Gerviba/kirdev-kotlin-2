package hu.kirdev.ws2.workshop2.model

import javax.persistence.*

@Entity
@Table(name = "movie")
data class MovieEntity(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column
    val adult: Boolean,

    @Column
    val title: String,

    @Lob
    @Column
    val description: String,

    @Column
    val popularity: Double,

    @Column
    val posterUrl: String,

    @Column
    val runtime: Int,

    @Column
    val revenue: Int,

    @Column
    val tagline: String
)