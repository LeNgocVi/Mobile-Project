package com.example.pnvshare.ui.Screen

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pnvshare.R
import com.example.pnvshare.data.AnimalsData
import com.example.pnvshare.data.AnimalsList
import com.example.pnvshare.ui.theme.DeepBlue
import com.example.pnvshare.ui.theme.LightBlue

@Composable
fun HomeScreen(navController: NavController){
    Scaffold() {
       Box(
           modifier = Modifier
               .background(DeepBlue)
               .padding(24.dp)
               .fillMaxSize()
       ) {
           LazyColumn(){
               item{
                   Header("Code", navController )
                   Spacer(modifier = Modifier.height(24.dp))
                   SearchField()
                   Spacer(modifier = Modifier.height(24.dp))
                   Text("New Animal", style = TextStyle(color = Color.Yellow,fontWeight = FontWeight.Bold), modifier = Modifier.padding(start = 110.dp))
                   Spacer(modifier = Modifier.height(14.dp))

               }
               items(AnimalsList.size){
                   item -> AnimalListItem(item = AnimalsList[item], onCardClick = {
                       item -> navController.navigate("details/${item.id}")
               } )
               }
           }
       }
    }
}
@Composable
fun Header(name: String ="Code",navController: NavController){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
        ) {
        IconButton(onClick ={navController.popBackStack() }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
        }
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text ="Greeting, $name",
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White,
                maxLines = 1
            )
            Text(
                text ="Chúng tôi sẽ chia sẻ niềm vui với bạn",
                style = MaterialTheme.typography.body1,
                color = Color.White,
                maxLines = 1
            )

        }
//        Icon(
//            painter = painterResource(id = R.drawable.ic_baseline_emoji_nature_24),
//            contentDescription ="Icon animal",
//            tint = Color.White,
//            modifier = Modifier
//                .size(32.dp)
////                .rotate(-45.0f)
//        )

    }
}

@Composable
fun SearchField(){
    val textFieldValue = remember { mutableStateOf("")}
    TextField(
        value = textFieldValue.value,
        onValueChange = {value -> textFieldValue.value = value},
        Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = Color.White,
        ),
        placeholder = {
            Text(
                text ="Name Animals",
                color = Color.White,
            )
        },
        maxLines = 1,
        leadingIcon =   {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "Search icon Button",
                tint = Color.White,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedLabelColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.White,
        )

    )
}
@Composable
fun AnimalListItem(item : AnimalsData, onCardClick : (AnimalsData) -> Unit){
    Card(
        backgroundColor = LightGray,
        modifier = Modifier
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(size = 8.dp))
            .background(LightBlue)
            .clickable(onClick = { onCardClick(item) }, enabled = true)
            .padding(2.dp),
        elevation = 0.dp
    ){
        Column(Modifier.padding(8.dp)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = Color.Gray),
               Alignment.Center
            ){
                Image(
                    painter = painterResource(id = item.imagePath),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                item.name,
                style = TextStyle(color = Color.White),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            )
            AnimalDetail(age = item.age, weight = item.weight )

        }
    }
}
@Composable
fun AnimalDetail(age: Int, weight: Double){
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            val year = if(age > 1) "Years" else "Year"
            Text("age", style = TextStyle(
                color = Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
            textAlign = TextAlign.Center
                 )
            Text("$age, $year", textAlign = TextAlign.Center, color = Color(0xFFdfdfdf))
        }

        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            val year = if(age > 1) "Years" else "Year"
            Text("weight", style = TextStyle(
                color = Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
                textAlign = TextAlign.Center
            )
            Text("$weight Kg", textAlign = TextAlign.Center, color = Color(0xFFdfdfdf))
        }
    }
}

