package com.example.algodesign.repository

import android.content.Context
import com.example.algodesign.model.ProblemList
import com.example.algodesign.utils.Utils
import com.google.gson.Gson

class ProblemRepository {

    fun getProblemList(context: Context): ProblemList {

        return Gson().fromJson(Utils.loadDefaultConfigFile(context), ProblemList::class.java)
    }


}
