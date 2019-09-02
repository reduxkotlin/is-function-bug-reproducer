import kotlin.test.Test
import kotlin.test.fail

typealias Dispatch = (Any) -> Any
typealias GetState = () -> Any
typealias Thunk = (Dispatch, GetState, Any?) -> Any

data class AppState(val string: String)

val dispatch: Dispatch = { }
val getState: GetState = { AppState("myState") }

fun myThunk(dispatch: Dispatch, getState: GetState, arg: Any?) {
    println("Inside thunk")
}


fun multiParamFunctionTest(foo: Any) {
    if (foo is Function<*>) {
        (foo as Thunk)(dispatch, getState, null)
    } else {
        fail()
    }
}


/**
 * Demonstrates bug with `is Function<*>.  Passes on JVM & Native, fails on JS
 */
class FunctionCheckTest {


    @Test
    fun passIsCheck() {
        if ({ str: String -> } is Function<*>) {
        } else {
            fail("Function not recognized in `is Function<*>`")
        }
    }

    @Test
    fun typeAliasCheck() {
        multiParamFunctionTest(::myThunk)
    }
}