package com.amir.githubrepositoriessearche.model


import com.amir.githubrepositoriessearche.model.data.GithubResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesAPI {
    //URL End point
    @GET("/search/repositories")
    fun getRepositories(@Query("q") q: String) : Call<GithubResponse>


}