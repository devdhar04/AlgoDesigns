package com.example.algodesign.problems.string

import android.util.Log

class Anagram {

    // s = friend
    // t = family

    fun minSteps(s: String, t: String): Int {
        findCommon(s,t)
        return 0
    }

    fun findCommon(s: String, t: String) {
        val sMap = HashMap<String, Int>()
        val tMap = HashMap<String, Int>()
        s.forEach {
            if (sMap[it.toString()] != null) {
                var count = sMap[it.toString()]
                sMap[it.toString()] = count!!.plus(1)
            } else {
                sMap[it.toString()] = 1
            }

        }

        t.forEach {
            if (tMap[it.toString()] != null) {
                var count = tMap[it.toString()]
                tMap[it.toString()] = count!!.plus(1)
            } else {
                tMap[it.toString()] = 1
            }
            //Log.v("sMap tMap","$it = ${tMap[it.toString()]}")
        }

        var step = 0;
        sMap.keys.forEach {
            Log.v("sMap","$it = ${sMap[it]}")
            var tMapCharCount = tMap[it]
            var sMapCharCount = sMap[it]
            if(tMapCharCount != null){
                if(tMapCharCount > sMapCharCount!!){

                }else{

                }
            }
            else{

            }
        }
        tMap.keys.forEach {
            Log.v("sMap tMap","$it = ${tMap[it]}")
        }
    }
}
