package com.fatmasatyani.moca.utils

import com.fatmasatyani.moca.source.remote.response.MovieResponse
import com.fatmasatyani.moca.source.remote.response.TvResponse
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

object DataDummy {

    private var gson = Gson()

    fun generateDummyMovie() = gson.fromJson(loadJSON("movie.json"), MovieResponse::class.java).result

    fun generateDummyTvShow() = gson.fromJson(loadJSON("tv.json"),TvResponse::class.java).result

    private fun loadJSON(source: String): String? {
        var json: String? = null

        try {
            val input: InputStream = this.javaClass.classLoader!!.getResourceAsStream(source)
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }
}