# KNIO2
Just some [Kotlinx coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html) extensions for `java.nio.channels.Asynchronous*` classes.

## Components

- Suspending extension functions for following classes,
  - `AsynchronousByteChannel`
  - `AsynchronousSocketChannel`

  The functions are named after their original name plus `await` suffix.

  ```kotlin
  import io.github.agcom.knio2.*
  import kotlinx.coroutines.runBlocking
  import java.nio.ByteBuffer
  import java.nio.channels.AsynchronousSocketChannel
  
  fun main() = runBlocking<Unit> {
      val socket: AsynchronousSocketChannel = TODO().apply {
          connectAwait(TODO()) // connectAwait
      }
  
      ByteBuffer.allocate(TODO()).let {
          socket.readAwait(it) // readAwait
      }
  
      socket.writeAwait(Charsets.US_ASCII.encode("Hello world")) // writeAwait
  }
  ```

## Contribution

I add what I need. Make sure you do it too :smiley:.

## Status

If you only want Kotlinx coroutines IO, prefer its native libraries instead of Java ports. You can find them on [Awesome Kotlin](https://kotlin.link/).

This is a temporary project and may deprecate in favor of better asynchronous IO solutions with Kotlinx coroutines. For example, the [Kotlinx IO](https://github.com/Kotlin/kotlinx-io), which is kinda in development now.