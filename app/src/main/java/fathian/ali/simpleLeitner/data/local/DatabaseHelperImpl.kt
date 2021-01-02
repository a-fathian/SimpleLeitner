package fathian.ali.simpleLeitner.data.local

import fathian.ali.simpleLeitner.data.local.entity.Task
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DatabaseHelperImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val ioDispatcher: CoroutineContext
) :
    DatabaseHelper {

    override suspend fun getTasks(): Flow<List<Task>> {
        return flow {
            emit(appDatabase.taskDao().getAll())
        }.flowOn(ioDispatcher)

    }

    override suspend fun insertAll(tasks: List<Task>) = appDatabase.taskDao().insertAll(tasks)

    override suspend fun insert(task: Task) {
        appDatabase.taskDao().insert(task)
    }

    override suspend fun delete(task: Task) {
        appDatabase.taskDao().delete(task)
    }

}