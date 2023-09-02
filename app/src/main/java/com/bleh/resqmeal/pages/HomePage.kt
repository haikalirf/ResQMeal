package com.bleh.resqmeal.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bleh.resqmeal.R
import com.bleh.resqmeal.components.FoodCard
import com.bleh.resqmeal.components.listOfFoods
import com.bleh.resqmeal.ui.theme.DarkGrey
import com.bleh.resqmeal.ui.theme.Grey
import com.bleh.resqmeal.ui.theme.LightOrange
import com.bleh.resqmeal.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navController: NavController
) {
    Scaffold (
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

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "home",
                        tint = Orange
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(360.dp))
                        .weight(1f)
                        .clickable {
                            navController.navigate("food")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bowl),
                        contentDescription = "food",
                        tint = DarkGrey
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
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.topbar),
                    contentDescription = "topbar",
                    contentScale = ContentScale.FillWidth,
                )

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .padding(horizontal = 20.dp),
                        text = "Halo, Taylor Swift!",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Terima tawaran makanan atau\n" +
                                "unggah makananmu di ResQmeal!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .padding(horizontal = 20.dp),
                text = "Ambil Tawaran Makanan di Sekitarmu!",
                style = MaterialTheme.typography.titleSmall,
            )

            LazyRow(
                modifier = Modifier
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    if (listOfFoods.size < 3) {
                        listOfFoods.forEach() {
                            item {
                                FoodCard(
                                    modifier = Modifier,
                                    image = it.image,
                                    title = it.title,
                                    weight = it.weight,
                                    distance = it.distance,
                                )
                            }
                        }
                    } else {
                        for (i in 0..2) {
                            item {
                                FoodCard(
                                    modifier = Modifier,
                                    image = listOfFoods[i].image,
                                    title = listOfFoods[i].title,
                                    weight = listOfFoods[i].weight,
                                    distance = listOfFoods[i].distance,
                                )
                            }
                        }
                        item {
                            Image(
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .width(40.dp)
                                    .height(40.dp)
                                    .clip(RoundedCornerShape(360.dp))
                                    .clickable {
                                        navController.navigate("food")
                                    },
                                painter = painterResource(id = R.drawable.ic_next_food),
                                contentDescription = "next",
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }
            )

            Card(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(180.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxHeight(),
                        painter = painterResource(id = R.drawable.cool_bread),
                        contentDescription = "food",
                        contentScale = ContentScale.FillHeight,
                    )

                    Column (
                        modifier = Modifier
                            .padding(start = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Calzone",
                            style = MaterialTheme.typography.titleMedium,
                        )

                        Row (
                            modifier = Modifier
                                .padding(top = 5.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                painter = painterResource(id = R.drawable.jomok),
                                contentDescription = "location",
                                contentScale = ContentScale.FillHeight,
                            )

                            Text(
                                modifier = Modifier.padding(start = 5.dp),
                                text = "Niall Horan",
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }

                        Text(
                            text = "27 Agustus 2023, 15.23",
                            style = MaterialTheme.typography.labelMedium,
                        )

                        Image(
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .height(16.dp),
                            painter = painterResource(id = R.drawable.stars),
                            contentDescription = "stars",
                            contentScale = ContentScale.FillHeight,
                        )

                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .height(50.dp)
                                .fillMaxWidth()
                                .padding(end = 20.dp)
                                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 5.dp)
                                    .padding(top = 5.dp),
                                text = "Tulis ulasan anda",
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                    }
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp),
                text = "Yuk, cari tahu tentang Food Waste!",
                style = MaterialTheme.typography.titleSmall,
            )

            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                text = "Ada beberapa artikel yang bisa kamu lihat seputar food waste yang menambah wawasan kamu.",
                style = MaterialTheme.typography.bodySmall,
            )

            Card(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 10.dp)
                    .background(Color.White)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        painter = painterResource(id = R.drawable.fries),
                        contentDescription = "fries",
                        contentScale = ContentScale.FillWidth,
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(vertical = 5.dp),
                        text = "Steps Dalam Mengurai Food Waste",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }

            Card(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 10.dp)
                    .background(Color.White)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        painter = painterResource(id = R.drawable.uk_breakfast),
                        contentDescription = "fries",
                        contentScale = ContentScale.FillWidth,
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(vertical = 5.dp),
                        text = "Perbedaan Food Loss dan Food Waste",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}