/*
 * Copyright 2021 Yashovardhan Dhanania
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.layouts

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.Locale

@Composable
fun SearchBox() {
    TextField(
        value = "Search", onValueChange = { },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp)
    )
}

@Composable
fun CollectionBox(image: Images) {
    Row(
        modifier = Modifier.size(192.dp, 56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = image.url, modifier = Modifier.size(56.dp),
            contentDescription = image.title,
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = image.title, style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun ImageRowBox(image: Images) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CoilImage(
            data = image.url, modifier = Modifier.size(88.dp),
            contentDescription = image.title,
            requestBuilder = {
                transformations(CircleCropTransformation())
            }
        )
        Text(
            text = image.title, style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp),
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
fun HomePage() {
    val scrollState = ScrollState(0)
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBox()
        Text(
            text = "Favorite Collections".toUpperCase(Locale.getDefault()),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                listOf(
                    Images.ShortMantras to Images.NatureMeditations,
                    Images.StressAndAnxiety to Images.SelfMassage,
                    Images.Overwhelmed to Images.NightlyWindDown
                )
            ) { item ->
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    CollectionBox(image = item.first)
                    CollectionBox(image = item.second)
                }
            }
        }
        Text(
            text = "Align your body".toUpperCase(Locale.getDefault()),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                listOf(
                    Images.Inversions,
                    Images.QuickYoga,
                    Images.Stretching,
                    Images.Tabata,
                    Images.Hiit,
                    Images.PreNatal
                )
            ) { item ->
                ImageRowBox(image = item)
            }
        }
        Text(
            text = "Align your mind".toUpperCase(Locale.getDefault()),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                listOf(
                    Images.Meditate,
                    Images.WithKids,
                    Images.Aromatherapy,
                    Images.OnTheGo,
                    Images.WithPets,
                    Images.HighStress
                )
            ) { item ->
                ImageRowBox(image = item)
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePagePreview() {
    MyTheme(false) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            HomePage()
        }
    }
}

sealed class Images(val title: String, val url: String) {
    object ShortMantras : Images("Short mantras", "https://www.pexels.com/photo/1825206/download")
    object NatureMeditations :
        Images("Nature Meditations", "https://www.pexels.com/photo/3571551/download/")

    object StressAndAnxiety :
        Images("Stress and anxiety", "https://www.pexels.com/photo/1557238/download/")

    object SelfMassage : Images("Self-massage", "https://www.pexels.com/photo/1029604/download/")
    object Overwhelmed : Images("Overwhelmed", "https://www.pexels.com/photo/3560044/download/")
    object NightlyWindDown :
        Images("Nightly wind down", "https://www.pexels.com/photo/924824/download/")

    object Inversions : Images("Inversions", "https://www.pexels.com/photo/317157/download/")
    object QuickYoga : Images("Quick yoga", "https://www.pexels.com/photo/1812964/download/")
    object Stretching : Images("Stretching", "https://www.pexels.com/photo/4056723/download/")
    object Tabata : Images("Tabata", "https://www.pexels.com/photo/4662438/download/")
    object Hiit : Images("HIIT", "https://www.pexels.com/photo/999309/download/")
    object PreNatal : Images("Pre natal yoga", "https://www.pexels.com/photo/396133/download/")
    object Meditate : Images("Meditate", "https://www.pexels.com/photo/3822622/download/")
    object WithKids : Images("With Kids", "https://www.pexels.com/photo/3094230/download/")
    object Aromatherapy : Images("Aromatherapy", "https://www.pexels.com/photo/4498318/download/")
    object OnTheGo : Images("On the go", "https://www.pexels.com/photo/1241348/download/")
    object WithPets : Images("With pets", "https://www.pexels.com/photo/4056535/download/")
    object HighStress : Images("High stress", "https://www.pexels.com/photo/897817/download/")
}
