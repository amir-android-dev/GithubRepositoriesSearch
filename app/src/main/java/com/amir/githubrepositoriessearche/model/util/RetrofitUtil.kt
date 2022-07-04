package com.amir.githubrepositoriessearche.model.util

import com.amir.githubrepositoriessearche.model.ApplicationClass
import com.amir.githubrepositoriessearche.model.RepositoriesAPI

class RetrofitUtil {

    companion object{

        val repositoryService: RepositoriesAPI = ApplicationClass.retrofit.create(RepositoriesAPI::class.java)
    }
}