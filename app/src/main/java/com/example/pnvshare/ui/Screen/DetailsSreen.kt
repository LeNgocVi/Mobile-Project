package com.example.pnvshare.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pnvshare.data.AnimalsData
import com.example.pnvshare.ui.theme.DeepBlue
import com.example.pnvshare.ui.theme.LightPurple

@Composable
fun DetailsScreen(navController: NavController, animalsData : AnimalsData){
   Scaffold(
      topBar = {
         TopAppBar(

            navigationIcon = {
               IconButton(onClick ={navController.popBackStack() }) {
                  Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
               }
            },
            modifier = Modifier.height(68.dp),
            title = { Text(text = "Puppies", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) },
            actions = { IconButton(onClick = { /*TODO*/ }) {
               Icon(imageVector = Icons.Filled.Favorite , contentDescription = null, tint = Color.White)
            }},
            elevation = 0.dp,
            backgroundColor = DeepBlue,
            contentColor = Color.White,
         )
      },
      // Create button App Bar
      bottomBar = {
         Row(Modifier.padding(1.dp)) {
            Button(
               onClick = {},
               Modifier
                  .fillMaxWidth()
                  .height(53.dp),
               colors = ButtonDefaults.buttonColors(backgroundColor = LightPurple),
               elevation = ButtonDefaults.elevation(0.dp)
               ) {
               Text("Nhận nuôi", style = MaterialTheme.typography.h5, color = Color.White)
            }
         }
      },
      backgroundColor = DeepBlue,
      contentColor = Color.White
   ) {
      Body(Modifier.padding(16.dp) , animalsData = animalsData)
      }
}
@Composable
fun Body(modifier: Modifier, animalsData: AnimalsData){
   Column(modifier = modifier) {
      Box(
         modifier
            .fillMaxWidth()
            .height(280.dp)
            .clip(shape = RoundedCornerShape(8.dp))
      ){
         Image(painter = painterResource(id = animalsData.imagePath), contentDescription =null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize() )
      }
      Spacer(modifier = Modifier.height(12.dp))
      Text(animalsData.name, style = MaterialTheme.typography.h4, modifier = Modifier.padding(start = 130.dp), color = Color.Red)
      Spacer(modifier = Modifier.height(12.dp))
      Row(
         Modifier.fillMaxWidth(),
         horizontalArrangement = Arrangement.SpaceBetween,
      ){
         val mod = Modifier
            .clip(shape = RoundedCornerShape(size = 15.dp))
            .weight(1f)
            .background(LightPurple)
            .padding(all = 8.dp)
         DetailBox(title = "Gender", info = "${animalsData.sex}", mod)
         Spacer(modifier = Modifier.height(6.dp))
         DetailBox(title = "Age", info = "${animalsData.age}", mod)
         Spacer(modifier = Modifier.height(6.dp))
         DetailBox(title = "Weight", info = "${animalsData.weight}", mod)
         Spacer(modifier = Modifier.height(6.dp))

      }
      Spacer(modifier = Modifier.height(12.dp))
      Text("Sumary", style = MaterialTheme.typography.h4,modifier = Modifier.padding(start = 110.dp), color = Color.Yellow)
      Spacer(modifier = Modifier.height(6.dp))
      Text("Tôi yêu cuộc sống này", style = MaterialTheme.typography.body2,modifier = Modifier.padding(start = 110.dp), color = Color.Yellow)

   }
}
@Composable
fun DetailBox(title: String, info:String, modifier: Modifier = Modifier){
   Box(modifier = modifier){
      Column() {
         Text(text = title, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
         Text(text = info, Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

      }
   }
}