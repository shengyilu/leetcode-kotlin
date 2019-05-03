package Algorithm

import java.util.*

class QuickSort {

    fun sort(target: Array<Int>, leftMostIndex: Int, rightMostIndex: Int) {
        if (leftMostIndex >= rightMostIndex) {
            return
        }
        swap(target, leftMostIndex, rightMostIndex)

        var movingIndex = leftMostIndex
        var step = 0
        while (movingIndex < rightMostIndex) {
            if (movingIndex + step == rightMostIndex) {
                swap(target, movingIndex, rightMostIndex)
                break
            }
            var tmp = target[movingIndex + step]
            if (tmp <= target[rightMostIndex]) {
                swap(target, movingIndex, movingIndex + step)
                step = 0
                movingIndex++
                continue
            }
            step++
        }

        sort(target, leftMostIndex, movingIndex - 1)
        sort(target, movingIndex + 1, rightMostIndex)

    }

    fun swap(target: Array<Int>, leftIndex: Int, rightIndex: Int) {
        if (leftIndex >= rightIndex) {
            return
        }
        var tmp = target[leftIndex]
        target[leftIndex] = target[rightIndex]
        target[rightIndex] = tmp
    }

}


fun main(args: Array<String>) {
    val target = arrayOf<Int>(7, 2, 4, 1, 8, 3, 9, 7, 6, 22, 11)

    val quickSort = QuickSort()
    quickSort.sort(target, 0, target.size - 1)

    println(Arrays.toString(target))

}