package org.elcampico.porra_dam.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.components.CabeceraPorra
import org.elcampico.porra_dam.ui.components.FiltroPronosticos
import org.elcampico.porra_dam.ui.components.FondoPantalla
import org.elcampico.porra_dam.ui.components.TarjetaPartido
import org.elcampico.porra_dam.ui.theme.Grotesk
import org.elcampico.porra_dam.viewmodel.PorraViewModel

@Composable
fun Jornada(vm: PorraViewModel, modifier: Modifier = Modifier) {
    val sinPadding = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))

    FondoPantalla(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
            CabeceraPorra(puntos = vm.puntosTotales)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    "Jornada ${vm.jornadaActual}",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Grotesk,
                    style = sinPadding
                )
                Text(
                    "Tu porra para esta jornada",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = Grotesk,
                    fontWeight = FontWeight.W600,
                    style = sinPadding
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_calendario),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp),
                        tint = Color.White
                    )
                    Text(
                        "Se cierra el: ${vm.cierreActual}",
                        color = Color.White,
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA))
            ) {
                Column(modifier = Modifier.fillMaxSize()) {

                    FiltroPronosticos(
                        filtro = vm.filtro,
                        onFiltro = vm::filtrar,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                    )

                    LazyColumn(modifier = Modifier.weight(1f)) {
                        items(vm.visibles, key = { it.id }) { partido ->
                            TarjetaPartido(
                                partido = partido,
                                pronostico = vm.pronosticos[partido.id],
                                onCambio = vm::cambiar,
                                onBorrar = { vm.borrar(partido.id) }
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 15.dp, horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        OutlinedButton(
                            onClick = vm::limpiar,
                            modifier = Modifier.height(50.dp)
                        ) {
                            Text("Limpiar", fontFamily = Grotesk)
                        }
                        Button(
                            onClick = vm::guardar,
                            enabled = vm.sePuedeGuardar,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,
                                disabledContainerColor = Color.Gray
                            ),
                            modifier = Modifier
                                .height(50.dp)
                                .weight(1f)
                        ) {
                            Text(
                                if (vm.guardado) "Pronósticos guardados ✓" else "Guardar pronósticos",
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}