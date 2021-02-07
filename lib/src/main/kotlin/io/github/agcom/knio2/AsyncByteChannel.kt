package io.github.agcom.knio2

import java.nio.ByteBuffer
import java.nio.channels.AsynchronousByteChannel
import kotlin.coroutines.suspendCoroutine

/**
 * Suspending version of [read][AsynchronousByteChannel.read] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousByteChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousByteChannel.readAwait(dst: ByteBuffer): Int = suspendCoroutine {
    read(dst, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [write][AsynchronousByteChannel.write] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousByteChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousByteChannel.writeAwait(src: ByteBuffer): Int = suspendCoroutine {
    write(src, Unit, it.asCompletionHandler())
}