package io.github.agcom.knio2

import kotlinx.coroutines.suspendCancellableCoroutine
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.channels.FileLock

/**
 * Suspending version of [lock][AsynchronousFileChannel.lock] function.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousFileChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousFileChannel.lockAwait(
    position: Long = 0,
    size: Long = Long.MAX_VALUE,
    shared: Boolean = false
): FileLock = suspendCancellableCoroutine {
    lock(position, size, shared, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [lock][AsynchronousFileChannel.read] function.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousFileChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousFileChannel.readAwait(
    dst: ByteBuffer,
    position: Long
): Int = suspendCancellableCoroutine {
    read(dst, position, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [lock][AsynchronousFileChannel.write] function.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousFileChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousFileChannel.writeAwait(
    src: ByteBuffer,
    position: Long
): Int = suspendCancellableCoroutine {
    write(src, position, Unit, it.asCompletionHandler())
}