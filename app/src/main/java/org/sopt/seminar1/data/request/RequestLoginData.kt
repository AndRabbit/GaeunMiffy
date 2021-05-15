package org.sopt.seminar1.data.request

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("email")
    val id: String,
    val password: String,
)
