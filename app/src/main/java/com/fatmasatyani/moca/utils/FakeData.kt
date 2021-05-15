package com.fatmasatyani.moca.utils

import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import com.fatmasatyani.moca.vo.Resource

object FakeData {

    fun generateDummyMovie(): ArrayList<Movie> {
        val movie = arrayListOf<Movie>()
        for (n in 1..8) {
            movie.add(
                Movie(
                    n,
                    "$IMG_URL/7prYzufdIOy1KCTZKVWpjBFqqNr.jpg",
                    "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                    "2021-03-03",
                    8.2f,
                    107,
                    "Raya and the Last Dragon",
                    "$IMG_URL/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
                )
            )
        }
        return movie
    }

    fun generateDummyTvShow(): ArrayList<TvShow> {
        val tvShow = arrayListOf<TvShow>()
        for (n in 1..8) {
            tvShow.add(
                TvShow(
                    n,
                    "$IMG_URL/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                    "After a political protest turns violent, the team races to save two young gunshot victims.",
                    "2017-09-25",
                    8.6f,
                    "The Good Doctor",
                    "/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg"
                )
            )
        }
        return tvShow
    }
}

