package org.elcampico.porra_dam.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Clasificacion(modifier: Modifier = Modifier) {
    FondoPantalla(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
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
                            .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Clasificación",
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
                                "General",
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

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "#",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.width(36.dp)
                        )
                        Text(
                            "Participante",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            "Puntos",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.width(50.dp)
                        )
                    }

                    Divider(color = Color(0xFFF1F3F4), thickness = 1.dp)

                    LazyColumn(modifier = Modifier.weight(1f)) {
                        item {
                            _FilaClasificacion(
                                textoPosicion = "1",
                                colorTextoPosicion = Color(0xFFF9A825),
                                colorFondoPosicion = Color(0x1AF9A825),
                                textoAvatar = "J",
                                colorFondoAvatar = Color(0xFFE8DEF8),
                                colorTextoAvatar = Color(0xFF6750A4),
                                nombre = "Javier F",
                                pesoFuenteNombre = FontWeight.Normal,
                                puntos = "45",
                                colorFondoFila = Color.Transparent,
                                colorCorona = Color(0xFFF9A825),
                                colorSeparador = Color(0xFFF1F3F4)
                            )

                            _FilaClasificacion(
                                textoPosicion = "2",
                                colorTextoPosicion = Color(0xFF9E9E9E),
                                colorFondoPosicion = Color(0x1A9E9E9E),
                                textoAvatar = "G",
                                colorFondoAvatar = Color(0xFFD3E3FD),
                                colorTextoAvatar = Color(0xFF041E49),
                                nombre = "Gonzalo",
                                pesoFuenteNombre = FontWeight.Normal,
                                puntos = "41",
                                colorFondoFila = Color.Transparent,
                                colorCorona = Color.Transparent,
                                colorSeparador = Color(0xFFF1F3F4)
                            )

                            _FilaClasificacion(
                                textoPosicion = "3",
                                colorTextoPosicion = Color(0xFFD84315),
                                colorFondoPosicion = Color(0x1AD84315),
                                textoAvatar = "C",
                                colorFondoAvatar = Color(0xFFFFDF99),
                                colorTextoAvatar = Color(0xFF421F00),
                                nombre = "Cristian",
                                pesoFuenteNombre = FontWeight.Normal,
                                puntos = "40",
                                colorFondoFila = Color.Transparent,
                                colorCorona = Color.Transparent,
                                colorSeparador = Color(0xFFF1F3F4)
                            )

                            _FilaClasificacion(
                                textoPosicion = "4",
                                colorTextoPosicion = Color.Black,
                                colorFondoPosicion = Color.Transparent,
                                textoAvatar = "T",
                                colorFondoAvatar = Color(0xFFC4EED0),
                                colorTextoAvatar = Color(0xFF072711),
                                nombre = "Tú",
                                pesoFuenteNombre = FontWeight.Bold,
                                puntos = "38",
                                colorFondoFila = Color(0xFFE6F4EA),
                                colorCorona = Color.Transparent,
                                colorSeparador = Color.Transparent
                            )
                        }
                    }
                }
            }
        }
    }
}

// Componente puramente de maquetación, 0% lógica
@Composable
fun _FilaClasificacion(
    textoPosicion: String,
    colorTextoPosicion: Color,
    colorFondoPosicion: Color,
    textoAvatar: String,
    colorFondoAvatar: Color,
    colorTextoAvatar: Color,
    nombre: String,
    pesoFuenteNombre: FontWeight,
    puntos: String,
    colorFondoFila: Color,
    colorCorona: Color,
    colorSeparador: Color
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(colorFondoFila)
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
                    .width(36.dp)
                    .height(36.dp)
                    .background(colorFondoPosicion, shape = CircleShape)
            ) {
                Text(
                    text = textoPosicion,
                    fontFamily = Grotesk,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = colorTextoPosicion
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .background(colorFondoAvatar, shape = CircleShape)
            ) {
                Text(
                    text = textoAvatar,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorTextoAvatar
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = nombre,
                fontFamily = Grotesk,
                fontSize = 15.sp,
                fontWeight = pesoFuenteNombre,
                modifier = Modifier.weight(1f)
            )


            Icon(
                Icons.Default.EmojiEvents,
                contentDescription = null,
                tint = colorCorona,
                modifier = Modifier.size(20.dp).padding(end = 8.dp)
            )

            // 5. Puntos
            Text(
                text = puntos,
                fontFamily = Grotesk,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.width(50.dp)
            )
        }

        Divider(color = colorSeparador, thickness = 1.dp, modifier = Modifier.padding(horizontal = 24.dp))
    }
}