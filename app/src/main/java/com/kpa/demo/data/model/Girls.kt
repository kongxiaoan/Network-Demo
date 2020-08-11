package com.kpa.demo.data.model

import com.google.gson.annotations.SerializedName
import com.kpa.demo.data.model.Girl

data class Girls(
    @SerializedName("data")
    val girlList: List<Girl>,
    val page: Int,
    val page_count: Int,
    val status: Int,
    val total_counts: Int
)