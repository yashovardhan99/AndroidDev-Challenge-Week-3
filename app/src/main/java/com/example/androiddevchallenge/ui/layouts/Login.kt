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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = "Background"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Log in".toUpperCase(Locale.getDefault()),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.paddingFromBaseline(top = 200.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = "Email address", onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    textColor = MaterialTheme.colors.onSurface
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "Password", onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    textColor = MaterialTheme.colors.onSurface
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            val string = AnnotatedString.Builder().apply {
                val str = "Don't have an account? Sign up"
                append(str)
                addStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    ),
                    start = str.indexOf("Sign up"), end = str.lastIndex
                )
            }.toAnnotatedString()
            LoginButton()
            Text(
                text = string,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.paddingFromBaseline(top = 32.dp)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginPreview() {
    MyTheme(darkTheme = false) {
        Surface() {
            LoginScreen()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewDark() {
    MyTheme(darkTheme = true) {
        Surface() {
            LoginScreen()
        }
    }
}
