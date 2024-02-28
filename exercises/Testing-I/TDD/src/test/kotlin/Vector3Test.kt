import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

internal class Vector3Test {

    @Test
    fun vectorIsZero() {
        val v = Vector3(0f, 0f, 0f)
        assert(v.isZero())
    }

}
