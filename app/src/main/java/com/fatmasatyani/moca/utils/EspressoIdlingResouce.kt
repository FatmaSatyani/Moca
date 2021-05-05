package com.fatmasatyani.moca.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResouce {

    private const val RESOURCE = "GLOBAL"
    private val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }


    fun decrement() {
        idlingResource.decrement()
    }
}