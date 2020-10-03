fun sumXor(n: Long): Long {
    var (target, result) = n to 0L
    while (target > 0) {
        result += if (target.rem(2) == 0L) 1L else 0L
        target /= 2
    }
    return Math.pow(2.0, result.toDouble()).toLong()
}
