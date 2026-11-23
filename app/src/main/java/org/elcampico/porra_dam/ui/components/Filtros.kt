package org.elcampico.porra_dam.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.data.model.FiltroPronostico
import org.elcampico.porra_dam.data.model.TipoAcierto

// Pantalla Jornada: Todos / Pendientes / Rellenados
@Composable
fun FiltroPronosticos(filtro: FiltroPronostico, onFiltro: (FiltroPronostico) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FiltroPronostico.entries.forEach { f ->
            FilterChip(
                selected = filtro == f,
                onClick = { onFiltro(f) },
                label = { Text(f.etiqueta) }
            )
        }
    }
}

// Pantalla Resultados: Todos / Exactos / Signo / Fallos
@Composable
fun FiltroAcierto(filtro: TipoAcierto?, onFiltro: (TipoAcierto?) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = filtro == null,
            onClick = { onFiltro(null) },
            label = { Text("Todos") }
        )
        TipoAcierto.entries.forEach { tipo ->
            FilterChip(
                selected = filtro == tipo,
                onClick = { onFiltro(tipo) },
                label = { Text(tipo.etiqueta) }
            )
        }
    }
}

// Pantalla Clasificación: General / Jornada N
@Composable
fun FiltroJornadaChips(jornadas: List<Int>, filtro: Int?, onFiltro: (Int?) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = filtro == null,
            onClick = { onFiltro(null) },
            label = { Text("General") }
        )
        jornadas.forEach { n ->
            FilterChip(
                selected = filtro == n,
                onClick = { onFiltro(n) },
                label = { Text("Jornada $n") }
            )
        }
    }
}