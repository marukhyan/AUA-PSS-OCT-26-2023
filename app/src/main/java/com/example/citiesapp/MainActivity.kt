package com.example.citiesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.citiesapp.ui.theme.CitiesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Screen1") {
                composable(
                    route = "Screen1",
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription=null,
                        modifier = Modifier.clickable {
                            navController.navigate(route = "Screen2")
                        }
                    )
                }
                composable(
                    route = "Screen2",
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription=null,
                        modifier = Modifier.clickable {
                            navController.navigate(route = "Screen1")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CustomNavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen1") {
        composable(
            route = "Screen1",
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription=null,
                modifier = Modifier.clickable {
                    navController.navigate(route = "Screen2")
                }
            )
        }
        composable(
            route = "Screen2",
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription=null,
                modifier = Modifier.clickable {
                    navController.navigate(route = "Screen1")
                }
            )
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CitiesAppTheme {
        Greeting("Android")
    }
}