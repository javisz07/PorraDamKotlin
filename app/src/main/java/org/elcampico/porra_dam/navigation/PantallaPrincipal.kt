package org.elcampico.porra_dam.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import org.elcampico.porra_dam.data.leerJornadas
import org.elcampico.porra_dam.data.leerParticipantes
import org.elcampico.porra_dam.data.leerPartidos
import org.elcampico.porra_dam.data.leerPronosticos
import org.elcampico.porra_dam.screens.Clasificacion
import org.elcampico.porra_dam.screens.Jornada
import org.elcampico.porra_dam.screens.Resultados
import org.elcampico.porra_dam.viewmodel.ClasificacionViewModel
import org.elcampico.porra_dam.viewmodel.PorraViewModel

@Composable
fun PantallaPrincipal(alias: String, modifier: Modifier = Modifier) {
    var pestana by rememberSaveable { mutableStateOf(Pestanas.JORNADA) }

    val contexto = LocalContext.current
    val porraVm: PorraViewModel = viewModel()
    val clasifVm: ClasificacionViewModel = viewModel()

    LaunchedEffect(Unit) {
        porraVm.cargar(leerJornadas(contexto), leerPartidos(contexto), leerPronosticos(contexto))
        clasifVm.cargar(leerParticipantes(contexto))
    }

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
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (pestana) {
                Pestanas.JORNADA -> Jornada(vm = porraVm)
                Pestanas.RESULTADOS -> Resultados(vm = porraVm)
                Pestanas.CLASIFICACION -> Clasificacion(alias = alias, clasifVm = clasifVm, porraVm = porraVm)
            }
        }
    }
}