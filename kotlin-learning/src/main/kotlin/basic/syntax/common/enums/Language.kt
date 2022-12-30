package basic.syntax.common.enums

enum class Language(val value: String) {
    C("c"),
    CPP("c++"),
    CSHARP("c#"),
    PYTHON("python"),
    JAVA("java"),
    KOTLIN("kotlin");

    companion object {
        private val languageMap: MutableMap<String, Language> = mutableMapOf()

        init {
            values().forEach {
                languageMap[it.value] = it
            }
        }

        fun findByValue(value: String): Language {
            return values().find {
                it.value == value
            } ?: throw IllegalArgumentException("존재하지 않는 언어입니다. $value")
        }

        fun findByValueUseCache(value: String): Language {
            return languageMap[value] ?: throw IllegalArgumentException("존재하지 않는 언어입니다. $value")
        }
    }
}
