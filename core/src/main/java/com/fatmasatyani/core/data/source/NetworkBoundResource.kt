package com.fatmasatyani.core.data.source

import com.fatmasatyani.core.data.source.remote.response.ApiResponse
import com.fatmasatyani.core.utils.Resource
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType,RequestType> {

        private val result: Flow<Resource<ResultType>> = flow {
            emit(Resource.Loading())
            val dbSource = loadFromDB().first()

            if (shouldFetch(dbSource)) {
                emit(Resource.Loading())
                when (val apiResponse = createCall().first()) {
                    is ApiResponse.Success -> {
                        saveCallResult(apiResponse.data)
                        emitAll(loadFromDB().map { Resource.Success(it)})
                    }
                    is ApiResponse.Empty -> {
                        emitAll(loadFromDB().map { Resource.Success(it) })
                    }
                    is ApiResponse.Error -> {
                        onFetchFailed()
                        emit(Resource.Error<ResultType>(apiResponse.errorMessage))
                    }
                }
            } else {
                emitAll(loadFromDB().map { Resource.Success(it) })
            }
        }

        private fun onFetchFailed() {}

        protected abstract fun loadFromDB(): Flow<ResultType>

        protected abstract fun shouldFetch(data: ResultType?): Boolean

        protected abstract fun createCall(): Flow<ApiResponse<RequestType>>

        protected abstract fun saveCallResult(data: RequestType)

        fun asFlow() : Flow<Resource<ResultType>> = result

}


