# KNIO2

[![Maven Central latest version badge](https://img.shields.io/maven-central/v/io.github.agcom/knio2)](https://search.maven.org/artifact/io.github.agcom/knio2)
[![Awesome Kotlin badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![License badge](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

Just some [Kotlinx coroutines](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html) extensions for `java.nio.channels.Asynchronous*` classes.

## Setup

Published to the [Maven Central repository](https://search.maven.org/search?q=g:io.github.agcom%20a:knio2).

Gradle snippet,

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation "io.github.agcom:knio2:0.4.1"
}
```

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