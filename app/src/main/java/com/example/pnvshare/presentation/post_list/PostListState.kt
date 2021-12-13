package com.example.pnvshare.presentation.post_list

import com.example.pnvshare.model.Post


data class PostListState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String = ""
)
