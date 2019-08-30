# Function<*> is check bug

This is a reproducer of a bug in Kotlin as [reported in youtrack](https://youtrack.jetbrains.com/issue/KT-33149).

```kotlin
class FunctionCheckTest {

    @Test
    fun passIsCheck() {
        if ({ str: String -> } is Function<*>) {
        } else {
            fail("Function not recognized in `is Function<*>`")
        }
    }
}
```

To run:

./gradlew jvmTest  <----  passes

./gradlew jsTest   <----  fails

Originally thought this was a bug with typealias, however the bug exists with functions.

Behavior is not consistent between platforms.  JVM passes.  JS & Native fail.
Only JS tests run on this project due to difficulty setting up tests.  This has been observed to fail
in the native environment.
