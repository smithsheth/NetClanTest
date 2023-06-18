package com.example.netclantest

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DimenRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Badge
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.PlusOne
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.netclantest.core.RefineActivity.RefineActivity
import com.example.netclantest.core.bottombar.BottomBar
import com.example.netclantest.core.bottombar.BottomBarItem
import com.example.netclantest.core.explorescreen.ExploreScreen
import com.example.netclantest.ui.BottomNavItem
import com.example.netclantest.ui.theme.NetClanTestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          NetClanTestTheme {
              DefaultPreview();
          }

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun DefaultPreview() {
        val homeNavController = rememberNavController()
        Scaffold(
            topBar = { AppTopBar() },
            content = {
                padding-> 
                Box(modifier = Modifier.padding(padding)){
                    HomeNavGraph(navController = homeNavController)

                }
                
            },
        )
    }

    // @Preview function is use to see preview
// for our composable function in preview section.
//    @Preview(showBackground = true)
//    @Composable
//    fun DefaultPreview() {
//        NetClanTestTheme {
//            // we are passing our composable
//            // function to display its preview.
//            ToolBarWidget();
//        }
//    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    private fun AppTopBar() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val mContext = LocalContext.current
    TopAppBar(title = {Text("Simple", color = Color.White)},
         modifier = Modifier.fillMaxWidth(), navigationIcon = {
            IconButton(onClick = {coroutineScope.launch { scaffoldState.drawerState.open() }} ){
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null, tint = Color.White)

            }

        }, actions = {
        IconButton(onClick = { mContext.startActivity(Intent(mContext, RefineActivity::class.java)) }) {
            Column(
                modifier = Modifier.padding(1.dp),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center) {


            Icon(Icons.Filled.Checklist, contentDescription = "Localized description", tint= Color.White)
            Spacer(modifier = Modifier.height(height = 1.dp))
            Text(text = "Refine",color=Color.White)
            }}},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF002c58)
        ))


}
//
//@Composable
//private fun AppBottomBar() {
//    val navController = rememberNavController()
//    BottomAppBar(tonalElevation = 10.dp,
//    ) {
//    }
////    val navController = rememberNavController()
//
//    }



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetworkScreen(navController: NavHostController) {
    Scaffold(
    bottomBar = {
        BottomBar(navController)
    },     modifier = Modifier
    .fillMaxSize()){}

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },     modifier = Modifier
            .fillMaxSize()){}

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },     modifier = Modifier
            .fillMaxSize()){}

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupsScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },     modifier = Modifier
            .fillMaxSize()){}

}
@Composable
fun HomeNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "explore_screen") {
        composable("explore_screen") {
            ExploreScreen(navController)
        }
        composable("network_screen") {
            NetworkScreen(navController)
        }

        composable("chat_screen") {
            ChatScreen(navController)
        }
        composable("contacts_screen") {
            ContactsScreen(navController)
        }

        composable("groups_screen") {
            GroupsScreen(navController)
        }

    }
}
