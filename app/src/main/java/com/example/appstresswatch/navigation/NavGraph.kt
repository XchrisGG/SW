package com.example.appstresswatch.navigation

import InfoScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appstresswatch.layouts.ChatScreen
import com.example.appstresswatch.layouts.HomeScreen
import com.example.appstresswatch.layouts.ImageScreen
import com.example.appstresswatch.layouts.LoginScreen
import com.example.appstresswatch.layouts.LoginScreen2
import com.example.appstresswatch.layouts.LogoScreen
import com.example.appstresswatch.layouts.NameScreen
import com.example.appstresswatch.layouts.PreViewInfo
import com.example.appstresswatch.layouts.ProfileScreen
import com.example.appstresswatch.layouts.SexScreen
import com.example.appstresswatch.layouts.UserScreen
import com.example.appstresswatch.session.SessionManager
import com.example.appstresswatch.viewModel.LoginViewModel
import com.example.appstresswatch.viewModels.RegisterViewModel

@Composable

fun NavGraph() {
    val navController = rememberNavController()
    val registerViewModel: RegisterViewModel = viewModel()
    val loginViewModel: LoginViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.LogoScreen.name
    ) {

        composable(Screens.LogoScreen.name) {
            LogoScreen(navController) // Esta sí recibe navController, está bien
        }

        composable(Screens.LoginScreen.name) {

            // AQUÍ USAS NAVCONTROLLER (sí se conserva)
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Screens.LoginScreen2.name)
                },
                onRegisterClick = {
                    navController.navigate(Screens.InfoScreen.name)
                },


                onRecoverPasswordClick = {
                    navController.navigate(Screens.LogoScreen.name)
                }
            )


        }

        composable(Screens.InfoScreen.name){
            InfoScreen(
                onBack = {
                    navController.navigate(Screens.LoginScreen.name)
                },

                onNext = {
                    navController.navigate(Screens.NameScreen.name)
                }

            )
        }

        composable (Screens.NameScreen.name){
            NameScreen(
                viewModel = registerViewModel,
                onBack = {
                    navController.navigate(Screens.InfoScreen.name)


                },

                onNext = {
                    navController.navigate(Screens.SexScreen.name)


                },

            )

        }

        composable (Screens.SexScreen.name){
            SexScreen(
                viewModel = registerViewModel,
                onBack = {
                    navController.navigate(Screens.NameScreen.name)


                },

                onNext = {
                    navController.navigate(Screens.UserScreen.name)


                },

            )

        }

        composable(Screens.UserScreen.name){
            UserScreen(
                viewModel = registerViewModel,
                onBack = {
                    navController.navigate(Screens.SexScreen.name)


                },

                onNext = {
                    navController.navigate(Screens.ImageScreen.name)


                },

            )

        }
        composable(Screens.ImageScreen.name){
            ImageScreen(
                viewModel = registerViewModel,
                onBack = {
                    navController.navigate(Screens.UserScreen.name)


                },

                onNext = {
                    navController.navigate(Screens.PreViewInfo.name)


                },

            )
        }
        composable(Screens.PreViewInfo.name) {
            PreViewInfo(
                viewModel = registerViewModel,
                onBack = {
                    navController.navigate(Screens.ImageScreen.name)


                },

                onNext = {
                    registerViewModel.registerUser(    onSuccess = {
                        // ejemplo: navegar a la pantalla Login
                        navController.navigate("login")
                    },
                        onError = { errorMessage ->
                            // ejemplo: mostrar un Snackbar con el error
                            println("ERROR: $errorMessage")
                        })

                    navController.navigate(Screens.UserScreen.name)


                },
                apellido = {
                    navController.navigate(Screens.NameScreen.name)


                },

                edad = {
                    navController.navigate(Screens.NameScreen.name)


                },
                sexo = {
                    navController.navigate(Screens.SexScreen.name)


                },

                fecha = {
                    navController.navigate(Screens.SexScreen.name)


                },
                pais = {
                    navController.navigate(Screens.SexScreen.name)


                },

                correo = {
                    navController.navigate(Screens.UserScreen.name)


                },
                ult = {
                    navController.navigate(Screens.UserScreen.name)


                },

            )
        }
        composable(Screens.LoginScreen2.name) {
            LoginScreen2(
                viewModel = loginViewModel,
                onBack = {
                    navController.popBackStack()
                },
                onLoginSuccess = { userId, token ->
                    SessionManager.userId = userId
                    SessionManager.token = token
                    navController.navigate(Screens.HomeScreen.name)
                }
            )
        }

        composable(Screens.HomeScreen.name) {
            HomeScreen(
                onChat = {
                    navController.navigate(Screens.ChatScreen.name)
                },
                onHome = {
                    navController.navigate(Screens.HomeScreen.name)
                },
                onProfile = {
                    navController.navigate(Screens.ProfileScreens.name)
                }
            )

        }
        composable(Screens.ChatScreen.name) {
            ChatScreen(

            )
        }
        composable (Screens.ProfileScreens.name){
            ProfileScreen(
                onChat = {
                    navController.navigate(Screens.ChatScreen.name)
                },
                onHome = {
                    navController.navigate(Screens.HomeScreen.name)
                },
                onProfile = {
                    navController.navigate(Screens.ProfileScreens.name)
                }

            )
        }
    }
}