@file:Suppress("UNREACHABLE_CODE", "IMPLICIT_NOTHING_TYPE_ARGUMENT_IN_RETURN_POSITION", "UNUSED_VARIABLE")

package io.github.agcom.knio2.examples

import io.github.agcom.knio2.*
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousSocketChannel

suspend fun main() {
    val socket: AsynchronousSocketChannel = TODO().apply {
        connectAwait(TODO()) // connectAwait
    }

    ByteBuffer.allocate(TODO()).let {
        socket.readAwait(it) // readAwait
    }

    socket.writeAwait(Charsets.US_ASCII.encode("Hello world")) // writeAwait
}