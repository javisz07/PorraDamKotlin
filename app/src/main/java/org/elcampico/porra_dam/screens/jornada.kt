package org.elcampico.porra_dam.screens


import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.components.FondoPantalla
import org.elcampico.porra_dam.ui.theme.Grotesk
import org.w3c.dom.Text

@Composable
fun Jornada(modifier: Modifier = Modifier){
    FondoPantalla(modifier = modifier) {
        Column(modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 0.dp)
            .fillMaxSize()) {
            Row(modifier = Modifier
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

                Text("Porra DAM",
                    fontSize = 30.sp,
                    fontFamily = Grotesk,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Card (
                    modifier = Modifier
                        .height(28.dp)
                        .width(60.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFc7ead6) // <-- Así se da color a un Card
                    )

                ){
                    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
                        Text("30 ", fontWeight = FontWeight.Bold, color = Color.White)
                        Text("pts", fontWeight = FontWeight.Bold, color = Color(0xFF3A9D08))
                    }
                }

            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            ) {
                Text("Jornada 1",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Grotesk,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Text("Tu porra para esta jornada",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = Grotesk,
                    fontWeight = FontWeight.W600,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )

                )

                Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)) {
                    Icon(
                        painter = painterResource(R.drawable.ic_calendario),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp),
                        tint = Color.White
                    )

                    Text("Se cierra el: Sáb 12 oct · 16:00",
                        color = Color.White,
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF8F9FA)
                )

            ){
                Column() {
                    _Partidos(escudoLocal = R.drawable.real_madrid, nombreLocal = "Real Madrid", escudVisitante = R.drawable.atletico_madrid, nombreVisitante = "Atlético de Madrid")
                    _Partidos(escudoLocal = R.drawable.real_madrid, nombreLocal = "Real Madrid", escudVisitante = R.drawable.atletico_madrid, nombreVisitante = "Atlético de Madrid")
                    _Partidos(escudoLocal = R.drawable.real_madrid, nombreLocal = "Real Madrid", escudVisitante = R.drawable.atletico_madrid, nombreVisitante = "Atlético de Madrid")
                    _Partidos(escudoLocal = R.drawable.real_madrid, nombreLocal = "Real Madrid", escudVisitante = R.drawable.atletico_madrid, nombreVisitante = "Atlético de Madrid")
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black
                        ),
                        modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp).height(50.dp).fillMaxWidth(),

                        ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "Guardar pronósticos",
                                fontFamily = Grotesk,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun _Partidos(escudoLocal: Int, nombreLocal: String, escudVisitante: Int, nombreVisitante: String){

    var _golesLocal by remember { mutableStateOf( 0 ) }
    var _golesVisitante by remember { mutableStateOf( 0 ) }


    Card(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
        .padding(top = 14.dp)
        .padding(horizontal = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5) // <-- Así se da color a un Card
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 7.dp)
                    .padding( horizontal = 8.dp)
                    .fillMaxWidth()

            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(escudoLocal),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text("Real Madrid",
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.W600,
                        letterSpacing = (0).sp
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.height(30.dp)
                        .width(140.dp)
                        .padding(horizontal = 12.dp)
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFFFBFBFC), shape = RoundedCornerShape(10.dp))



                ) {
                    Text("$_golesLocal",
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.Bold,
                        )


                    Icon(
                        painter = painterResource(R.drawable.ic_bajar),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp).clickable{
                            if (_golesLocal > 0 ){
                                _golesLocal --
                            }
                        },
                        tint = Color.Black
                    )

                    Icon(
                        painter = painterResource(R.drawable.ic_subir),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp).clickable{
                            _golesLocal++
                        },
                        tint = Color.Black
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 0.dp)
                    .padding( horizontal = 8.dp)
                    .fillMaxWidth()

            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(escudVisitante),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text("$nombreVisitante",
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.W600,
                        letterSpacing = (0).sp
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.height(30.dp)
                        .width(140.dp)
                        .padding(horizontal = 12.dp)
                        .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFFFBFBFC), shape = RoundedCornerShape(10.dp))



                ) {
                    Text("$_golesVisitante",
                        fontFamily = Grotesk,
                        fontWeight = FontWeight.Bold,
                    )


                    Icon(
                        painter = painterResource(R.drawable.ic_bajar),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp).clickable{
                            if (_golesVisitante > 0 ){
                                _golesVisitante --
                            }
                        },
                        tint = Color.Black
                    )

                    Icon(
                        painter = painterResource(R.drawable.ic_subir),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp).clickable{
                            _golesVisitante++
                        },
                        tint = Color.Black
                    )
                }
            }
        }
    }
}