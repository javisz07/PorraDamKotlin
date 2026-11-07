package org.elcampico.porra_dam.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.components.FondoPantalla
import org.elcampico.porra_dam.ui.theme.Grotesk

@Composable
fun PantallaBienvenida(
    onEntrar: (alias: String) -> Unit,
    modifier: Modifier = Modifier,

) {
    var aliasTexto by remember { mutableStateOf("") }
    var codigoTexto by remember { mutableStateOf("") }
    FondoPantalla(Modifier.fillMaxSize()) {
        Box() {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Column() {
                    Row {
                        Text(
                            "Porra",
                            color = Color(0xFFdfe6df),
                            fontFamily = Grotesk, fontSize = 60.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Text(
                            "DAM",
                            color = Color(0xFFb8f2d6),
                            fontFamily = Grotesk,
                            fontSize = 60.sp,
                            modifier = Modifier.padding(horizontal = 15.dp),
                            fontWeight = FontWeight.ExtraBold,
                        )
                    }
                    Text(
                        "Pronostica los partidos de cada jornada \ny compite con tu clase \n¿Quien acertará más?",
                        color = Color(0xFFdfe6df),
                        fontFamily = Grotesk, fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 21.sp //separación entre las lineas
                    )
                }
                Card(
                    Modifier
                        .width(350.dp)
                        .height(320.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(20.dp) //redondear el card

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp, vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                                .fillMaxWidth()
                                .height(75.dp)
                        ) {
                            Text(
                                "TU ALIAS",
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .border(
                                        width = 2.dp,
                                        color = Color(0x396A6F7C),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(horizontal = 12.dp),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_person),
                                    contentDescription = null,
                                    modifier = Modifier.size(30.dp)
                                )
                                TextField(
                                    value = aliasTexto,
                                    onValueChange = { aliasTexto = it }, // Esto actualiza tu variable cuando escriben
                                    placeholder = {
                                        Text(
                                            "Escribe tu nombre o alias",
                                            fontFamily = Grotesk,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Gray
                                        )
                                    },
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )

                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(75.dp)
                        ) {
                            Text(
                                "CÓDIGO DEL GRUPO",
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .border(
                                        width = 2.dp,
                                        color = Color(0x396A6F7C),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(horizontal = 12.dp),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_group),
                                    contentDescription = null,
                                    modifier = Modifier.size(30.dp)
                                )
                                Text(
                                    "p. ej. 1A - DAM - 2026",
                                    fontFamily = Grotesk,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                        Button(
                            onClick = { onEntrar(aliasTexto)},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            ),
                            modifier = Modifier.padding(top = 20.dp).height(60.dp).fillMaxWidth(),

                            ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "Entrar en la porra",
                                    fontFamily = Grotesk,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 10.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.ic_flecha),
                                    contentDescription = null,
                                    modifier = Modifier.size(30.dp),
                                    tint = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}