package com.example.netclantest.core.explorescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.netclantest.core.bottombar.BottomBar
import com.example.netclantest.core.explorescreen.secondtop.SecondTopBar
import com.example.netclantest.core.explorescreen.topbar.TopBarTab
import com.example.netclantest.core.explorescreen.views.DataCard
import com.example.netclantest.data.models.DataItem


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ExploreScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBarTab()
                },
        bottomBar = {
            BottomBar(navController)
        },     modifier = Modifier
            .fillMaxSize()){
        LazyColumn {

            items(getDataList()){
                DataCard(data1 = getDataList().get(0))
            }

        }
    }

}
fun getDataList():MutableList<DataItem>{
    val dataList = mutableListOf<DataItem>()
    dataList.add(
        DataItem(
            "Smit Sheth",
            "Pune",
            "Android Developer",
            "1 km",
            "Coffee | Business",
            "Hey There, I'm using netclan"

        )
    )
    dataList.add(
        DataItem(
            "Smit Sheth",
            "Pune",
            "Android Developer",
            "1 km",
            "Coffee | Business",
            "Hey There"

        )
    )
    dataList.add(
        DataItem(
            "Smit Sheth",
            "Pune",
            "Android Developer",
            "1 km",
            "Coffee | Business",
            "Hey There"

        )
    )
    dataList.add(
        DataItem(
            "Smit Sheth",
            "Pune",
            "Android Developer",
            "1 km",
            "Coffee | Business",
            "Hey There"
        )
    )
return dataList
}

