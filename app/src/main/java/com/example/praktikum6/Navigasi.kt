package com.example.praktikum6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6.view.FormIsian
import com.example.praktikum6.view.TampilData

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold{isiRuang ->
    NavHost(
        NavController = navController,
        starDestination = Navigasi.FormulirSaya.name,

        modifier = Modifier.padding(isiRuang)
    ) {
        composable(route = Navigasi.FormulirSaya.name){
            FormIsian(
                OnSubmitBtnClick = {
                    navController.navigate(Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name){
            TampilData (
                onBackBtnClick = {cancelAndBackToFormulirSaya(navController)}
            )
        }
    }}
}

private fun cancelAndBackToFormulirSaya(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.FormulirSaya.name, inclusive = false)
}