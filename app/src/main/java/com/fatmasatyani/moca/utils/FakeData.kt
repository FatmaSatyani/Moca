package com.fatmasatyani.moca.utils

import com.fatmasatyani.moca.data.FavoriteMovieData
import com.fatmasatyani.moca.data.FavoriteTvShowData
import com.fatmasatyani.moca.data.Movie
import com.fatmasatyani.moca.data.TvShow
import com.fatmasatyani.moca.databinding.FavoriteItemLayoutBinding
import com.fatmasatyani.moca.utils.Constant.Companion.IMG_URL
import java.util.*
import kotlin.collections.ArrayList

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

    fun getSingleDummyMovie(): Movie {
        return Movie(
                1,
            "$IMG_URL/n2y7T8wJVjJ8yLhQXQgNCpsC3ga.jpg",
        "Set before the events of ‘Soul’, 22 refuses to go to Earth, enlisting a gang of 5 new souls in attempt of rebellion. However, 22’s subversive plot leads to a surprising revelation about the meaning of life.",
            "2021-04-30",
            7.3f,
            9,
            "22 vs. Earth",
            "$IMG_URL/32vLDKSzcCMh55zqqaSqqUA8naz.jpg"
                )
    }

    fun getFavoriteDummyMovie(): List<FavoriteMovieData> {
        val favorite = arrayListOf<FavoriteMovieData>()
        for (n in 1..8) {
            favorite.add(
                FavoriteMovieData(
                    n,
                    n,
                    "$IMG_URL/n2y7T8wJVjJ8yLhQXQgNCpsC3ga.jpg",
                    "Set before the events of ‘Soul’, 22 refuses to go to Earth, enlisting a gang of 5 new souls in attempt of rebellion. However, 22’s subversive plot leads to a surprising revelation about the meaning of life.",
                    "2021-04-30",
                    7.3f,
                    9,
                    "22 vs. Earth",
                    "$IMG_URL/32vLDKSzcCMh55zqqaSqqUA8naz.jpg"
                        )
            )
        }
        return favorite
    }

    fun getSingleFavoriteMovie(): FavoriteMovieData {
        return FavoriteMovieData(
            1,
            1,
            "$IMG_URL/n2y7T8wJVjJ8yLhQXQgNCpsC3ga.jpg",
            "Set before the events of ‘Soul’, 22 refuses to go to Earth, enlisting a gang of 5 new souls in attempt of rebellion. However, 22’s subversive plot leads to a surprising revelation about the meaning of life.",
            "2021-04-30",
            7.3f,
            9,
            "22 vs. Earth",
            "$IMG_URL/32vLDKSzcCMh55zqqaSqqUA8naz.jpg"
        )
    }

    //TV SHOW

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

    fun getSingleDummyTvShow(): TvShow{
        return TvShow(
            1,
            "$IMG_URL/zlXPNnnUlyg6KyvvjGd2ZxG6Tnw.jpg",
            "Shaun struggles with his role as Lea's partner after complications arise with the pregnancy and his instincts as a medical professional kick in. Meanwhile, Dr. Park, Dr. Andrews and Asher disagree on how to address an elderly patient's wishes.",
            "2017-09-25",
            8.6f,
            "The Good Doctor",
            "$IMG_URL/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        )
    }

    fun getFavoriteDummyTvShow(): List<FavoriteTvShowData> {
        val favorite = arrayListOf<FavoriteTvShowData>()
        for (n in 1..8) {
            favorite.add(
                FavoriteTvShowData(
                    n,
                    n,
                    "$IMG_URL/zlXPNnnUlyg6KyvvjGd2ZxG6Tnw.jpg",
                    "Shaun struggles with his role as Lea's partner after complications arise with the pregnancy and his instincts as a medical professional kick in. Meanwhile, Dr. Park, Dr. Andrews and Asher disagree on how to address an elderly patient's wishes.",
                    "2017-09-25",
                    8.6f,
                    "The Good Doctor",
                    "$IMG_URL/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
                )
            )
        }
        return favorite
    }

    fun getSingleFavoriteTvShow() : FavoriteTvShowData {
        return FavoriteTvShowData(
            1,
            1,
            "$IMG_URL/zlXPNnnUlyg6KyvvjGd2ZxG6Tnw.jpg",
            "Shaun struggles with his role as Lea's partner after complications arise with the pregnancy and his instincts as a medical professional kick in. Meanwhile, Dr. Park, Dr. Andrews and Asher disagree on how to address an elderly patient's wishes.",
            "2017-09-25",
            8.6f,
            "The Good Doctor",
            "$IMG_URL/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        )
    }
}

