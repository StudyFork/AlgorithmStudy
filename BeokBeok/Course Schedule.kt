class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
         val matrix = Array(numCourses) {
            Array(numCourses) { 0 }
        }
        val indegree = Array(numCourses) { 0 }

        repeat(prerequisites.size) {
            val target = prerequisites[it][0]
            val preCondition = prerequisites[it][1]
            if (matrix[preCondition][target] == 0) indegree[target]++
            matrix[preCondition][target] = 1
        }
        val queue: Queue<Int> = LinkedList()
        repeat(indegree.size) {
            if (indegree[it] == 0) queue.offer(it)
        }
        var count = 0
        while (queue.isNotEmpty()) {
            val course = queue.poll()
            count++
            repeat(numCourses) {
                if (matrix[course][it] != 0 && --indegree[it] == 0) queue.offer(it)
            }
        }
        return count == numCourses
    }
}
