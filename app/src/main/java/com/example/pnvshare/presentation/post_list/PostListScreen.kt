package com.example.pnvshare.presentation.post_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pnvshare.presentation.post_list.PostListState
import com.example.pnvshare.presentation.post_list.components.PostList
import com.example.pnvshare.ui.theme.LightPurple

@ExperimentalMaterialApi
@Composable
fun PostListScreen(
    state: PostListState,
    navigateToPostDetail: () -> Unit,
    isRefreshing: Boolean,
    refreshData: () -> Unit,
    onItemClick: (String) -> Unit,
    deletePost: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToPostDetail,
                backgroundColor = LightPurple,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    ) {
        PostList(
            state = state,
            isRefreshing = isRefreshing,
            refreshData = refreshData,
            onItemClick = onItemClick,
            deletePost = deletePost
        )
    }
}