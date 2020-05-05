package com.example.algodesign.utils

import android.content.Context
import android.content.res.AssetManager
import java.io.IOException


class Utils {

    companion object {
        const val DEFAULT_CONFIG_FILE = "problems.json"

        fun loadDefaultConfigFile(context: Context): String {
            val assetManager: AssetManager = context.resources.assets
            return try {
                val inputStream = assetManager.open(DEFAULT_CONFIG_FILE)
                val size = inputStream.available()
                val buffer = ByteArray(size)

                inputStream.read(buffer)
                inputStream.close()
                String(buffer, Charsets.UTF_8)
            } catch (ex: IOException) {
                ""
            }
        }
    }


}
