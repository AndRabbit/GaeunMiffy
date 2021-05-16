package org.sopt.seminar1.api

import org.sopt.seminar1.data.request.RequestJoinData
import org.sopt.seminar1.data.request.RequestLoginData
import org.sopt.seminar1.data.response.ResponseJoinData
import org.sopt.seminar1.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptServiece {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>


    @POST("/login/signup")
    fun postJoin(
            @Body body: RequestJoinData
    ) : Call<ResponseJoinData>
}