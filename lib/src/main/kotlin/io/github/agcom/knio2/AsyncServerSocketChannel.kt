package io.github.agcom.knio2

import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import kotlin.coroutines.suspendCoroutine

/**
 * Suspending version of [accept][AsynchronousServerSocketChannel.accept] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousServerSocketChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousServerSocketChannel.acceptAwait(): AsynchronousSocketChannel = suspendCoroutine {
    accept(Unit, it.asCompletionHandler())
}