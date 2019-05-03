package leecode_easy

class Question_709 {

    fun toLowerCase(str: String): String {
        var sb:StringBuilder = StringBuilder()

        for (s in str.toCharArray()) {

            if (s <= 'Z' && s >= 'A') {
                sb.append(s.minus('A').toChar().plus('a'.toInt()))
            } else {
                sb.append(s)
            }
        }
        return sb.toString()
    }

}
