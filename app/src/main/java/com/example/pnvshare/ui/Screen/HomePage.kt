package com.example.pnvshare.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pnvshare.R
import com.example.pnvshare.ui.theme.DeepBlue
import com.example.pnvshare.ui.theme.LightBlue
import com.example.pnvshare.ui.theme.LightPurple

@Composable
fun HomePage(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(

                navigationIcon = {
                    IconButton(onClick ={}) {
                        Icon(imageVector = Icons.Filled.Home, contentDescription = null, tint = Color.White,)
                    }
                },
                modifier = Modifier.height(68.dp),
                title = { Text(text = "PNV Share Dream", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) },
                actions = { IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Favorite , contentDescription = null, tint = Color.Red)
                }
                },
                elevation = 0.dp,
                backgroundColor = DeepBlue,
                contentColor = Color.Yellow,
            )
        },
        // Create button App Bar
        bottomBar = {
            Row(
                Modifier
                    .padding(1.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Button(
                    onClick = {navController.navigate("home")},
                    Modifier
                        .height(53.dp)
                        .width(110.dp),

                    colors = ButtonDefaults.buttonColors(backgroundColor = LightPurple),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text("Trang chủ", fontSize = 14.sp, color = Color.White, maxLines = 1)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = {},
                    Modifier
                        .height(53.dp)
                        .width(110.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = LightPurple),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text("Add", fontSize = 14.sp ,color = Color.White,maxLines = 1)
                }
                Spacer(modifier = Modifier.width(5.dp))

                Button(
                    onClick = {navController.navigate("login_page")},
                    Modifier
                        .height(53.dp)
                        .width(110.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = LightPurple),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text("Tài khoản", fontSize = 14.sp, color = Color.White,maxLines = 1)
                }
            }
        },
        backgroundColor = DeepBlue,
        contentColor = Color.White
    ) {
        Column(Modifier.padding(10.dp)) {
            LazyRow(
                Modifier.height(130.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    PromotionItem(
                        imagePainter = painterResource(id = R.drawable.ao1),
                        title = "Áo Thun",
                        subtitle = "Start @",
                        header = "$1",
                        backgroundColor = MaterialTheme.colors.primary
                    )
                }
                item {
                    PromotionItem(
                        imagePainter = painterResource(id = R.drawable.ao2),
                        title = "Áo thun",
                        subtitle = "Discount",
                        header = "20%",
                        backgroundColor = Color(0xff6EB6F5)
                    )
                }
                item {
                    PromotionItem(
                        imagePainter = painterResource(id = R.drawable.ao3),
                        title = "Áo khoác",
                        subtitle = "Discount",
                        header = "40%",
                        backgroundColor = Color(0xff6EB6F5)
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text("Danh mục", style = MaterialTheme.typography.h4, color = Color.Red)
            Row(
                modifier = Modifier
                    .height(100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ThuCung(navController)
                Spacer(modifier = Modifier.width(12.dp))
                NoiThat(navController)
            }
            Row(
                modifier = Modifier
                    .height(100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GiaDung(navController)
                Spacer(modifier = Modifier.width(12.dp))
                QuanAo(navController)
            }
        }
    }
}
@Composable
fun ThuCung(
    navController: NavController
) {
        Button(
            modifier = Modifier
                .height(90.dp)
                .width(163.dp),
            onClick = {navController.navigate("home")}
        ){
            Text("Thú Cưng")
            Image(
                painter = painterResource(id = R.drawable.quana), contentDescription = null)
        }
}
@Composable
fun NoiThat(
    navController: NavController
) {
        Button(
            modifier = Modifier
                .height(90.dp)
                .width(163.dp)
            ,
            onClick = {}
        ){
            Text("Nội thất")
            Image(painter = painterResource(id = R.drawable.noithat), contentDescription = null)
        }
}
@Composable
fun GiaDung(
    navController: NavController
) {

        Button(
            modifier = Modifier
                .height(90.dp)
                .width(163.dp)
            ,
            onClick = {}
        ){
            Text("Gia Dụng")
            Image(painter = painterResource(id = R.drawable.giadung), contentDescription = null)
        }
    }
@Composable
fun QuanAo(
    navController: NavController
) {
        Button(
            modifier = Modifier
                .height(90.dp)
                .width(163.dp)
            ,
            onClick = {}
        ){
            Text("Quần áo")
            Image(painter = painterResource(id = R.drawable.quanao), contentDescription = null)
        }
    }

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color = Color.Transparent,
    imagePainter: Painter
) {
    Card(
        Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}