package me.kpavlov.kmons.coroutines

import kotlinx.coroutines.CancellationException

/**
 * Runs [block] catching all exceptions except [CancellationException], which is rethrown.
 */
@Suppress("TooGenericExceptionCaught")
public inline fun <R> runCatchingCancellable(block: () -> R): Result<R> = try {
    Result.success(block())
} catch (e: CancellationException) {
    throw e
} catch (e: Throwable) {
    Result.failure(e)
}

