package com.bleh.resqmeal.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.bleh.resqmeal.R
import com.bleh.resqmeal.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun SplashPage(
    navController: NavController
) {
    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )

    Image(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp),
        painter = painterResource(id = R.drawable.ic_resqmeal),
        contentDescription = "logo",
    )

    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()
        navController.navigate("intro1")
    }
}

@Composable
fun Intro1(
    navController: NavController
) {
    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (image, title, text, next) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.intro1),
            contentDescription = "image1",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Unggah Makananmu",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .padding(top = 20.dp, start = 40.dp, end = 40.dp)
                .constrainAs(text) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Unggah dan donasikan makananmu! Tiada lagi makanan yang terbuang sia-sia.",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .constrainAs(next) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_progress_1),
                contentDescription = "Progress 1"
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "Lewati",
                    style = MaterialTheme.typography.labelLarge,
                )

                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(70.dp)
                        .width(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
                    ),
                    onClick = {
                        navController.navigate("intro2")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = "right arrow",
                    )
                }
            }
        }
    }
}

@Composable
fun Intro2(
    navController: NavController
) {
    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (image, title, text, next) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.intro2),
            contentDescription = "image1",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Cari dan Dapatkan Makanan",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .padding(top = 20.dp, start = 40.dp, end = 40.dp)
                .constrainAs(text) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Cari dan dapatkan makanan yang kamu inginkan sekarang!",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .constrainAs(next) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_progress_2),
                contentDescription = "Progress 1"
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "Lewati",
                    style = MaterialTheme.typography.labelLarge,
                )

                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(70.dp)
                        .width(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
                    ),
                    onClick = {
                        navController.navigate("intro3")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = "right arrow",
                    )
                }
            }
        }
    }
}

@Composable
fun Intro3(
    navController: NavController
) {
    Image(
        modifier = Modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = "splash",
        contentScale = ContentScale.Crop
    )

    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (image, title, text, next) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.intro1),
            contentDescription = "image1",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Mulai",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .padding(top = 20.dp, start = 40.dp, end = 40.dp)
                .constrainAs(text) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = "Donasikan makananmu sekarang untuk selamatkan Bumi!",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .constrainAs(next) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_progress_3),
                contentDescription = "Progress 1"
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "Lewati",
                    style = MaterialTheme.typography.labelLarge,
                )

                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(70.dp)
                        .width(70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange
                    ),
                    onClick = {
                        navController.navigate("auth") {
                            popUpTo("onboarding") {
                                inclusive = true
                            }
                        }
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = "right arrow",
                    )
                }
            }
        }
    }
}