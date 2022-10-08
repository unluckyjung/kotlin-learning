package basic.syntax.common.enums

enum class WHETHER(
) {
    SPRING,
    SUMMER,
    FAR,
    WINTER,
    ;

    fun isHot(whether: WHETHER): Boolean {
        return when (whether) {
            SUMMER -> true
            else -> false
        }
    }
}