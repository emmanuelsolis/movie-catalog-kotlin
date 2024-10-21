package com.emmanuel.movie_catalog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.emmanuel.movie_catalog.ui.theme.MoviecatalogTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviecatalogTheme {
                Scaffold(
                    topBar = { MovieCatalogTopAppBar() }
                ) { innerPadding ->
                    WelcomeMessage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCatalogTopAppBar() {
    TopAppBar(
        title = { Text("Welcome to Compose") }, // Use Text composable for title
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White
        )
    )
}

@Composable
public fun WelcomeMessage(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World",
            color = Color.Black,
            style = MaterialTheme.typography.headlineMedium // Example using typography
        )
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    MoviecatalogTheme {
        Scaffold(
            topBar = { MovieCatalogTopAppBar() }
        ) { innerPadding ->
            WelcomeMessage(modifier = Modifier.padding(innerPadding))
        }
    }
}