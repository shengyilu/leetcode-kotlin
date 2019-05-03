package Leetcode

import Algorithm.QuickSort
import java.util.*

/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */

import java.lang.Character.MIN_VALUE as nullChar

class Leetcode_824 {

    fun toGoatLatin(S: String): String {
        var result = StringBuilder()
        var strArray = S.split(" ").toTypedArray()
        var index = 0
        for (s in strArray) {
            index++
            var singleStr = StringBuilder()
            var charArray = s.toCharArray()
            if (charArray[0].equals('a', true) ||
                charArray[0].equals('e', true) ||
                charArray[0].equals('i', true) ||
                charArray[0].equals('o', true) ||
                charArray[0].equals('u', true)) {
                singleStr.append(charArray)
                        .append("ma")
            } else {
                for (i in 1..charArray.size-1) {
                    singleStr.append(charArray[i])
                }
                singleStr.append(charArray[0])
                singleStr.append("ma")
            }

            for (i in 1..index) {
                singleStr.append('a')
            }
            if (index < strArray.size) {
                singleStr.append(' ')
            }
            result.append(singleStr.toString())
        }
        return result.toString()
    }

    fun toGoatLatin2(S: String): String {
        var result = StringBuilder()
        var strCharArray = S.toCharArray()
        var index = 0
        var newWord = true
        var temp: Char = '\u0000'

        for (i in 0..strCharArray.size-1) {
            var c = strCharArray[i]
            if (c.equals(' ') || i == strCharArray.size-1) {
                index++

                if (i == strCharArray.size-1) {
                    result.append(c)
                }
                if (temp != '\u0000') {
                    result.append(temp)
                    temp = '\u0000'
                }
                result.append("ma")
                for (i in 1..index) {
                    result.append('a')
                }
                if (c.equals(' ')) {
                    result.append(c)
                }
                newWord = true
                continue
            }

            if (newWord) {
                newWord = false
                if (!(c.equals('a', true) || c.equals('e', true) ||
                                c.equals('i', true) || c.equals('o', true) ||
                                c.equals('u', true))) {
                    temp = c
                    continue
                }
            }
            result.append(c)
        }
        return result.toString()
    }

}


fun main(args: Array<String>) {
    val target = "I speak Goat Latin"
    val leetcode = Leetcode_824()

    println(leetcode.toGoatLatin2(target))

}