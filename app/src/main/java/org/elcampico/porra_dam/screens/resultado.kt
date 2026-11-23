package org.elcampico.porra_dam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.data.Escudos
import org.elcampico.porra_dam.data.model.FilaResultado
import org.elcampico.porra_dam.data.model.TipoAcierto
import org.elcampico.porra_dam.ui.components.CabeceraPorra
import org.elcampico.porra_dam.ui.components.FiltroAcierto
import org.elcampico.porra_dam.ui.components.FondoPantalla
import org.elcampico.porra_dam.ui.theme.Grotesk
import org.elcampico.porra_dam.viewmodel.PorraViewModel

@Composable
fun Resultados(vm: PorraViewModel, modifier: Modifier = Modifier) {
    var menuAbierto by remember { mutableStateOf(false) }
    val jornada = vm.jornadaResultados

    FondoPantalla(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
            CabeceraPorra(puntos = vm.puntosTotales)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 15.dp),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA))
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Resultados", fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = Grotesk)

                        // Selector de jornada (solo jornadas ya jugadas)
                        Box {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                                    .clickable { menuAbierto = true }
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    if (jornada != null) "Jornada $jornada" else "Sin jornadas",
                                    fontSize = 14.sp,
                                    fontFamily = Grotesk,
                                    color = Color.DarkGray
                                )
                                Icon(
                                    painter = painterResource(R.drawable.ic_bajar),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(16.dp)
                                        .padding(start = 4.dp),
                                    tint = Color.DarkGray
                                )
                            }
                            DropdownMenu(expanded = menuAbierto, onDismissRequest = { menuAbierto = false }) {
                                vm.jornadasJugadas.forEach { n ->
                                    DropdownMenuItem(
                                        text = { Text("Jornada $n") },
                                        onClick = {
                                            vm.elegirJornada(n)
                                            menuAbierto = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Text(
                        "Resultados oficiales y puntos obtenidos",
                        fontSize = 14.sp,
                        fontFamily = Grotesk,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                            .padding(horizontal = 24.dp)
                    )

                    FiltroAcierto(
                        filtro = vm.filtroAcierto,
                        onFiltro = vm::filtrarAcierto,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
                    )

                    LazyColumn(modifier = Modifier.weight(1f)) {
                        items(vm.filasResultados, key = { it.partido.id }) { fila ->
                            _ResultadoFila(fila)
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F3F4)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(0xFFFFC107),
                                    modifier = Modifier.size(28.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    "Total jornada",
                                    fontSize = 16.sp,
                                    fontFamily = Grotesk,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Text(
                                "+${vm.puntosPorJornada[jornada] ?: 0} pts",
                                fontSize = 22.sp,
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1E8E3E)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun _ResultadoFila(fila: FilaResultado) {
    val partido = fila.partido
    val (colorFondo, colorTexto) = when (fila.acierto) {
        TipoAcierto.EXACTO -> Color(0xFFE6F4EA) to Color(0xFF1E8E3E)
        TipoAcierto.SIGNO -> Color(0xFFF1F3F4) to Color(0xFF5F6368)
        TipoAcierto.FALLO -> Color(0xFFFCE8E6) to Color(0xFFD93025)
    }
    val puntosTexto = if (fila.acierto.puntos > 0) "+${fila.acierto.puntos}" else "0"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                _LineaEquipo(partido.escudoLocal, partido.local, partido.golesLocal ?: 0)
                Spacer(modifier = Modifier.height(8.dp))
                _LineaEquipo(partido.escudoVisitante, partido.visitante, partido.golesVisitante ?: 0)
                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .padding(start = 36.dp)
                        .background(colorFondo, shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        "Tu porra: ${fila.pronostico.golesLocal} - ${fila.pronostico.golesVisitante}",
                        fontFamily = Grotesk,
                        fontSize = 11.sp,
                        color = colorTexto,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(width = 50.dp, height = 40.dp)
                    .background(colorFondo, shape = RoundedCornerShape(8.dp))
            ) {
                Text(
                    puntosTexto,
                    fontFamily = Grotesk,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = colorTexto
                )
            }
        }
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFE0E0E0))
    }
}

@Composable
private fun _LineaEquipo(escudo: String, nombre: String, goles: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(Escudos.id(escudo)),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            nombre,
            fontFamily = Grotesk,
            fontSize = 14.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )
        Text(
            goles.toString(),
            fontFamily = Grotesk,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}