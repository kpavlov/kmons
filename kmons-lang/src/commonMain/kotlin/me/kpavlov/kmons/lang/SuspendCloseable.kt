package me.kpavlov.kmons.lang

/**
 * Suspending counterpart to [AutoCloseable] / [java.io.Closeable]. Implement this when releasing
 * a resource requires suspension (e.g. flushing to a remote, committing a git worktree, joining a
 * coroutine scope). For resources that can be released synchronously, prefer [AutoCloseable].
 */
public interface SuspendCloseable {
    public suspend fun close()
}
