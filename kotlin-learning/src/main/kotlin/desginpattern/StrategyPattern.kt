package desginpattern

fun main() {
    val strategyPattern = StrategyPattern(10)

    println(strategyPattern.getChangedNumber(MyNumber.DOUBLE))
    println(strategyPattern.getChangedNumber(MyNumber.TRIPLE))
}


class StrategyPattern(
    private val number: Int,
) {
    fun getChangedNumber(myNumber: MyNumber): Int {
        return myNumber.getMyNumber(number)
    }
}

enum class MyNumber {
    DOUBLE {
        override fun getMyNumber(baseNumber: Int): Int {
            println("2배된 숫자 반환 전략")
            return baseNumber * 2
        }

    },
    TRIPLE {
        override fun getMyNumber(baseNumber: Int): Int {
            println("3배된 숫자 반환 전략")
            return baseNumber * 3
        }

    };

    abstract fun getMyNumber(baseNumber: Int): Int
}
