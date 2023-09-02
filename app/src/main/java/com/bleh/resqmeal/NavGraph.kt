package com.bleh.resqmeal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.bleh.resqmeal.pages.AddPage
import com.bleh.resqmeal.pages.FoodPage
import com.bleh.resqmeal.pages.ForgotPage
import com.bleh.resqmeal.pages.HomePage
import com.bleh.resqmeal.pages.Intro1
import com.bleh.resqmeal.pages.Intro2
import com.bleh.resqmeal.pages.Intro3
import com.bleh.resqmeal.pages.LoginPage
import com.bleh.resqmeal.pages.ProfilePage
import com.bleh.resqmeal.pages.RegisterPage
import com.bleh.resqmeal.pages.SplashPage

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost (
        navController = navController,
        startDestination = "onboarding"
    ) {
        navigation(
            startDestination = "splash",
            route = "onboarding"
        ) {
            composable("splash") {
                SplashPage(navController)
            }
            composable("intro1") {
                Intro1(navController)
            }
            composable("intro2") {
                Intro2(navController)
            }
            composable("intro3") {
                Intro3(navController)
            }
        }

        navigation(
            startDestination = "login",
            route = "auth"
        ) {
            composable("login") {
                LoginPage(navController)
            }
            composable("register") {
                RegisterPage(navController)
            }
            composable("forgot") {
                ForgotPage(navController)
            }
        }

        navigation(
            startDestination = "home",
            route = "main"
        ) {
            composable("home") {
                HomePage(navController)
            }
            composable("food") {
                FoodPage(navController)
            }
            composable("add") {
                AddPage(navController)
            }
            composable("profile") {
                ProfilePage(navController)
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}