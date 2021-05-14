package com.fatmasatyani.moca.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.fatmasatyani.moca.data.MovieDetailResponse
import com.fatmasatyani.moca.utils.AppExecutors
import com.fatmasatyani.moca.vo.Resource
import com.fatmasatyani.moca.vo.Status

abstract class NetworkBoundResource<ResultType,RequestType> (private val mExecutors: AppExecutors) {

        private val result = MediatorLiveData<Resource<ResultType>>()

        init {
            result.value = Resource.empty(null)

            @Suppress("LeakingThis")
            val dbSource = loadFromDB()

            result.addSource(dbSource) { data ->
                result.removeSource(dbSource)
                if (shouldFetch(data)) {
                    fetchFromNetwork(dbSource)
                } else {
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.success(newData)
                    }
                }
            }
        }

        private fun onFetchFailed() {}

        protected abstract fun loadFromDB(): LiveData<ResultType>

        protected abstract fun shouldFetch(data: ResultType?): Boolean

        protected abstract fun createCall(): LiveData<List<MovieDetailResponse>>

        protected abstract fun saveCallResult(data: RequestType)

        private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {

            val apiResponse = createCall()

            result.addSource(dbSource) { newData ->
                result.value = Resource.empty(newData)
            }

            result.addSource(apiResponse) { response ->
                result.removeSource(apiResponse)
                result.removeSource(dbSource)
                when (response.status) {
                    Status.SUCCESS ->
                        mExecutors.diskIO().execute {
                            saveCallResult(response.body)
                            mExecutors.mainThread().execute {
                                result.addSource(loadFromDB()) { newData ->
                                    result.value = Resource.success(newData)
                                }
                            }
                        }
                    Status.EMPTY ->
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = Resource.success(newData)
                            }
                        }
                    Status.ERROR -> {
                        onFetchFailed()
                        result.addSource(dbSource) { newData ->
                            result.value = Resource.error(response.message, newData)
                        }
                    }
                }
            }
        }
    fun asLiveData() : LiveData<Resource<ResultType>> = result
    }


