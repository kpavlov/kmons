package me.kpavlov.kmons.coroutines

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.CancellationException
import kotlin.test.Test

internal class RunCatchingCancellableTest {

    @Test
    fun `returns success when block completes normally`() {
        val result = runCatchingCancellable { 42 }

        result shouldBeSuccess 42
    }

    @Test
    fun `returns success for unit block`() {
        val result = runCatchingCancellable { }

        result.shouldBeSuccess()
    }

    @Test
    fun `wraps exception in failure`() {
        val cause = IllegalStateException("test error")

        val result = runCatchingCancellable<Unit> { throw cause }

        result shouldBeFailure cause
    }

    @Test
    fun `wraps UnsupportedOperationException in failure`() {
        val result = runCatchingCancellable<Unit> { throw UnsupportedOperationException("unsupported") }

        result.shouldBeFailure().shouldBeInstanceOf<UnsupportedOperationException>()
    }

    @Test
    fun `wraps Error in failure`() {
        val result = runCatchingCancellable<Unit> { throw AssertionError("assertion") }

        result.shouldBeFailure().shouldBeInstanceOf<AssertionError>()
    }

    @Test
    fun `rethrows CancellationException`() {
        shouldThrow<CancellationException> {
            runCatchingCancellable<Unit> { throw CancellationException("cancelled") }
        }
    }

    @Test
    fun `preserves the exception instance in failure`() {
        val original = IllegalArgumentException("original")

        val result = runCatchingCancellable<Unit> { throw original }

        val exception = result.shouldBeFailure()
        exception.shouldBeInstanceOf<IllegalArgumentException>()
        exception.message shouldBe "original"
    }
}
