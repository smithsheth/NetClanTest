package com.example.netclantest.core.explorescreen.views
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.netclantest.R
import com.example.netclantest.data.models.DataItem

@Composable
fun DataCard(
    data1: DataItem
){
    Surface(
        color = Color(0xFFFFFF),
        modifier = Modifier
            .wrapContentSize()
            .wrapContentHeight()
            .padding(10.dp)
    ) {

        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Color(0xFFFFFFFF),
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
                .padding(start = 20.dp),
            shadowElevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
                    .padding(start = 10.dp),
            ) {
                Row (
                    modifier=Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    OutlinedButton(onClick = { /*TODO*/ }, Modifier.wrapContentSize()) {
                        Text(text = "+Invite")
                    }
                }
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 50.dp),
                    verticalArrangement = Arrangement.Center,
                ) {



                    Text(
                        data1.name,
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(modifier = Modifier.wrapContentSize(), color = Color(0xFFFFFFFF),
                    ) {
                        Row(){
                            Text(
                                data1.city,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                            Text(
                                data1.role,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }

                    }


                    Spacer(modifier = Modifier.height(2.dp))

                    Column(
                        Modifier.wrapContentSize()
                    ) {
                        Text(text="Within" + data1.range)

                        Spacer(modifier = Modifier.height(2.dp))
                        LinearProgressIndicator(
                            modifier = Modifier.wrapContentSize(),
                            progress = 0.2f
                        )
                    }

                }
                Spacer(modifier = Modifier.height(4.dp))
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 0.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Surface(modifier = Modifier.wrapContentSize(), color = Color(0xFFFFFFFF),
                    ) {
                        Column() {


                            Row() {
                                Text(
                                    fontWeight = FontWeight.SemiBold,
                                    text =data1.purpose,
                                    fontSize = 16.sp,
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                                )
                            }
                            Text(
                                text =data1.status,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }
                    }
                }

            }

        }

        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(start = 10.dp, top = 50.dp)
        ) {
            Column(
                modifier=Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_box_24),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 80.dp, height = 80.dp)
                )
            }

        }

    }

}


