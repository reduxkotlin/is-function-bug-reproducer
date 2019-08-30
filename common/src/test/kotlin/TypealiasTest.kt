import kotlin.test.Test
import kotlin.test.fail

class FunctionCheckTest {

    @Test
    fun passIsCheck() {
        if ({ str: String -> } is Function<*>) {
        } else {
            fail("Function not recognized in `is Function<*>`")
        }
    }
}