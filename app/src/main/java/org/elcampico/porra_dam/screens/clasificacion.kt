package org.elcampico.porra_dam.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.data.model.FilaClasificacion
import org.elcampico.porra_dam.ui.components.CabeceraPorra
import org.elcampico.porra_dam.ui.components.FiltroJornadaChips
import org.elcampico.porra_dam.ui.components.FondoPantalla
import org.elcampico.porra_dam.ui.theme.Grotesk
import org.elcampico.porra_dam.viewmodel.ClasificacionViewModel
import org.elcampico.porra_dam.viewmodel.PorraViewModel

@Composable
fun Clasificacion(
    alias: String,
    clasifVm: ClasificacionViewModel,
    porraVm: PorraViewModel,
    modifier: Modifier = Modifier
) {
    val filas = clasifVm.tabla(alias, porraVm.puntosPorJornada)

    FondoPantalla(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
            CabeceraPorra(puntos = porraVm.puntosTotales)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 15.dp),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA))
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        "Clasificación",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Grotesk,
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 8.dp)
                    )

                    FiltroJornadaChips(
                        jornadas = porraVm.jornadasJugadas,
                        filtro = clasifVm.filtroJornada,
                        onFiltro = clasifVm::filtrar,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("#", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.width(36.dp))
                        Text("Participante", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.weight(1f))
                        Text("Puntos", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.width(50.dp))
                    }

                    HorizontalDivider(thickness = 1.dp, color = Color(0xFFF1F3F4))

                    LazyColumn(modifier = Modifier.weight(1f)) {
                        itemsIndexed(filas, key = { _, fila -> fila.id }) { indice, fila ->
                            _FilaClasificacion(posicion = indice + 1, fila = fila)
                        }
                    }
                }
            }
        }
    }
}

private val paletaAvatares = listOf(
    Color(0xFFE8DEF8) to Color(0xFF6750A4),
    Color(0xFFD3E3FD) to Color(0xFF041E49),
    Color(0xFFFFDF99) to Color(0xFF421F00)
)

@Composable
fun _FilaClasificacion(posicion: Int, fila: FilaClasificacion) {
    val (colorPosicion, fondoPosicion) = when (posicion) {
        1 -> Color(0xFFF9A825) to Color(0x1AF9A825)
        2 -> Color(0xFF9E9E9E) to Color(0x1A9E9E9E)
        3 -> Color(0xFFD84315) to Color(0x1AD84315)
        else -> Color.Black to Color.Transparent
    }
    val (fondoAvatar, textoAvatar) =
        if (fila.esYo) Color(0xFFC4EED0) to Color(0xFF072711)
        else paletaAvatares[(fila.nombre.length) % paletaAvatares.size]

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (fila.esYo) Color(0xFFE6F4EA) else Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .background(fondoPosicion, shape = CircleShape)
            ) {
                Text(
                    "$posicion",
                    fontFamily = Grotesk,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = colorPosicion
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .background(fondoAvatar, shape = CircleShape)
            ) {
                Text(
                    fila.nombre.take(1).uppercase(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = textoAvatar
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                fila.nombre,
                fontFamily = Grotesk,
                fontSize = 15.sp,
                fontWeight = if (fila.esYo) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.Default.EmojiEvents,
                contentDescription = null,
                tint = if (posicion == 1) Color(0xFFF9A825) else Color.Transparent,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 8.dp)
            )

            Text(
                "${fila.puntos}",
                fontFamily = Grotesk,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.width(50.dp)
            )
        }
        if (!fila.esYo) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Color(0xFFF1F3F4),
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}