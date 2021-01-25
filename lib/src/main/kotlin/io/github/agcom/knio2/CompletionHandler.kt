package io.github.agcom.knio2

import java.nio.channels.CompletionHandler
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Coroutine [Continuation] as callback [CompletionHandler].
 *
 * Note that the attachment parameter to [completed][CompletionHandler.completed] and [failed][CompletionHandler.failed] functions are ignored.
 * You can achieve their application (identifying callback) by using coroutine local variables.
 *
 */
public fun <V> Continuation<V>.asCompletionHandler(): CompletionHandler<V, Unit> = object : CompletionHandler<V, Unit> {
    override fun completed(result: V, attachment: Unit) {
        resume(result)
    }

    override fun failed(exc: Throwable, attachment: Unit) {
        resumeWithException(exc)
    }
}