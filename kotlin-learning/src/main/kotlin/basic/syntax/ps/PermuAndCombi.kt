package basic.syntax.ps

fun main() {
    printPermutation()
    printCombination()
}

private fun printCombination() {
    val list = listOf(1, 2, 3, 4)

    combination(
        list = list,
        used = MutableList(list.size) { false },
        wantCount = 2,
        selectedCount = 0,
        index = 0,
    )
}

private fun printPermutation() {
    val list = listOf(1, 2, 3, 4)

    permutation(
        list = list,
        used = MutableList(list.size) { false },
        selected = MutableList(list.size) { -1 },
        count = 0
    )
}

private fun permutation(list: List<Int>, used: MutableList<Boolean>, selected: MutableList<Int>, count: Int) {
    if (count == list.size) {
        printSelected(selected)
        return
    }

    for (index in list.indices) {
        if (used[index]) continue

        used[index] = true
        selected[count] = list[index]
        permutation(list, used, selected, count + 1)
        used[index] = false
    }
}

private fun combination(list: List<Int>, used: MutableList<Boolean>, wantCount: Int, selectedCount: Int, index: Int) {
    if (selectedCount == wantCount) {
        printSelected(list, used)
        return
    }
    if (index == list.size) return

    used[index] = true
    combination(list, used, wantCount, selectedCount + 1, index + 1)
    used[index] = false
    combination(list, used, wantCount, selectedCount, index + 1)
}

private fun printSelected(nums: List<Int>) {
    for (num in nums) {
        print("$num ")
    }
    println()
}

private fun printSelected(nums: List<Int>, used: List<Boolean>) {

    nums.forEachIndexed { index, num ->
        if (used[index]) {
            print("$num ")
        }
    }
    println()
}
