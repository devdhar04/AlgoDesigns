package com.example.algodesign.strings

class PalindromicSubstring {

    fun countSubstrings(s: String?): Int {
        var res = 0
        if (s == null) return res
        res += s.length
        for (i in s.indices) {
            for (j in i + 1 until s.length) {
                val st = StringBuilder(s.substring(i, j + 1))
                if (st.toString() == st.reverse().toString()) res++
            }
        }
        return res
    }
}
