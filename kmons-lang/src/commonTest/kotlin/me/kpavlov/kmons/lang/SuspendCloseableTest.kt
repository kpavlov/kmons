package me.kpavlov.kmons.lang

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

internal class SuspendCloseableTest {

    @Test
    fun `close invokes the implementation`() = runTest {
        var closeCalled = false
        val subject = object : SuspendCloseable {
            override suspend fun close() {
                closeCalled = true
            }
        }

        subject.close()

        closeCalled shouldBe true
    }

    @Test
    fun `close can be invoked multiple times`() = runTest {
        var closeCount = 0
        val subject = object : SuspendCloseable {
            override suspend fun close() {
                closeCount++
            }
        }

        subject.close()
        subject.close()

        closeCount shouldBe 2
    }

    @Test
    fun `close propagates exceptions`() = runTest {
        val subject = object : SuspendCloseable {
            override suspend fun close() {
                error("close failed")
            }
        }

        shouldThrow<IllegalStateException> {
            subject.close()
        }
    }
}
