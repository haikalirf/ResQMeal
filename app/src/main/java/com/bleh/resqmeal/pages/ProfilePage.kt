package com.bleh.resqmeal.pages

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bleh.resqmeal.R
import com.bleh.resqmeal.ui.theme.DarkGrey
import com.bleh.resqmeal.ui.theme.Grey
import com.bleh.resqmeal.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(
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

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "profile",
                        tint = Orange
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Profil",
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 20.dp),
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "profile image"
                )

                Column(
                    modifier = Modifier
                ) {
                    Row (
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "taylorswift17",
                            style = MaterialTheme.typography.titleSmall,
                        )

                        Icon(
                            modifier = Modifier,
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "edit button",
                            tint = Color.Black
                        )
                    }

                    Text(
                        modifier = Modifier,
                        text = "Taylor Swift",
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Text(
                        modifier = Modifier,
                        text = "Malang, Jawa Timur, Indonesia",
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Text(
                        modifier = Modifier,
                        text = "Info makan dik adik",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Riwayat Makanan yang Diunggah",
                style = MaterialTheme.typography.titleSmall
            )

            Card(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(300.dp)
                    .border(1.dp, Orange, RoundedCornerShape(10.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(130.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.drawable.pasta),
                            contentDescription = "pasta"
                        )

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Pasta",
                                    style = MaterialTheme.typography.titleSmall,
                                )

                                Text(
                                    text = "29 Agustus 2023",
                                    style = MaterialTheme.typography.bodySmall,
                                )
                            }

                            Text(
                                modifier = Modifier,
                                text = "500 gram",
                                style = MaterialTheme.typography.bodySmall,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Pasta kering belum terpakai",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                            .padding(horizontal = 10.dp),
                        color = Color.Black
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(130.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.drawable.risol),
                            contentDescription = "ril"
                        )

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Risol Frozen",
                                    style = MaterialTheme.typography.titleSmall,
                                )

                                Text(
                                    text = "25 Agustus 2023",
                                    style = MaterialTheme.typography.bodySmall,
                                )
                            }

                            Text(
                                modifier = Modifier,
                                text = "10 buah",
                                style = MaterialTheme.typography.bodySmall,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Risol frozen yang dapat digoreng",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Riwayat Menerima Tawaran Makanan",
                style = MaterialTheme.typography.titleSmall
            )

            Card(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(300.dp)
                    .border(1.dp, Orange, RoundedCornerShape(10.dp))
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(130.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.drawable.pasta),
                            contentDescription = "pasta"
                        )

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Pasta",
                                    style = MaterialTheme.typography.titleSmall,
                                )

                                Text(
                                    text = "15 Juli 2023",
                                    style = MaterialTheme.typography.bodySmall,
                                )
                            }

                            Text(
                                modifier = Modifier,
                                text = "500 gram",
                                style = MaterialTheme.typography.bodySmall,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Pasta kering belum terpakai",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                            .padding(horizontal = 10.dp),
                        color = Color.Black
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(130.dp)
                                .padding(start = 20.dp),
                            painter = painterResource(id = R.drawable.risol),
                            contentDescription = "ril"
                        )

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Risol Frozen",
                                    style = MaterialTheme.typography.titleSmall,
                                )

                                Text(
                                    text = "4 Juni 2023",
                                    style = MaterialTheme.typography.bodySmall,
                                )
                            }

                            Text(
                                modifier = Modifier,
                                text = "10 buah",
                                style = MaterialTheme.typography.bodySmall,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Risol frozen yang dapat digoreng",
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}