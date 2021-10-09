package com.example.mvvmsampleapp.utils

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.*


// ResultType: Type for the DB data
// RequestType: Type for the API response
abstract class NetworkBoundResource<ResultType, RequestType> {

    companion object {
        const val DEFAULT_ERROR_MESSAGE = "Something went wrong!"
    }

    fun asFlow() = flow<Resource<ResultType>> {

        // Emit Database content first
        val data = fetchFromLocal().first()
        emit(Resource.loading(data))

        // Fetch latest items from remote
        val flow = if (shouldFetch(data)) {
            try {
                saveRemoteData(fetchFromRemote())
                fetchFromLocal().map { Resource.success(it) }
            } catch (throwable: Throwable) {
                fetchFromLocal().map {
                    Resource.error(
                        throwable.message ?: DEFAULT_ERROR_MESSAGE,
                        it
                    )
                }
            }
        } else {
            fetchFromLocal().map { Resource.success(it) }
        }
        emitAll(flow)
    }


    @WorkerThread
    protected abstract suspend fun saveRemoteData(response: RequestType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun fetchFromLocal(): Flow<ResultType>

    @MainThread
    protected abstract suspend fun fetchFromRemote(): RequestType
}