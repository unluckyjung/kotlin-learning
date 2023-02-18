package basic.syntax.ps

fun main() {
    binarySearch()
    lowerUpperBound()
}

fun lowerUpperBound() {
    val nums = listOf(10, 20, 30, 40, 50, 60)

    println(getLowerIndex(nums = nums, -2)) // 0
    println(getLowerIndex(nums = nums, 30)) // 2
    println(getLowerIndex(nums = nums, 60)) // 5

    println(getUpperIndex(nums = nums, -2)) // 0
    println(getUpperIndex(nums = nums, 30)) // 3
    println(getUpperIndex(nums = nums, 60)) // -1
}

private fun binarySearch() {
    val nums = listOf(10, 20, 30, 40, 50, 60)
    println(nums.binarySearch(30))  // 2
    println(nums.binarySearch(-2))  // -1

    println(nums.binarySearch(element = 40, fromIndex = 0, toIndex = 4))    // 3
    println(nums.binarySearch(element = 40, fromIndex = 0, toIndex = 3))    // 음수 값
    println(nums.binarySearch(element = 40, fromIndex = 3, toIndex = 3))    // 음수 값
}

private fun getUpperIndex(nums: List<Int>, target: Int): Int {
    var st = 0
    var ed: Int = nums.size - 1
    var index = -1

    while (st <= ed) {
        val mid = st + (ed - st) / 2
        if (nums[mid] > target) {
            index = mid
            ed = mid - 1
        } else {
            st = mid + 1
        }
    }
    return index
}

private fun getLowerIndex(nums: List<Int>, target: Int): Int {
    var st = 0
    var ed: Int = nums.size - 1
    var index = -1

    while (st <= ed) {
        val mid = st + (ed - st) / 2
        if (nums[mid] >= target) {
            index = mid
            ed = mid - 1
        } else {
            st = mid + 1
        }
    }
    return index
}
