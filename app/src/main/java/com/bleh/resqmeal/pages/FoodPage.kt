package com.bleh.resqmeal.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bleh.resqmeal.R
import com.bleh.resqmeal.components.FoodCard
import com.bleh.resqmeal.components.listOfFoods
import com.bleh.resqmeal.ui.theme.DarkGrey
import com.bleh.resqmeal.ui.theme.Grey
import com.bleh.resqmeal.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodPage(
    navController: NavController
) {
    Scaffold (
        topBar = {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Cari Makanan",
                        style = MaterialTheme.typography.titleLarge,
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "search"
                    )
                }
            }
        },
        bottomBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(color = Grey),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(360.dp))
                        .weight(1f)
                        .clickable {
                            navController.navigate("home")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "home",
                        tint = DarkGrey
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(360.dp))
                        .weight(1f)
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bowl),
                        contentDescription = "food",
                        tint = Orange
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(360.dp))
                        .weight(1f)
                        .clickable {
                            navController.navigate("add")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "add",
                        tint = DarkGrey
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(360.dp))
                        .weight(1f)
                        .clickable {
                            navController.navigate("profile")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "profile",
                        tint = DarkGrey
                    )
                }
            }
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 20.dp, end = 20.dp),
        ) {
            listOfFoods.forEach() {
                item {
                    FoodCard(
                        modifier = Modifier
                            .padding(top = 20.dp),
                        image = it.image,
                        title = it.title,
                        weight = it.weight,
                        distance = it.distance,
                    )
                }
            }
        }
    }
}