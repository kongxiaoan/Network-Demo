package com.kpa.demo.data.model

import com.google.gson.annotations.SerializedName

data class Girl(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("likeCounts")
    val likeCounts: Int,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("views")
    val views: Int
)