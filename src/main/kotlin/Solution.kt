class Solution {
    fun filterEvenNumbers(numbers: List<Int>): List<Int> {
        val filterList = mutableListOf<Int>()
        numbers.forEach {
            if(it % 2 == 0) filterList.add(it)
        }
        return filterList
    }
}