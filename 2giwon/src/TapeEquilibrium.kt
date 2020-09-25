
import kotlin.math.abs
import kotlin.math.min

class TapeEquilibrium {
    fun tapeEquilibrium(tape: IntArray): Int {
        var front = 0
        val total = tape.sum()
        var result = Int.MAX_VALUE

        for (p in 0 until tape.lastIndex) {
            front += tape[p]
            val end = total - front
            result = min(result, abs(end - front))
        }


        return result
    }
}