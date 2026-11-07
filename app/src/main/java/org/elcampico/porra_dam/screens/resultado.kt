package org.elcampico.porra_dam.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.components.FondoPantalla
import org.elcampico.porra_dam.ui.theme.Grotesk

@Composable
fun Resultados(modifier: Modifier = Modifier) {
    FondoPantalla(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
            // Cabecera superior
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_menu),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )

                Text(
                    "Porra DAM",
                    fontSize = 30.sp,
                    fontFamily = Grotesk,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Card(
                    modifier = Modifier
                        .height(28.dp)
                        .width(60.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFc7ead6)
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text("38 ", fontWeight = FontWeight.Bold, color = Color.White)
                        Text("pts", fontWeight = FontWeight.Bold, color = Color(0xFF3A9D08))
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 15.dp),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF8F9FA)
                )
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Resultados",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Grotesk
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                "Jornada 1",
                                fontSize = 14.sp,
                                fontFamily = Grotesk,
                                color = Color.DarkGray
                            )
                            Icon(
                                painter = painterResource(R.drawable.ic_bajar),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp).padding(start = 4.dp),
                                tint = Color.DarkGray
                            )
                        }
                    }

                    Text(
                        "Resultados oficiales y puntos obtenidos",
                        fontSize = 14.sp,
                        fontFamily = Grotesk,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp, bottom = 16.dp).padding(horizontal = 24.dp)
                    )

                    LazyColumn(modifier = Modifier.weight(1f)) {
                        item {
                            _ResultadoFila(
                                escudoLocal = R.drawable.atletico_madrid, nombreLocal = "Atlético Madrid", golesLocal = 2,
                                escudoVisitante = R.drawable.real_madrid, nombreVisitante = "Real Madrid", golesVisitante = 1,
                                porraLocal = 2, porraVisitante = 1,
                                puntosTexto = "+8",
                                colorFondo = Color(0xFFE6F4EA),
                                colorTexto = Color(0xFF1E8E3E)
                            )

                            _ResultadoFila(
                                escudoLocal = R.drawable.atletico_madrid, nombreLocal = "Atlético Madrid", golesLocal = 3,
                                escudoVisitante = R.drawable.real_madrid, nombreVisitante = "Real Madrid", golesVisitante = 0,
                                porraLocal = 2, porraVisitante = 0,
                                puntosTexto = "+4",
                                colorFondo = Color(0xFFF1F3F4),
                                colorTexto = Color(0xFF5F6368)
                            )

                            _ResultadoFila(
                                escudoLocal = R.drawable.atletico_madrid, nombreLocal = "Atlético Madrid", golesLocal = 2,
                                escudoVisitante = R.drawable.real_madrid, nombreVisitante = "Real Madrid", golesVisitante = 1,
                                porraLocal = 1, porraVisitante = 1,
                                puntosTexto = "0",
                                colorFondo = Color(0xFFFCE8E6),
                                colorTexto = Color(0xFFD93025)
                            )
                            _ResultadoFila(
                                escudoLocal = R.drawable.atletico_madrid, nombreLocal = "Atlético Madrid", golesLocal = 2,
                                escudoVisitante = R.drawable.real_madrid, nombreVisitante = "Real Madrid", golesVisitante = 1,
                                porraLocal = 2, porraVisitante = 1,
                                puntosTexto = "+8",
                                colorFondo = Color(0xFFE6F4EA),
                                colorTexto = Color(0xFF1E8E3E)
                            )

                            _ResultadoFila(
                                escudoLocal = R.drawable.atletico_madrid, nombreLocal = "Atlético Madrid", golesLocal = 3,
                                escudoVisitante = R.drawable.real_madrid, nombreVisitante = "Real Madrid", golesVisitante = 0,
                                porraLocal = 2, porraVisitante = 0,
                                puntosTexto = "+4",
                                colorFondo = Color(0xFFF1F3F4),
                                colorTexto = Color(0xFF5F6368)
                            )

                            _ResultadoFila(
                                escudoLocal = R.drawable.atletico_madrid, nombreLocal = "Atlético Madrid", golesLocal = 2,
                                escudoVisitante = R.drawable.real_madrid, nombreVisitante = "Real Madrid", golesVisitante = 1,
                                porraLocal = 1, porraVisitante = 1,
                                puntosTexto = "0",
                                colorFondo = Color(0xFFFCE8E6),
                                colorTexto = Color(0xFFD93025)
                            )
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
                                "+22 pts",
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
fun _ResultadoFila(
    escudoLocal: Int, nombreLocal: String, golesLocal: Int,
    escudoVisitante: Int, nombreVisitante: String, golesVisitante: Int,
    porraLocal: Int, porraVisitante: Int,
    puntosTexto: String,
    colorFondo: Color,
    colorTexto: Color
) {
    Column(modifier = Modifier
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(escudoLocal),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        nombreLocal,
                        fontFamily = Grotesk,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f).padding(start = 12.dp)
                    )
                    Text(
                        golesLocal.toString(),
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(escudoVisitante),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        nombreVisitante,
                        fontFamily = Grotesk,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f).padding(start = 12.dp)
                    )
                    Text(
                        golesVisitante.toString(),
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .padding(start = 36.dp)
                        .background(colorFondo, shape = RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        "Tu porra: $porraLocal - $porraVisitante", // CORREGIDO el salto de línea roto
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
        Divider(color = Color(0xFFE0E0E0), thickness = 1.dp) // barritas
    }
}