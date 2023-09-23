package basic.syntax.extension

class WrappingMap(
    private val map: MutableMap<String, String>
) {

    operator fun get(key: String): String? {
        return map[key]
    }

    operator fun set(key: String, value: String) {
        this.map[key] = "$PREFIX $value"
    }

    companion object {
        const val PREFIX = "wrapping"
    }
}
