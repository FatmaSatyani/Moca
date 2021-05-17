package com.fatmasatyani.moca.source.remote.response

import com.fatmasatyani.moca.vo.Status

class ApiResponse <T> (val status: Status, val body: T, val message: String?) {
    companion object {
        fun <T> success (body: T): ApiResponse <T> = ApiResponse(Status.SUCCESS, body, null)
    }
}