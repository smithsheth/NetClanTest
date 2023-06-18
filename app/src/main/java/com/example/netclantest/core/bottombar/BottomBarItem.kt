package com.example.netclantest.core.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    val navigation: String,
    val title: String,
    val icon: ImageVector
) {
    object Explore : BottomBarItem(
        navigation = "explore_screen",
        title = "Explore",
        icon = Icons.Rounded.RemoveRedEye
    )

    object Network : BottomBarItem(
        navigation = "network_screen",
        title = "Network",
        icon = Icons.Rounded.Workspaces
    )

    object Chat : BottomBarItem(
        navigation = "chat_screen",
        title = "Chat",
        icon = Icons.Rounded.Chat
    )

    object Contacts : BottomBarItem(
        navigation = "contacts_screen",
        title = "Contacts",
        icon = Icons.Rounded.Contacts
    )

    object Groups : BottomBarItem(
        navigation = "groups_screen",
        title = "Groups",
        icon = Icons.Rounded.Groups
    )
}
