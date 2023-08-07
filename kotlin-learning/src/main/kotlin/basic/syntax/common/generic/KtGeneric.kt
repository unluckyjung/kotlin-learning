package basic.syntax.common.generic

class KtGeneric {
}

data class KtGenericData<T>(
    val key: String,
    val value: T,
)

class KtGenericMap<T>(
    list: List<KtGenericData<T>>
) {
    private val map = list.associateBy { it.key }

    fun findByKey(key: String): KtGenericData<T> {
        return map[key] ?: throw IllegalArgumentException()
    }
}
