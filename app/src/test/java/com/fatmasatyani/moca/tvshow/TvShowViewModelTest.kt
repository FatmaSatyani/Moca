package com.fatmasatyani.moca.tvshow

import com.fatmasatyani.moca.R
import com.fatmasatyani.moca.data.DetailEntity
import com.fatmasatyani.moca.data.TvShowEntity
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private var viewModel: TvShowViewModel?= null
    private var data: TvShowEntity? = null

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
        data = TvShowEntity(
            "T1",
            "Tom & Jerry",
            "Tom and Jerry is an American animated media franchise and series of comedy short films created in 1940 by William Hanna and Joseph Barbera. Best known for its 161 theatrical short films by Metro-Goldwyn-Mayer, the series centers on the rivalry between the titular characters of a cat named Tom and a mouse named Jerry.",
            R.drawable.tv1_tom_and_jerry,
            "https://www.youtube.com/watch?v=ZcopvkSgBgc",
            listOf(
                DetailEntity(
                    "Directed by",
                    "William Hanna(1940-58), Joseph Barbera (1940-58), Gene Deitch (1961-62), Chuck Jones (1963 - 67), Maurice Noble (1964-67), Abe Levitow (1965-67), Tom Ray (1966-67), Ben Washam (1966-67)"
                ),
                DetailEntity(
                    "Produced by",
                    " Rudolf Ising (1940), Fred Quimby (1940–55), William Hanna (1955–58), Joseph Barbera (1955–58), William L. Snyder (1961–62), Chuck Jones (1963–67), Walter Bien (1963–65), Les Goldman (1963–67), Earl Jonas (1965–67)"
                ),
                DetailEntity(
                    "Running time",
                    "6-10 minutes"
                )
            )
        )
    }

    @Test
    fun result() {
        assertEquals(14, viewModel?.tvShow?.size)
        assertEquals(data?.tvShowId, viewModel?.getTvShow("T1")?.tvShowId)
        assertEquals(data?.tvShowTitle, viewModel?.getTvShow("T1")?.tvShowTitle)
        assertEquals(data?.tvShowDisplayPicture, viewModel?.getTvShow("T1")?.tvShowDisplayPicture)
        assertEquals(data?.tvShowDescription, viewModel?.getTvShow("T1")?.tvShowDescription)
        assertEquals(data?.tvShowTrailer, viewModel?.getTvShow("T1")?.tvShowTrailer)
        assertEquals(data?.detailEntity, viewModel?.getTvShow("T1")?.detailEntity)
    }
}