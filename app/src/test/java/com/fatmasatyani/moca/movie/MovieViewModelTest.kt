package com.fatmasatyani.moca.movie

import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.DetailEntity
import com.fatmasatyani.moca.data.MovieEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private var viewModel: MovieViewModel? = null
    private var data: MovieEntity?= null

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
        data = MovieEntity(
            "M1",
            "Raya and the Last Dragon",
            "Raya and the Last Dragon is a movie starring Kelly Marie Tran, Awkwafina, and Gemma Chan. In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last.",
            R.drawable.mv1_raya_and_the_last_dragon,
            "https://www.youtube.com/watch?v=1VIZ89FEjYI",
            listOf(
                DetailEntity(
                    "Directed by",
                    "Don Hall, Carlos López Estrada"
                ),
                DetailEntity(
                    "Produced by",
                    "Osnat Shurer, Peter Del Vecho"
                ),
                DetailEntity(
                    "Music by",
                    "James Newton Howard"
                ),
                DetailEntity(
                    "Cinematography",
                    "Rob Dressel, Adolp Lusinsky"
                ),
                DetailEntity(
                    "Edited by",
                    "Fabienne Rawley, Shannon Stein"
                )
            )
        )
    }

    @Test
    fun result() {
        assertEquals(14, viewModel?.movies?.size)
        assertEquals(data?.movieId, viewModel?.getMovies("M1")?.movieId)
        assertEquals(data?.movieTitle, viewModel?.getMovies("M1")?.movieTitle)
        assertEquals(data?.movieDisplayPicture, viewModel?.getMovies("M1")?.movieDisplayPicture)
        assertEquals(data?.movieDescription, viewModel?.getMovies("M1")?.movieDescription)
        assertEquals(data?.movieTrailer, viewModel?.getMovies("M1")?.movieTrailer)
        assertEquals(data?.detailEntity, viewModel?.getMovies("M1")?.detailEntity)
    }
}