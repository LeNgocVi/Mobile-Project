package com.example.pnvshare.data

import com.example.pnvshare.R


data class AnimalsData(
    val id: Int,
    val name:String,
    val sex:String,
    val age:Int,
    val weight:Double,
    val imagePath:Int

    )
// Display list data
var AnimalsList = mutableListOf<AnimalsData>(
    AnimalsData(0,"Lula","Male",2,2.4, R.drawable.dog1),
    AnimalsData(1,"MiNa","Male",1,3.3, R.drawable.dog2),
    AnimalsData(2,"Goga","Male",3,1.2, R.drawable.cat1),
    AnimalsData(3,"LuNa","Female",2,1.5, R.drawable.cat2),
    AnimalsData(4,"XuXi","Male",2,3.2, R.drawable.dog3),
    AnimalsData(5,"VaiDi","Female",4,4.6, R.drawable.dog4),
    AnimalsData(6,"JaBa","Male",2,1.3, R.drawable.cat3),
    AnimalsData(7,"FaKe","Female",1,1.1, R.drawable.cat4),
    AnimalsData(8,"NuHo","Male",2,5.1, R.drawable.dog5),
    AnimalsData(9,"KuTo","Female",1,4.3, R.drawable.dog6),
    AnimalsData(10,"KoLi","Male",3,1.6, R.drawable.cat5),
    AnimalsData(11,"DuDa","Female",2,1.0, R.drawable.cat6),

)