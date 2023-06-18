package com.example.netclantest.core.explorescreen.secondtop

import android.widget.SearchView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondTopBar() {
    Row() {
        val (value, onValueChange) = remember { mutableStateOf("") }

        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 12.sp),
            leadingIcon = { Icon(Icons.Filled.Search, null, tint = Color(0xFF728A96)) },
            modifier = Modifier
                .padding(10.dp)
                .background(Color(0xFFFFFFFF))
                .border(
                    border = BorderStroke(1.dp, Color(0xFF728A96)),
                    shape = RoundedCornerShape(30.dp)
                ).wrapContentSize().height(60.dp),
            placeholder = { Text(text = "Search", color =  Color(0xFF728A96))},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White,
                containerColor = Color.White,
            )

        )
        Icon(imageVector = Icons.Default.FilterAlt, contentDescription = "", modifier = Modifier.padding(10.dp).size(48.dp),)
    }

}


