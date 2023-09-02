package com.bleh.resqmeal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bleh.resqmeal.R
import com.bleh.resqmeal.ui.theme.LightOrange
import com.bleh.resqmeal.ui.theme.Orange

@Composable
fun FoodCard(
    modifier: Modifier,
    image: Int,
    title: String,
    weight: String,
    distance: String,
) {
    Card(
        modifier = modifier
            .defaultMinSize(minHeight = 180.dp, minWidth = 150.dp)
            .width(160.dp)
            .height(190.dp)
            .padding(start = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightOrange),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(MaterialTheme.shapes.medium),
                painter = painterResource(id = image),
                contentDescription = title,
                contentScale = ContentScale.FillWidth,
            )
            
            Text(
                modifier = Modifier.padding(horizontal = 10.dp)
                    .padding(top = 10.dp),
                text = title,
                style = MaterialTheme.typography.bodyMedium,
            )
            
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = weight,
                style = MaterialTheme.typography.bodySmall,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.padding(horizontal = 10.dp)
                    .padding(bottom = 10.dp),
                text = distance,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}