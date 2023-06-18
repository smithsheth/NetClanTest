package com.example.netclantest.core.RefineActivity

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.transition.Slide
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.RangeSlider
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.netclantest.ui.theme.NetClanTestTheme
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class RefineActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
           NetClanTestTheme {
               RefineScreen()
           }
        }
    }
    
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
    @Composable
    fun RefineScreen() {
        val options = listOf("Available | Hey Let Us Connect", "Away | Stay Discreet and Watch")
        val (value, onValueChange) = remember { mutableStateOf("") }
        var sliderPosition by remember { mutableStateOf(0) }
        var expanded by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf(options[0]) }
        Scaffold(
    
            topBar = { AppTopBar() },
            modifier=Modifier.fillMaxSize()){
            Surface(
                modifier= Modifier
                    .padding(top = 60.dp)
                    .padding(20.dp)
            ) {
                Column(
                ) {
                    Text(text = "Select Your Availability",style = MaterialTheme.typography.titleMedium,)

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded },
                    ) {
                        TextField(
                            // The `menuAnchor` modifier must be passed to the text field for correctness.
                            modifier = Modifier.menuAnchor(),
                            readOnly = true,
                            value = selectedOptionText,
                            onValueChange = {},
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.White),
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            options.forEach { selectionOption ->
                                DropdownMenuItem(
                                    text = { Text(selectionOption) },
                                    onClick = {
                                        selectedOptionText = selectionOption
                                        expanded = false
                                    },
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Add your Status",style = MaterialTheme.typography.titleMedium,)
                    Spacer(modifier = Modifier.height(5.dp))
                    OutlinedTextField(value = "Hi Community, Im Open to new Connections", onValueChange = onValueChange,
                        maxLines = 250 ,
                        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White)
                  )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Select Hyper Local Distance",style = MaterialTheme.typography.titleMedium,)
                    Text(text = sliderPosition.toString(),modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                    Slider(value = sliderPosition.toFloat(),  onValueChange = { sliderPosition_ ->
                        sliderPosition = sliderPosition_.toInt()                    },
                        valueRange = 0f..100f,
                    steps = 100,interactionSource = remember { MutableInteractionSource() })
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        ) {
                        Text(text = "1 Km", textAlign = TextAlign.Start,modifier= Modifier.weight(5f))
                        Text(text = "100 Km", textAlign = TextAlign.End,modifier= Modifier.weight(5f))

                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Select Purpose",style = MaterialTheme.typography.titleMedium,)
                    Column(){
                        Row() {
                            OutlinedButton(onClick = {}) {
                                Text(text = "Coffee")
                            }
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Business")
                            }
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Hobbies")
                            }
                        }
                        Row() {
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Friendship")
                            }
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Movies")
                            }
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Dining")
                            }
                        }
                        Row() {
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Dating")
                            }
                            OutlinedButton(onClick = { /*TODO*/ },) {
                                Text(text = "Matrimony")
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement =Arrangement.Center) {
                            ElevatedButton(onClick = { /*TODO*/ },
                                colors=ButtonDefaults.elevatedButtonColors(containerColor = Color(0xFF003b58))) {
                                Text(text = "Save & Explore", color = Color.White)
                            }

                        }
                    }
                }                }
            }

    }


}@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val mContext = LocalContext.current
    TopAppBar(title = { Text("Refine",color= Color.White) },
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="", tint = Color.White )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF002c58)
        )
        )


}