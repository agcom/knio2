package io.github.agcom.knio2

import kotlinx.coroutines.suspendCancellableCoroutine
import java.net.SocketAddress
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousSocketChannel
import java.util.concurrent.TimeUnit

/**
 * Suspending version of [connect][AsynchronousSocketChannel.connect] function.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousSocketChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 * > The correct way to actually cancel the connection is to [close][AsynchronousSocketChannel.close] the channel.
 */
public suspend fun AsynchronousSocketChannel.connectAwait(remote: SocketAddress) {
    suspendCancellableCoroutine<Void?> {
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
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousSocketChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousSocketChannel.readAwait(vararg dsts: ByteBuffer): Long = suspendCancellableCoroutine {
    read(dsts, 0, dsts.size, -1, TimeUnit.MILLISECONDS, Unit, it.asCompletionHandler())
}

/**
 * Suspending version of [read][AsynchronousSocketChannel.write] function.
 *
 * Reads a sequence of bytes from this channel into the given buffers.
 *
 * * The offset and length parameters are always set to 0 and [srcs] size. You can achieve their application by [Array.sliceArray] function and a spread operator.
 *
 * The operation is not actually cancellable, because the underlying channel ([AsynchronousSocketChannel]) provides no guarantee for cancellation.
 * In case of cancellation, you may ignore the results.
 */
public suspend fun AsynchronousSocketChannel.writeAwait(vararg srcs: ByteBuffer): Long = suspendCancellableCoroutine {
    write(srcs, 0, srcs.size, -1, TimeUnit.MILLISECONDS, Unit, it.asCompletionHandler())
}