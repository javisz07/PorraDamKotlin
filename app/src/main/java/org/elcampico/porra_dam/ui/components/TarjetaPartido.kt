package org.elcampico.porra_dam.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.data.Escudos
import org.elcampico.porra_dam.data.model.Partido
import org.elcampico.porra_dam.data.model.Pronostico
import org.elcampico.porra_dam.ui.theme.Grotesk

@Composable
fun TarjetaPartido(
    partido: Partido,
    pronostico: Pronostico?,
    onCambio: (Pronostico) -> Unit,
    onBorrar: () -> Unit
) {
    val local = pronostico?.golesLocal
    val visitante = pronostico?.golesVisitante

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)) {
            FilaEquipo(
                escudo = partido.escudoLocal,
                nombre = partido.local,
                goles = local,
                onCambio = { nuevo -> onCambio(Pronostico(partido.id, nuevo, visitante ?: 0)) }
            )
            FilaEquipo(
                escudo = partido.escudoVisitante,
                nombre = partido.visitante,
                goles = visitante,
                onCambio = { nuevo -> onCambio(Pronostico(partido.id, local ?: 0, nuevo)) }
            )
            if (pronostico != null) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = onBorrar) {
                        Text("Borrar", fontFamily = Grotesk)
                    }
                }
            }
        }
    }
}

@Composable
private fun FilaEquipo(escudo: String, nombre: String, goles: Int?, onCambio: (Int) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(Escudos.id(escudo)),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                nombre,
                fontFamily = Grotesk,
                fontWeight = FontWeight.W600,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        SelectorGoles(goles = goles, onCambio = onCambio)
    }
}

// goles == null  ->  todavía sin pronóstico (se muestra "-")
@Composable
private fun SelectorGoles(goles: Int?, onCambio: (Int) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .height(30.dp)
            .width(140.dp)
            .padding(horizontal = 12.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFFBFBFC), shape = RoundedCornerShape(10.dp))
    ) {
        Text(
            goles?.toString() ?: "-",
            fontFamily = Grotesk,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(R.drawable.ic_bajar),
            contentDescription = "Bajar",
            modifier = Modifier
                .size(25.dp)
                .clickable { onCambio(if (goles == null) 0 else maxOf(0, goles - 1)) },
            tint = Color.Black
        )
        Icon(
            painter = painterResource(R.drawable.ic_subir),
            contentDescription = "Subir",
            modifier = Modifier
                .size(25.dp)
                .clickable { onCambio((goles ?: -1) + 1) },
            tint = Color.Black
        )
    }
}