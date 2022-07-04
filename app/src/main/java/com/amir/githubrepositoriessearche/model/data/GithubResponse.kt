package com.amir.githubrepositoriessearche.model.data


import com.google.gson.annotations.SerializedName

data class GithubResponse(
    @SerializedName("total_count") var totalCount: Int? = null,
    @SerializedName("incomplete_results") var incompleteResults: Boolean? = null,
    @SerializedName("items") var items: List<Item>
)
