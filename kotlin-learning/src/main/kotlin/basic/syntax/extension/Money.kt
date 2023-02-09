package basic.syntax.extension

data class Money(
    val value: Int,
) {
    init {
        require(value >= 0) {
            "돈은 음수가 될 수 없습니다."
        }
    }

    operator fun plus(money: Money): Money {
        return Money(this.value + money.value)
    }
}

fun Iterable<Money>.sum(): Money {
    var sum = Money(0)
    for (element in this) {
        sum += element
    }
    return sum
}
