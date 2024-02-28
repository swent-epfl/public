/**
 * A `Vector3` is a 3-component vector of 32-bit floating point numbers.
 */
data class Vector3(val x: Float, val y: Float, val z: Float) {

    companion object {
        fun zero() = Vector3(0.0f, 0.0f, 0.0f)
    }

    fun copy() = Vector3(x, y, z)

    fun isZero() = isAll { it == 0.0f }

    fun dot(other: Vector3?): Float {
        requireNotNull(other) { "Other vector must not be null" }
        return x * other.x + y * other.y + z * other.z
    }

    fun length() = kotlin.math.sqrt(dot(this).toDouble()).toFloat()

    fun cross(other: Vector3?): Vector3 {
        requireNotNull(other) { "Other vector must not be null" }
        return Vector3(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        )
    }

    fun normalized(): Vector3 {
        val length = length()
        if (length <= 1e-5) {
            return copy()
        }
        return scaled(1.0f / length)
    }

    fun scaled(scalar: Float) = apply { it * scalar }

    override fun toString(): String {
        val format = if (isAny { it < 1e-2 }) "%e" else "%f"
        return "[ ${format.format(x)} ${format.format(y)} ${format.format(z)} ]"
    }

    private fun isAny(predicate: (Float) -> Boolean) =
        predicate(x) || predicate(y) || predicate(z)

    private fun isAll(predicate: (Float) -> Boolean) =
        predicate(x) && predicate(y) && predicate(z)

    private fun apply(function: (Float) -> Float) =
        Vector3(function(x), function(y), function(z))
}
