package com.example.pnvshare.presentation.post_detail

import com.example.pnvshare.model.Post


data class PostDetailState(
    val isLoading: Boolean = false,
    val post: Post? = null,
    val error: String = ""
)