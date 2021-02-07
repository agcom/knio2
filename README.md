# KNIO2

[![Download](https://api.bintray.com/packages/agcom/knio2/lib/images/download.svg)](https://bintray.com/agcom/knio2/lib/_latestVersion)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)

Just some [Kotlinx coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html) extensions for `java.nio.channels.Asynchronous*` classes.

## Setup

Gradle,

```groovy
repositories {
    jcenter()
}

dependencies {
    def knio2Version = '0.2.0'
    implementation "io.github.agcom:knio2:$knio2Version"
}
```

For Maven and Ivy snippets, see the [distribution page](https://bintray.com/agcom/knio2/lib).

## Components

- Suspending extension functions for following classes,
  - `AsynchronousByteChannel`
  - `AsynchronousSocketChannel`
  - `AsynchronousFileChannel`
  - `AsynchronousServerSocketChannel`
  

The functions are named after their original name plus `await` suffix.

  ```kotlin
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
  ```

## Contribution

I add what I need. Make sure you do it too :smiley:.

## Status

If you only want Kotlinx coroutines IO, prefer its native libraries instead of Java ports. You can find them on [Awesome Kotlin](https://kotlin.link/).

This is a temporary project and may deprecate in favor of better asynchronous IO solutions with Kotlinx coroutines. For example, the [Kotlinx IO](https://github.com/Kotlin/kotlinx-io), which is kinda in development now.