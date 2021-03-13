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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

val KulimParkFamily = FontFamily(
    Font(R.font.kulim_park),
    Font(R.font.kulim_park_light, weight = FontWeight.Light)
)
val LatoFamily = FontFamily(
    Font(R.font.lato),
    Font(R.font.lato_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = KulimParkFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.115.em
    ),
    h2 = TextStyle(
        fontFamily = KulimParkFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.115.em,
    ),
    h3 = TextStyle(
        fontFamily = LatoFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.em
    ),
    body1 = TextStyle(
        fontFamily = LatoFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.em
    ),
    button = TextStyle(
        fontFamily = LatoFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.115.em
    ),
    caption = TextStyle(
        fontFamily = KulimParkFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.115.em
    )
)
