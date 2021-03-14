package io.github.agcom.knio2

import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.channels.FileLock
import kotlin.coroutines.suspendCoroutine

/**
 * Suspending version of [lock][AsynchronousFileChannel.lock] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousFileChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousFileChannel.lockAwait(
    position: Long = 0,
    size: Long = Long.MAX_VALUE,
    shared: Boolean = false
): FileLock = suspendCoroutine {
    lock(position, size, shared, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [read][AsynchronousFileChannel.read] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousFileChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousFileChannel.readAwait(
    dst: ByteBuffer,
    position: Long
): Int = suspendCoroutine {
    read(dst, position, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [write][AsynchronousFileChannel.write] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousFileChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousFileChannel.writeAwait(
    src: ByteBuffer,
    position: Long
): Int = suspendCoroutine {
    write(src, position, Unit, it.asCompletionHandler())
}