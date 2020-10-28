class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return generateResult(candidates.toList(), target).filter { it.sum() == target }
    }

    private fun generateResult(candidates: List<Int>, target: Int): List<List<Int>> {
        return candidates.takeIf { it.isNotEmpty() }?.run {
            flatMapIndexed { index: Int, num: Int ->
                when {
                    target < num -> {
                        listOf(listOf())
                    }
                    target == num -> {
                        listOf(listOf(target))
                    }
                    else -> {
                        generateResult(candidates.drop(index), target - num).map {
                            it.toMutableList()
                                .apply {
                                    add(0, num)
                                }
                        }
                    }
                }
            }
        }?: listOf(listOf())
    }

    private inline fun <T, R> Iterable<T>.flatMapIndexed(transform: (index: Int, T) -> Iterable<R>): List<R> {
        return flatMapIndexedTo(ArrayList(), transform)
    }

    private inline fun <T, R, C : MutableCollection<in R>> Iterable<T>.flatMapIndexedTo(destination: C, transform: (index: Int, T) -> Iterable<R>): C {
        var index = 0
        for (element in this) {
            val list = transform(index++, element)
            destination.addAll(list)
        }
        return destination
    }

}
