package org.elcampico.porra_dam.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.elcampico.porra_dam.screens.Jornada
import org.elcampico.porra_dam.screens.PantallaBienvenida

@OptIn(ExperimentalMaterial3Api::class) // <- Añade esta anotación
@Composable
fun PantallaPrincipal(alias: String, modifier: Modifier = Modifier){
    var pestana by rememberSaveable { mutableStateOf(Pestanas.JORNADA) }

    BackHandler(enabled = pestana != Pestanas.JORNADA) {
        pestana = Pestanas.JORNADA
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar {
                Pestanas.entries.forEach { p ->
                    NavigationBarItem(
                        selected = pestana == p,
                        onClick = { pestana = p },
                        icon = { Icon(imageVector = p.icono, contentDescription = null) },
                        label = { Text(p.titulo) }
                    )
                }
            }
        }
    )
    {
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when(pestana){
                Pestanas.JORNADA -> Jornada() // Muestra la pantalla Jornada.kt
                Pestanas.CLASIFICACION -> {}
            }
        }
    }
}