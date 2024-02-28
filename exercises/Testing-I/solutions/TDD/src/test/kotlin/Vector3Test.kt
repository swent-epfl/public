import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

internal class Vector3Test {

    @Test
    fun constructorAssignsCorrectComponents() {
        val x = 1.0f
        val y = 2.0f
        val z = 3.0f
        val v = Vector3(x, y, z)

        assertEquals(x, v.x)
        assertEquals(y, v.y)
        assertEquals(z, v.z)
    }

    @Test
    fun zeroIsZeroVector() {
        val v = Vector3.zero()
        assertEquals(0.0f, v.x)
        assertEquals(0.0f, v.y)
        assertEquals(0.0f, v.z)
    }

    @Test
    fun copyReturnsIdenticalCopy() {
        val x = 1.0f
        val y = 2.0f
        val z = 3.0f
        val v = Vector3(x, y, z)
        val vc = v.copy()

        assertEquals(1.0f, vc.x)
        assertEquals(2.0f, vc.y)
        assertEquals(3.0f, vc.z)
    }

    @Test
    fun isZeroReturnsTrueForZeroVector() {
        val v = Vector3.zero()
        assertTrue(v.isZero())
    }

    @Test
    fun isZeroReturnsFalseForNonzeroVector() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertTrue(!v.isZero())
    }

    @Test
    fun dotFailsWithNullVector() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertFailsWith<IllegalArgumentException> { v.dot(null) }
    }

    @Test
    fun dotWithZeroIsZero() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertEquals(0.0f, v.dot(Vector3.zero()))
    }

    @Test
    fun dotWithTwoNonzeroVectorIsCorrect() {
        val dot = 2.0f
        val v1 = Vector3(1.0f, 2.0f, 3.0f)
        val v2 = Vector3(-1.0f, 0.0f, 1.0f)

        assertEquals(dot, v1.dot(v2))
        assertEquals(dot, v2.dot(v1))
    }

    @Test
    fun lengthOfZeroIsZero() {
        assertEquals(0.0f, Vector3.zero().length())
    }

    @Test
    fun lengthOfVectorIsCorrect() {
        val length = 5.0f
        val v = Vector3(0.0f, 3.0f, 4.0f)

        assertEquals(length, v.length())
    }

    @Test
    fun crossFailsWithNullVector() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertFailsWith<IllegalArgumentException> { v.cross(null) }
    }

    @Test
    fun crossWithSelfIsZero() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertTrue(v.cross(v).isZero())
    }

    @Test
    fun crossWithUnitAxisIsCorrect() {
        val x = Vector3(1.0f, 0.0f, 0.0f)
        val y = Vector3(0.0f, 1.0f, 0.0f)
        val z = Vector3(0.0f, 0.0f, 1.0f)

        assertEquals(z, x.cross(y))
    }

    @Test
    fun dotWithCrossProductResultIsZero() {
        val v1 = Vector3(1.0f, 2.0f, 3.0f)
        val v2 = Vector3(-1.0f, 1.0f, 2.0f)
        val c = v1.cross(v2)

        assertEquals(0.0f, c.dot(v1))
        assertEquals(0.0f, c.dot(v2))
    }

    @Test
    fun normalizedOfUnitVectorIsSelf() {
        val x = Vector3(1.0f, 0.0f, 0.0f)
        assertEquals(x, x.normalized())
    }

    @Test
    fun normalizedOfLongVectorIsUnitLength() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertEquals(1.0f, v.normalized().length(), 1e-5f)
    }

    @Test
    fun scaledVectorIsCorrect() {
        val v1 = Vector3(1.0f, 2.0f, 3.0f)
        val v2 = Vector3(2.0f, 4.0f, 6.0f)

        assertEquals(v2, v1.scaled(2.0f))
    }

    @Test
    fun scaledVectorByZeroIsZero() {
        val v = Vector3(1.0f, 2.0f, 3.0f)
        assertTrue(v.scaled(0.0f).isZero())
    }

    @Test
    fun zeroIsNotEqualToNull() {
        val v = Vector3.zero()
        assertTrue(v != null)
    }

    @Test
    fun zeroIsEqualToItself() {
        val v = Vector3.zero()
        assertEquals(v, v)
    }

    @Test
    fun zeroHasDeterministicHashcode() {
        val v1 = Vector3.zero()
        val v2 = Vector3.zero()

        assertEquals(v1.hashCode(), v2.hashCode())
    }

    @Test
    fun zeroToStringUsesScientificNotation() {
        val v = Vector3.zero()
        assertTrue("e+00" in v.toString().lowercase(Locale.getDefault()))
    }

    @Test
    fun oneToStringUsesRegularNotation() {
        val v = Vector3(1.0f, 1.0f, 1.0f)
        assertTrue("e+00" !in v.toString().lowercase(Locale.getDefault()))
    }
}
