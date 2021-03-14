package io.github.agcom.knio2

import java.net.SocketAddress
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousSocketChannel
import java.util.concurrent.TimeUnit
import kotlin.coroutines.suspendCoroutine

/**
 * Suspending version of [connect][AsynchronousSocketChannel.connect] function.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousSocketChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousSocketChannel.connectAwait(remote: SocketAddress) {
    suspendCoroutine<Void?> {
        connect(remote, Unit, it.asCompletionHandler())
    }
}

/**
 * Suspending version of [read][AsynchronousSocketChannel.read] function.
 *
 * Reads a sequence of bytes from this channel into the given buffers.
 *
 * The offset and length parameters are always set to 0 and [dsts] size. You can achieve their application by [Array.sliceArray] function and a spread operator.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousSocketChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousSocketChannel.readAwait(vararg dsts: ByteBuffer): Long = suspendCoroutine {
    read(dsts, 0, dsts.size, -1, TimeUnit.MILLISECONDS, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [write][AsynchronousSocketChannel.write] function.
 *
 * Reads a sequence of bytes from this channel into the given buffers.
 *
 * * The offset and length parameters are always set to 0 and [srcs] size. You can achieve their application by [Array.sliceArray] function and a spread operator.
 *
 * The call is not cancellable (suspends until success or failure), because the underlying channel ([AsynchronousSocketChannel]) provides no guarantee for cancellation.
 * Note that closing the channel (probably) continues every call with a failure (and that covers most use cases).
 *
 * However, you can mimic cancellation by ignoring the call (hence, ignoring the results).
 */
public suspend fun AsynchronousSocketChannel.writeAwait(vararg srcs: ByteBuffer): Long = suspendCoroutine {
    write(srcs, 0, srcs.size, -1, TimeUnit.MILLISECONDS, Unit, it.asCompletionHandler())
}