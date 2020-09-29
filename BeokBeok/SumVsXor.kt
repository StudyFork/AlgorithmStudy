fun sumXor(n: Long): Long {
    val binaryString = n.toString(radix = 2)
    val max = Math.pow(2.toDouble(), binaryString.length.toDouble()).toLong()
    var result = 0L
    for (i in 0..max - n) {
        if (n xor i == n + i) result++
    }

    return result
}
