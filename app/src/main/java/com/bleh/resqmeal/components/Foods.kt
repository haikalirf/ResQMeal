package com.bleh.resqmeal.components

import com.bleh.resqmeal.R

data class Food (
    val title: String = "",
    val weight: String = "",
    val distance: String = "",
    val image: Int = 0
)

val listOfFoods = listOf<Food>(
    Food(
        title = "Wortel",
        weight = "500 gram",
        distance = "0.2 km",
        image = R.drawable.carrots
    ),
    Food(
        title = "Roti Tawar",
        weight = "300 gram",
        distance = "1.2 km",
        image = R.drawable.bread
    ),
    Food(
        title = "Tomat",
        weight = "500 gram",
        distance = "0.8 km",
        image = R.drawable.tomato
    ),
    Food(
        title = "Madu",
        weight = "500 ml",
        distance = "2.1 km",
        image = R.drawable.honey
    ),
    Food(
        title = "Keju",
        weight = "1 kg",
        distance = "0.5 km",
        image = R.drawable.cheese
    ),
    Food(
        title = "Susu Bubuk",
        weight = "200 gram",
        distance = "2 km",
        image = R.drawable.powdered_milk
    ),
    Food(
        title = "Baguette",
        weight = "250 gram",
        distance = "2.3 km",
        image = R.drawable.baguette
    ),
    Food(
        title = "Calzone",
        weight = "500 ml",
        distance = "3.4 km",
        image = R.drawable.calzone
    ),
    Food(
        title = "Nanas",
        weight = "1.5 kg",
        distance = "0.5 km",
        image = R.drawable.pineapple
    ),
    Food(
        title = "Fresh Milk",
        weight = "1 liter",
        distance = "2 km",
        image = R.drawable.milk
    ),
)