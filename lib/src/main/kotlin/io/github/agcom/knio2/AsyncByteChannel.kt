package io.github.agcom.knio2

import java.nio.ByteBuffer
import java.nio.channels.AsynchronousByteChannel
import kotlin.coroutines.suspendCoroutine

/**
 * Suspending version of [read][AsynchronousByteChannel.read] function.
 *
 * Note that the operation is not cancellable (suspends until completes or fails) because the underlying channel ([AsynchronousByteChannel]) provides no guarantee for cancellation.
 * To mimic cancellation, you can ignore the caller coroutine (hence ignoring the results).
 */
public suspend fun AsynchronousByteChannel.readAwait(dst: ByteBuffer): Int = suspendCoroutine {
    read(dst, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [write][AsynchronousByteChannel.write] function.
 *
 * Note that the operation is not cancellable (suspends until completes or fails) because the underlying channel ([AsynchronousByteChannel]) provides no guarantee for cancellation.
 * To mimic cancellation, you can ignore the caller coroutine (hence ignoring the results).
 */
public suspend fun AsynchronousByteChannel.writeAwait(src: ByteBuffer): Int = suspendCoroutine {
    write(src, Unit, it.asCompletionHandler())
}