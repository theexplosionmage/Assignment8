package com.example.assignment8.repository

import com.example.assignment8.api.RetroFInst
import com.example.retrofittest.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetroFInst.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetroFInst.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetroFInst.api.getCustomPosts(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetroFInst.api.getCustomPosts2(userId, options)
    }

}