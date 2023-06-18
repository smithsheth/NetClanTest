package com.example.netclantest.ui

import androidx.compose.ui.graphics.vector.ImageVector

class BottomNavItem(
    val name:String,
    val route:String,
    val icon: ImageVector,
    val badgeCount:Int=0
)