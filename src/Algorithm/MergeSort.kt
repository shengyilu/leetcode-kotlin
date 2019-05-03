package Algorithm

import com.sun.scenario.effect.Merge
import java.util.*

class MergeSort {

    fun sort(target: Array<Int>) {
        var length = target.size
        if (length < 2) {
            return
        }

        var mid = length / 2
        var leftArray = target.copyOfRange(0, mid)
        var rightArray = target.copyOfRange(mid, length)

        println("------Left----------")
        println(Arrays.toString(leftArray))
        println("------Right----------")
        println(Arrays.toString(rightArray))

        sort(leftArray)
        sort(rightArray)
        merge(target, leftArray, rightArray)
    }

    fun merge(target: Array<Int>, leftArray: Array<Int>, rightArray: Array<Int>) {
        var targetStep = 0
        var leftStep = 0
        var rightStep = 0
        while (leftStep < leftArray.size && rightStep < rightArray.size) {
            if (leftArray[leftStep] < rightArray[rightStep]) {
                target[targetStep++] = leftArray[leftStep++]
            } else {
                target[targetStep++] = rightArray[rightStep++]
            }
        }

        while (leftStep < leftArray.size) {
            target[targetStep++] = leftArray[leftStep++]
        }

        while (rightStep < rightArray.size) {
            target[targetStep++] = rightArray[rightStep++]
        }
    }

}


fun main(args: Array<String>) {
    val target = arrayOf<Int>(7, 2, 4, 1, 8, 9, 7, 6, 22, 11)

    val mergeSort = MergeSort()
    mergeSort.sort(target)

    println(Arrays.toString(target))

}