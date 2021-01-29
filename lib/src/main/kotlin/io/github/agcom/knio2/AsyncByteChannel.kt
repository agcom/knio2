package io.github.agcom.knio2

import kotlinx.coroutines.suspendCancellableCoroutine
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousByteChannel

/**
 * Suspending version of [read][AsynchronousByteChannel.read] function.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousByteChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousByteChannel.readAwait(dst: ByteBuffer): Int = suspendCancellableCoroutine {
    read(dst, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [write][AsynchronousByteChannel.write] function.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousByteChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousByteChannel.writeAwait(src: ByteBuffer): Int = suspendCancellableCoroutine {
    write(src, Unit, it.asCompletionHandler())
}