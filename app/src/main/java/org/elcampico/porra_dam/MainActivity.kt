package org.elcampico.porra_dam

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.ui.theme.Grotesk
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Porra_damTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaBienvenida(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaBienvenida(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = null, // decorativa
            contentScale = ContentScale.Crop, // llena y recorta
            modifier = Modifier.matchParentSize() // tamaño del Box
        )
        val scrim = Brush.verticalGradient(
            listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
        )
        Box(Modifier
            .matchParentSize()
            .background(scrim))

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 70.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
            Column() {
                Row{
                    Text("Porra",
                        color = Color(0xFFdfe6df),
                        fontFamily = Grotesk, fontSize = 60.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text("DAM",
                        color = Color(0xFFb8f2d6),
                        fontFamily = Grotesk,
                        fontSize = 60.sp,
                        modifier = Modifier.padding(horizontal = 15.dp),
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
                Text("Pronostica los partidos de cada jornada \ny compite con tu clase \n¿Quien acertará más?",
                    color = Color(0xFFdfe6df),
                    fontFamily = Grotesk, fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 21.sp //separación entre las lineas
                )
            }
            Card(Modifier
                .width(350.dp)
                .height(290.dp)
                .padding(top = 10.dp),
                shape = RoundedCornerShape(20.dp) //redondear el card

                ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    Column(modifier = Modifier
                        .padding(bottom = 15.dp)
                        .fillMaxWidth()
                        .height(75.dp)
                    ) {
                        Text("TU ALIAS",
                            fontFamily = Grotesk,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                            )
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .border(width = 2.dp, color = Color(0x396A6F7C), shape =RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_person),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Text("Escribe tu nombre o alias",
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                    ) {
                        Text("CÓDIGO DEL GRUPO",
                            fontFamily = Grotesk,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                        )

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .border(width = 2.dp, color = Color(0x396A6F7C), shape =RoundedCornerShape(10.dp))
                            .padding(horizontal = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_group),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                            Text("p. ej. 1A - DAM - 2026",
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black
                            ),
                        modifier = Modifier.padding(top = 20.dp).height(60.dp).fillMaxWidth(),

                        ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Entrar en la porra",
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