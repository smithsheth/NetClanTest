package com.example.netclantest.core.explorescreen.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.netclantest.core.bottombar.AddItem
import com.example.netclantest.core.explorescreen.secondtop.SecondTopBar


@Composable
fun TopBarTab() {
    val screens = listOf(
        Tabs.Personal,
        Tabs.Business,
        Tabs.Merchant,

    )
    var selectedTab by remember {  mutableStateOf(0) }
Column {
    TabRow(selectedTabIndex = selectedTab, modifier = Modifier.padding(top = 5.dp), backgroundColor = Color(0xFF003b58)) {
        screens.forEachIndexed { index, it ->
            Tab(selected = selectedTab == index, onClick = { selectedTab = index }, text = {
                Text(text = it.title)
            }, selectedContentColor = White, unselectedContentColor = LightGray)

        }

    }
    SecondTopBar()
}


}

//@Composable
//fun RowScope.AddItem(
//    screen: TopBarItem,
//    currentDest: NavDestination?,
//    navController: NavController
//) {
//    TopBarItem{
//        n
//    )
//}
//}

//@Preview
//@Composable
//fun TopBarPreview() {
//    // Create a sample NavController instance (you can use a mock implementation)
//
//    // Call the original BottomBar composable
//    TopBarTab(sele)
//}

